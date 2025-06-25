<template>

    <v-card outlined>
        <v-card-title>
            GrantKtExtraPoint
        </v-card-title>

        <v-card-text>
            <String label="SubscriberId" v-model="value.subscriberId" :editMode="editMode"/>
            <Number label="Amount" v-model="value.amount" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="grantKtExtraPoint"
            >
                GrantKtExtraPoint
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
    name: 'GrantKtExtraPointCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.subscriberId = '';
        this.value.amount = 0;
    },
    watch: {
    },
    methods: {
        grantKtExtraPoint() {
            this.$emit('grantKtExtraPoint', this.value);
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

