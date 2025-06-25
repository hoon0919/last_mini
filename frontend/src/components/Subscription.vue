<template>
    <div>
        <String
            label="SubscriptionId"
            v-model="value.subscriptionId"
            :editMode="editMode"
        />
        <Date
            label="StartDate"
            v-model="value.startDate"
            :editMode="editMode"
        />
        <Date
            label="EndDate"
            v-model="value.endDate"
            :editMode="editMode"
        />
        <PlanType
            offline
            label="PlanType"
            v-model="value.planType"
            :editMode="editMode"
            @change="change"
        />
        <SubscriptionStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
        />
        <SubscriberId
            offline
            label="구독자 ID"
            v-model="value.subscriberId"
            :editMode="editMode"
            @change="change"
        />
        <PaymentId
            offline
            label="결제 ID"
            v-model="value.paymentId"
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
    name: 'Subscription',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "subscriptions",
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
