<template>

    <v-card outlined>
        <v-card-title>
            VerifyKtMember
        </v-card-title>

        <v-card-text>
            <String label="SubscriberId" v-model="value.subscriberId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="verifyKtMember"
            >
                VerifyKtMember
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
    name: 'VerifyKtMemberCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.subscriberId = '';
    },
    watch: {
    },
    methods: {
        verifyKtMember() {
            this.$emit('verifyKtMember', this.value);
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

