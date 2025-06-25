<template>

    <v-card outlined>
        <v-card-title>
            RequestCardPayment
        </v-card-title>

        <v-card-text>
            <SubscriberId offline label="SubscriberId" v-model="value.subscriberId" :editMode="editMode" @change="change"/>
            <Number label="Amount" v-model="value.amount" :editMode="editMode"/>
            <PaymentMethod offline label="PaymentMethod" v-model="value.paymentMethod" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="requestCardPayment"
            >
                RequestCardPayment
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
    name: 'RequestCardPaymentCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.subscriberId = {};
        this.value.amount = 0;
        this.value.paymentMethod = {};
    },
    watch: {
    },
    methods: {
        requestCardPayment() {
            this.$emit('requestCardPayment', this.value);
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

