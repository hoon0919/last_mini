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
                <v-btn style="margin-left: 5px;" @click="registerSubscriberDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Subscriber')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>회원 가입
                </v-btn>
                <v-dialog v-model="registerSubscriberDialog" width="500">
                    <RegisterSubscriber
                        @closeDialog="registerSubscriberDialog = false"
                        @registerSubscriber="registerSubscriber"
                    ></RegisterSubscriber>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="usePointForBookDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Subscriber')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>포인트로 도서 열람
                </v-btn>
                <v-dialog v-model="usePointForBookDialog" width="500">
                    <UsePointForBook
                        @closeDialog="usePointForBookDialog = false"
                        @usePointForBook="usePointForBook"
                    ></UsePointForBook>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="verifyKtMemberDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Subscriber')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>KT 고객 인증
                </v-btn>
                <v-dialog v-model="verifyKtMemberDialog" width="500">
                    <VerifyKtMember
                        @closeDialog="verifyKtMemberDialog = false"
                        @verifyKtMember="verifyKtMember"
                    ></VerifyKtMember>
                </v-dialog>
            </div>
            <SubscriberDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></SubscriberDetails>
            <PointTransactionHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PointTransactionHistory>
            <PointExhaustedAlert @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PointExhaustedAlert>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>PhoneNumber</th>
                        <th>KtVerified</th>
                        <th>PointBalance</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="Name">{{ val.name }}</td>
                            <td class="whitespace-nowrap" label="PhoneNumber">{{ val.phoneNumber }}</td>
                            <td class="whitespace-nowrap" label="KtVerified">{{ val.ktVerified }}</td>
                            <td class="whitespace-nowrap" label="PointBalance">{{ val.pointBalance }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Subscriber 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Subscriber :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Subscriber 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="SubscriberId" v-model="selectedRow.subscriberId" :editMode="true"/>
                            <String label="Name" v-model="selectedRow.name" :editMode="true"/>
                            <String label="PhoneNumber" v-model="selectedRow.phoneNumber" :editMode="true"/>
                            <Boolean label="KtVerified" v-model="selectedRow.ktVerified" :editMode="true"/>
                            <Number label="PointBalance" v-model="selectedRow.pointBalance" :editMode="true"/>
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
    name: 'subscriberGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'subscribers',
        registerSubscriberDialog: false,
        usePointForBookDialog: false,
        verifyKtMemberDialog: false,
    }),
    watch: {
    },
    methods:{
        async registerSubscriber(params){
            try{
                var path = "registerSubscriber".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RegisterSubscriber 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.registerSubscriberDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async usePointForBook(params){
            try{
                var path = "usePointForBook".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','UsePointForBook 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.usePointForBookDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async verifyKtMember(params){
            try{
                var path = "verifyKtMember".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','VerifyKTMember 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.verifyKtMemberDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>