<template>

    <v-card outlined>
        <v-card-title>
            CreatePublicationHistory
        </v-card-title>

        <v-card-text>
            <ManuscriptId offline label="ManuscriptId" v-model="value.manuscriptId" :editMode="editMode" @change="change"/>
            <Date label="RequestedAt" v-model="value.requestedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createPublicationHistory"
            >
                CreatePublicationHistory
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
    name: 'CreatePublicationHistoryCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.manuscriptId = {};
        this.value.requestedAt = '2025-06-25';
    },
    watch: {
    },
    methods: {
        createPublicationHistory() {
            this.$emit('createPublicationHistory', this.value);
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

