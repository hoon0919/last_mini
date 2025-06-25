<template>

    <v-card outlined>
        <v-card-title>
            FailPublishing
        </v-card-title>

        <v-card-text>
            <String label="PublishingJobId" v-model="value.publishingJobId" :editMode="editMode"/>
            <String label="FailReason" v-model="value.failReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="failPublishing"
            >
                FailPublishing
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
    name: 'FailPublishingCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publishingJobId = '';
        this.value.failReason = '';
    },
    watch: {
    },
    methods: {
        failPublishing() {
            this.$emit('failPublishing', this.value);
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

