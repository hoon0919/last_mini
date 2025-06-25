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
                <v-btn style="margin-left: 5px;" @click="createPublicationHistoryDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Author')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>출간 이력 생성
                </v-btn>
                <v-dialog v-model="createPublicationHistoryDialog" width="500">
                    <CreatePublicationHistory
                        @closeDialog="createPublicationHistoryDialog = false"
                        @createPublicationHistory="createPublicationHistory"
                    ></CreatePublicationHistory>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="updatePublicationStatusDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>출간 상태 갱신
                </v-btn>
                <v-dialog v-model="updatePublicationStatusDialog" width="500">
                    <UpdatePublicationStatus
                        @closeDialog="updatePublicationStatusDialog = false"
                        @updatePublicationStatus="updatePublicationStatus"
                    ></UpdatePublicationStatus>
                </v-dialog>
            </div>
            <PublicationHistoryList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PublicationHistoryList>
            <PublicationHistoryDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PublicationHistoryDetails>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>RequestedAt</th>
                        <th>ResultStatus</th>
                        <th>ResultMessage</th>
                        <th>PublishedAt</th>
                        <th>원고 ID</th>
                        <th>원고</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="RequestedAt">{{ val.requestedAt }}</td>
                            <td class="whitespace-nowrap" label="ResultStatus">{{ val.resultStatus }}</td>
                            <td class="whitespace-nowrap" label="ResultMessage">{{ val.resultMessage }}</td>
                            <td class="whitespace-nowrap" label="PublishedAt">{{ val.publishedAt }}</td>
                            <td class="whitespace-nowrap" label="원고">
                                <ManuscriptId :editMode="editMode" v-model="val.manuscriptId"></ManuscriptId>
                            </td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">PublicationHistory 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <PublicationHistory :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">PublicationHistory 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="PublicationHistoryId" v-model="selectedRow.publicationHistoryId" :editMode="true"/>
                            <Date label="RequestedAt" v-model="selectedRow.requestedAt" :editMode="true"/>
                            <String label="ResultMessage" v-model="selectedRow.resultMessage" :editMode="true"/>
                            <Date label="PublishedAt" v-model="selectedRow.publishedAt" :editMode="true"/>
                            <PublicationResultStatus offline label="ResultStatus" v-model="selectedRow.resultStatus" :editMode="true"/>
                            <ManuscriptId offline label="원고 ID" v-model="selectedRow.manuscriptId" :editMode="true"/>
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
    name: 'publicationHistoryGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'publicationHistories',
        createPublicationHistoryDialog: false,
        updatePublicationStatusDialog: false,
    }),
    watch: {
    },
    methods:{
        async createPublicationHistory(params){
            try{
                var path = "createPublicationHistory".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CreatePublicationHistory 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.createPublicationHistoryDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async updatePublicationStatus(params){
            try{
                var path = "updatePublicationStatus".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','UpdatePublicationStatus 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.updatePublicationStatusDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>