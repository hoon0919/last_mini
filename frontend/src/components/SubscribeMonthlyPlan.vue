<template>

    <v-card outlined>
        <v-card-title>
            SubscribeMonthlyPlan
        </v-card-title>

        <v-card-text>
            <SubscriberId offline label="SubscriberId" v-model="value.subscriberId" :editMode="editMode" @change="change"/>
            <PlanType offline label="PlanType" v-model="value.planType" :editMode="editMode" @change="change"/>
            <PaymentMethod offline label="PaymentMethod" v-model="value.paymentMethod" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="subscribeMonthlyPlan"
            >
                SubscribeMonthlyPlan
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'SubscribeMonthlyPlanCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.subscriberId = {};
        this.value.planType = {};
        this.value.paymentMethod = {};
    },
    watch: {
    },
    methods: {
        subscribeMonthlyPlan() {
            this.$emit('subscribeMonthlyPlan', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

