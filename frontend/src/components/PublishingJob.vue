<template>
    <div>
        <String
            label="PublishingJobId"
            v-model="value.publishingJobId"
            :editMode="editMode"
        />
        <String
            label="ContentId"
            v-model="value.contentId"
            :editMode="editMode"
        />
        <String
            label="CoverImageUrl"
            v-model="value.coverImageUrl"
            :editMode="editMode"
        />
        <String
            label="SummaryText"
            v-model="value.summaryText"
            :editMode="editMode"
        />
        <String
            label="ProductId"
            v-model="value.productId"
            :editMode="editMode"
        />
        <Date
            label="RequestedAt"
            v-model="value.requestedAt"
            :editMode="editMode"
        />
        <Date
            label="CompletedAt"
            v-model="value.completedAt"
            :editMode="editMode"
        />
        <PublishingJobStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
        />
        <AuthorId
            offline
            label="작가 ID"
            v-model="value.authorId"
            :editMode="editMode"
            @change="change"
        />
        <ManuscriptId
            offline
            label="원고 ID"
            v-model="value.manuscriptId"
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
    name: 'PublishingJob',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "publishingJobs",
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
