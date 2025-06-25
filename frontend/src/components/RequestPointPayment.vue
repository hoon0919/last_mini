<template>

    <v-card outlined>
        <v-card-title>
            RequestPointPayment
        </v-card-title>

        <v-card-text>
            <SubscriberId offline label="SubscriberId" v-model="value.subscriberId" :editMode="editMode" @change="change"/>
            <BookId offline label="BookId" v-model="value.bookId" :editMode="editMode" @change="change"/>
            <Number label="Amount" v-model="value.amount" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="requestPointPayment"
            >
                RequestPointPayment
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
    name: 'RequestPointPaymentCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.subscriberId = {};
        this.value.bookId = {};
        this.value.amount = 0;
    },
    watch: {
    },
    methods: {
        requestPointPayment() {
            this.$emit('requestPointPayment', this.value);
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

