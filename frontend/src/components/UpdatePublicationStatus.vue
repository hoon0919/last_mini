<template>

    <v-card outlined>
        <v-card-title>
            UpdatePublicationStatus
        </v-card-title>

        <v-card-text>
            <Number label="PublicationHistoryId" v-model="value.publicationHistoryId" :editMode="editMode"/>
            <PublicationResultStatus offline label="ResultStatus" v-model="value.resultStatus" :editMode="editMode" @change="change"/>
            <String label="ResultMessage" v-model="value.resultMessage" :editMode="editMode"/>
            <Date label="PublishedAt" v-model="value.publishedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updatePublicationStatus"
            >
                UpdatePublicationStatus
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
    name: 'UpdatePublicationStatusCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publicationHistoryId = 0;
        this.value.resultStatus = {};
        this.value.resultMessage = '';
        this.value.publishedAt = '2025-06-25';
    },
    watch: {
    },
    methods: {
        updatePublicationStatus() {
            this.$emit('updatePublicationStatus', this.value);
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

