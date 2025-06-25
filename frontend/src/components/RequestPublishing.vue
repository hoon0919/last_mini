<template>

    <v-card outlined>
        <v-card-title>
            RequestPublishing
        </v-card-title>

        <v-card-text>
            <AuthorId offline label="AuthorId" v-model="value.authorId" :editMode="editMode" @change="change"/>
            <String label="ContentId" v-model="value.contentId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="requestPublishing"
            >
                RequestPublishing
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
    name: 'RequestPublishingCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.authorId = {};
        this.value.contentId = '';
    },
    watch: {
    },
    methods: {
        requestPublishing() {
            this.$emit('requestPublishing', this.value);
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

