<template>

    <v-card outlined>
        <v-card-title>
            FailPayment
        </v-card-title>

        <v-card-text>
            <String label="PaymentId" v-model="value.paymentId" :editMode="editMode"/>
            <String label="FailReason" v-model="value.failReason" :editMode="editMode"/>
            <Date label="Timestamp" v-model="value.timestamp" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="failPayment"
            >
                FailPayment
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
    name: 'FailPaymentCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.paymentId = '';
        this.value.failReason = '';
        this.value.timestamp = '2025-06-25';
    },
    watch: {
    },
    methods: {
        failPayment() {
            this.$emit('failPayment', this.value);
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

