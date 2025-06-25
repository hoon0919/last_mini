<template>

    <v-card outlined>
        <v-card-title>
            ReviewBook
        </v-card-title>

        <v-card-text>
            <Number label="BookId" v-model="value.bookId" :editMode="editMode"/>
            <String label="ReviewComment" v-model="value.reviewComment" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="reviewBook"
            >
                ReviewBook
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
    name: 'ReviewBookCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.bookId = 0;
        this.value.reviewComment = '';
    },
    watch: {
    },
    methods: {
        reviewBook() {
            this.$emit('reviewBook', this.value);
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

