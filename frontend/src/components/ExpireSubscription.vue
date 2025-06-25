<template>

    <v-card outlined>
        <v-card-title>
            ExpireSubscription
        </v-card-title>

        <v-card-text>
            <String label="SubscriptionId" v-model="value.subscriptionId" :editMode="editMode"/>
            <Date label="ExpiredAt" v-model="value.expiredAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="expireSubscription"
            >
                ExpireSubscription
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
    name: 'ExpireSubscriptionCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.subscriptionId = '';
        this.value.expiredAt = '2025-06-25';
    },
    watch: {
    },
    methods: {
        expireSubscription() {
            this.$emit('expireSubscription', this.value);
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

