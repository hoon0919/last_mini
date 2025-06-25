<template>

    <v-card outlined>
        <v-card-title>
            CompletePublishing
        </v-card-title>

        <v-card-text>
            <String label="PublishingJobId" v-model="value.publishingJobId" :editMode="editMode"/>
            <String label="CoverImageUrl" v-model="value.coverImageUrl" :editMode="editMode"/>
            <String label="SummaryText" v-model="value.summaryText" :editMode="editMode"/>
            <String label="ProductId" v-model="value.productId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="completePublishing"
            >
                CompletePublishing
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
    name: 'CompletePublishingCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publishingJobId = '';
        this.value.coverImageUrl = '';
        this.value.summaryText = '';
        this.value.productId = '';
    },
    watch: {
    },
    methods: {
        completePublishing() {
            this.$emit('completePublishing', this.value);
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

