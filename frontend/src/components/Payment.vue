<template>
    <div>
        <String
            label="PaymentId"
            v-model="value.paymentId"
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
            label="Timestamp"
            v-model="value.timestamp"
            :editMode="editMode"
        />
        <PaymentMethod
            offline
            label="Method"
            v-model="value.method"
            :editMode="editMode"
            @change="change"
        />
        <PaymentStatus
            offline
            label="Status"
            v-model="value.status"
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
    name: 'Payment',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "payments",
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
