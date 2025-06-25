<template>
    <div>
        <Number
            label="PublicationHistoryId"
            v-model="value.publicationHistoryId"
            :editMode="editMode"
        />
        <Date
            label="RequestedAt"
            v-model="value.requestedAt"
            :editMode="editMode"
        />
        <String
            label="ResultMessage"
            v-model="value.resultMessage"
            :editMode="editMode"
        />
        <Date
            label="PublishedAt"
            v-model="value.publishedAt"
            :editMode="editMode"
        />
        <PublicationResultStatus
            offline
            label="ResultStatus"
            v-model="value.resultStatus"
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
    name: 'PublicationHistory',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "publicationHistories",
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
