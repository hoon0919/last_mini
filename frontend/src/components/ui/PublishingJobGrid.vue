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
                <v-btn style="margin-left: 5px;" @click="failPublishingDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>출간 실패 처리
                </v-btn>
                <v-dialog v-model="failPublishingDialog" width="500">
                    <FailPublishing
                        @closeDialog="failPublishingDialog = false"
                        @failPublishing="failPublishing"
                    ></FailPublishing>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="requestPublishingDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Author')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>출간 요청
                </v-btn>
                <v-dialog v-model="requestPublishingDialog" width="500">
                    <RequestPublishing
                        @closeDialog="requestPublishingDialog = false"
                        @requestPublishing="requestPublishing"
                    ></RequestPublishing>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="completePublishingDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>출간 완료 처리
                </v-btn>
                <v-dialog v-model="completePublishingDialog" width="500">
                    <CompletePublishing
                        @closeDialog="completePublishingDialog = false"
                        @completePublishing="completePublishing"
                    ></CompletePublishing>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="generateAiSummaryDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>AI 요약 생성
                </v-btn>
                <v-dialog v-model="generateAiSummaryDialog" width="500">
                    <GenerateAiSummary
                        @closeDialog="generateAiSummaryDialog = false"
                        @generateAiSummary="generateAiSummary"
                    ></GenerateAiSummary>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="generateAiCoverDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>AI 표지 생성
                </v-btn>
                <v-dialog v-model="generateAiCoverDialog" width="500">
                    <GenerateAiCover
                        @closeDialog="generateAiCoverDialog = false"
                        @generateAiCover="generateAiCover"
                    ></GenerateAiCover>
                </v-dialog>
            </div>
            <PublishingJobStatusList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PublishingJobStatusList>
            <PublishingJobDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PublishingJobDetails>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ContentId</th>
                        <th>Status</th>
                        <th>CoverImageUrl</th>
                        <th>SummaryText</th>
                        <th>ProductId</th>
                        <th>RequestedAt</th>
                        <th>CompletedAt</th>
                        <th>작가 ID</th>
                        <th>원고 ID</th>
                        <th>작가</th>
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
                            <td class="whitespace-nowrap" label="ContentId">{{ val.contentId }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="CoverImageUrl">{{ val.coverImageUrl }}</td>
                            <td class="whitespace-nowrap" label="SummaryText">{{ val.summaryText }}</td>
                            <td class="whitespace-nowrap" label="ProductId">{{ val.productId }}</td>
                            <td class="whitespace-nowrap" label="RequestedAt">{{ val.requestedAt }}</td>
                            <td class="whitespace-nowrap" label="CompletedAt">{{ val.completedAt }}</td>
                            <td class="whitespace-nowrap" label="작가">
                                <AuthorId :editMode="editMode" v-model="val.authorId"></AuthorId>
                            </td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">PublishingJob 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <PublishingJob :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">PublishingJob 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="PublishingJobId" v-model="selectedRow.publishingJobId" :editMode="true"/>
                            <String label="ContentId" v-model="selectedRow.contentId" :editMode="true"/>
                            <String label="CoverImageUrl" v-model="selectedRow.coverImageUrl" :editMode="true"/>
                            <String label="SummaryText" v-model="selectedRow.summaryText" :editMode="true"/>
                            <String label="ProductId" v-model="selectedRow.productId" :editMode="true"/>
                            <Date label="RequestedAt" v-model="selectedRow.requestedAt" :editMode="true"/>
                            <Date label="CompletedAt" v-model="selectedRow.completedAt" :editMode="true"/>
                            <PublishingJobStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <AuthorId offline label="작가 ID" v-model="selectedRow.authorId" :editMode="true"/>
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
    name: 'publishingJobGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'publishingJobs',
        failPublishingDialog: false,
        requestPublishingDialog: false,
        completePublishingDialog: false,
        generateAiSummaryDialog: false,
        generateAiCoverDialog: false,
    }),
    watch: {
    },
    methods:{
        async failPublishing(params){
            try{
                var path = "failPublishing".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','FailPublishing 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.failPublishingDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async requestPublishing(params){
            try{
                var path = "requestPublishing".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RequestPublishing 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.requestPublishingDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async completePublishing(params){
            try{
                var path = "completePublishing".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CompletePublishing 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.completePublishingDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async generateAiSummary(params){
            try{
                var path = "generateAiSummary".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','GenerateAISummary 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.generateAiSummaryDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async generateAiCover(params){
            try{
                var path = "generateAiCover".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','GenerateAICover 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.generateAiCoverDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>