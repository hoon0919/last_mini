<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="requestPointPaymentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Subscriber')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>포인트 결제 요청
                </v-btn>
                <v-dialog v-model="requestPointPaymentDialog" width="500">
                    <RequestPointPayment
                        @closeDialog="requestPointPaymentDialog = false"
                        @requestPointPayment="requestPointPayment"
                    ></RequestPointPayment>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="completePaymentDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>결제 완료 처리
                </v-btn>
                <v-dialog v-model="completePaymentDialog" width="500">
                    <CompletePayment
                        @closeDialog="completePaymentDialog = false"
                        @completePayment="completePayment"
                    ></CompletePayment>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="requestCardPaymentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Subscriber')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>카드 결제 요청
                </v-btn>
                <v-dialog v-model="requestCardPaymentDialog" width="500">
                    <RequestCardPayment
                        @closeDialog="requestCardPaymentDialog = false"
                        @requestCardPayment="requestCardPayment"
                    ></RequestCardPayment>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="failPaymentDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>결제 실패 처리
                </v-btn>
                <v-dialog v-model="failPaymentDialog" width="500">
                    <FailPayment
                        @closeDialog="failPaymentDialog = false"
                        @failPayment="failPayment"
                    ></FailPayment>
                </v-dialog>
            </div>
            <PaymentHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PaymentHistory>
            <PaymentDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PaymentDetails>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>SubscriberId</th>
                        <th>Amount</th>
                        <th>Method</th>
                        <th>Status</th>
                        <th>Timestamp</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="SubscriberId">{{ val.subscriberId }}</td>
                            <td class="whitespace-nowrap" label="Amount">{{ val.amount }}</td>
                            <td class="whitespace-nowrap" label="Method">{{ val.method }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="Timestamp">{{ val.timestamp }}</td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Payment 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Payment :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Payment 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="PaymentId" v-model="selectedRow.paymentId" :editMode="true"/>
                            <String label="SubscriberId" v-model="selectedRow.subscriberId" :editMode="true"/>
                            <Number label="Amount" v-model="selectedRow.amount" :editMode="true"/>
                            <Date label="Timestamp" v-model="selectedRow.timestamp" :editMode="true"/>
                            <PaymentMethod offline label="Method" v-model="selectedRow.method" :editMode="true"/>
                            <PaymentStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'paymentGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'payments',
        requestPointPaymentDialog: false,
        completePaymentDialog: false,
        requestCardPaymentDialog: false,
        failPaymentDialog: false,
    }),
    watch: {
    },
    methods:{
        async requestPointPayment(params){
            try{
                var path = "requestPointPayment".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RequestPointPayment 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.requestPointPaymentDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async completePayment(params){
            try{
                var path = "completePayment".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CompletePayment 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.completePaymentDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async requestCardPayment(params){
            try{
                var path = "requestCardPayment".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RequestCardPayment 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.requestCardPaymentDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async failPayment(params){
            try{
                var path = "failPayment".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','FailPayment 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.failPaymentDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>