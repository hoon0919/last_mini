<template>

    <v-card outlined>
        <v-card-title>
            CompletePayment
        </v-card-title>

        <v-card-text>
            <String label="PaymentId" v-model="value.paymentId" :editMode="editMode"/>
            <PaymentStatus offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
            <Date label="Timestamp" v-model="value.timestamp" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="completePayment"
            >
                CompletePayment
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
    name: 'CompletePaymentCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.paymentId = '';
        this.value.status = {};
        this.value.timestamp = '2025-06-25';
    },
    watch: {
    },
    methods: {
        completePayment() {
            this.$emit('completePayment', this.value);
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

