<template>

    <v-card outlined>
        <v-card-title>
            RejectAuthor
        </v-card-title>

        <v-card-text>
            <Number label="AuthorId" v-model="value.authorId" :editMode="editMode"/>
            <String label="RejectReason" v-model="value.rejectReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="rejectAuthor"
            >
                RejectAuthor
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
    name: 'RejectAuthorCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.authorId = 0;
        this.value.rejectReason = '';
    },
    watch: {
    },
    methods: {
        rejectAuthor() {
            this.$emit('rejectAuthor', this.value);
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

