<template>
    <div>
        <String
            label="TransactionId"
            v-model="value.transactionId"
            :editMode="editMode"
        />
        <String
            label="SubscriberId"
            v-model="value.subscriberId"
            :editMode="editMode"
        />
        <Number
            label="Amount"
            v-model="value.amount"
            :editMode="editMode"
        />
        <Date
            label="CreatedAt"
            v-model="value.createdAt"
            :editMode="editMode"
        />
        <Number
            offline
            label="Type"
            v-model="value.type"
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
    name: 'PointTransaction',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "pointTransactions",
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
