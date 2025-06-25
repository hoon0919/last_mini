<template>

    <v-card outlined>
        <v-card-title>
            RequestAuthorRegistration
        </v-card-title>

        <v-card-text>
            <String label="Name" v-model="value.name" :editMode="editMode"/>
            <String label="Email" v-model="value.email" :editMode="editMode"/>
            <AuthorBio offline label="Bio" v-model="value.bio" :editMode="editMode" @change="change"/>
            <PortfolioUrl offline label="PortfolioUrl" v-model="value.portfolioUrl" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="requestAuthorRegistration"
            >
                RequestAuthorRegistration
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
    name: 'RequestAuthorRegistrationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.name = '';
        this.value.email = '';
        this.value.bio = {};
        this.value.portfolioUrl = {};
    },
    watch: {
    },
    methods: {
        requestAuthorRegistration() {
            this.$emit('requestAuthorRegistration', this.value);
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

