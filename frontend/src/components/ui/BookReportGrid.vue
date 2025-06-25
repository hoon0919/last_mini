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
                <v-btn style="margin-left: 5px;" @click="createBookReportDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Admin')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>서적 신고 생성
                </v-btn>
                <v-dialog v-model="createBookReportDialog" width="500">
                    <CreateBookReport
                        @closeDialog="createBookReportDialog = false"
                        @createBookReport="createBookReport"
                    ></CreateBookReport>
                </v-dialog>
            </div>
            <BookReportDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></BookReportDetails>
            <BookReportList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></BookReportList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ReporterId</th>
                        <th>Reason</th>
                        <th>ReportedAt</th>
                        <th>Status</th>
                        <th>서적 ID</th>
                        <th>서적</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="ReporterId">{{ val.reporterId }}</td>
                            <td class="whitespace-nowrap" label="Reason">{{ val.reason }}</td>
                            <td class="whitespace-nowrap" label="ReportedAt">{{ val.reportedAt }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="서적">
                                <BookId :editMode="editMode" v-model="val.bookId"></BookId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">BookReport 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <BookReport :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">BookReport 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="ReportId" v-model="selectedRow.reportId" :editMode="true"/>
                            <Number label="ReporterId" v-model="selectedRow.reporterId" :editMode="true"/>
                            <String label="Reason" v-model="selectedRow.reason" :editMode="true"/>
                            <Date label="ReportedAt" v-model="selectedRow.reportedAt" :editMode="true"/>
                            <ReportStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <BookId offline label="서적 ID" v-model="selectedRow.bookId" :editMode="true"/>
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
    name: 'bookReportGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'bookReports',
        createBookReportDialog: false,
    }),
    watch: {
    },
    methods:{
        async createBookReport(params){
            try{
                var path = "createBookReport".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CreateBookReport 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.createBookReportDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>