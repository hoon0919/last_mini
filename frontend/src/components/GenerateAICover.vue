<template>

    <v-card outlined>
        <v-card-title>
            GenerateAiCover
        </v-card-title>

        <v-card-text>
            <String label="PublishingJobId" v-model="value.publishingJobId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="generateAiCover"
            >
                GenerateAiCover
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
    name: 'GenerateAiCoverCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publishingJobId = '';
    },
    watch: {
    },
    methods: {
        generateAiCover() {
            this.$emit('generateAiCover', this.value);
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

