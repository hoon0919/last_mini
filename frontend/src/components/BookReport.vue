<template>
    <div>
        <Number
            label="ReportId"
            v-model="value.reportId"
            :editMode="editMode"
        />
        <Number
            label="ReporterId"
            v-model="value.reporterId"
            :editMode="editMode"
        />
        <String
            label="Reason"
            v-model="value.reason"
            :editMode="editMode"
        />
        <Date
            label="ReportedAt"
            v-model="value.reportedAt"
            :editMode="editMode"
        />
        <ReportStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
        />
        <BookId
            offline
            label="서적 ID"
            v-model="value.bookId"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'BookReport',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "bookReports",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
