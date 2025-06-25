<template>
    <div>
        <Number
            label="ApprovalId"
            v-model="value.approvalId"
            :editMode="editMode"
        />
        <Date
            label="DecidedAt"
            v-model="value.decidedAt"
            :editMode="editMode"
        />
        <Number
            label="DecidedBy"
            v-model="value.decidedBy"
            :editMode="editMode"
        />
        <String
            label="Reason"
            v-model="value.reason"
            :editMode="editMode"
        />
        <ApprovalDecision
            offline
            label="Decision"
            v-model="value.decision"
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
    name: 'AuthorApproval',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "authorApprovals",
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
