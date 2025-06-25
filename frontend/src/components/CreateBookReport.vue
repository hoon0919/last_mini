<template>

    <v-card outlined>
        <v-card-title>
            CreateBookReport
        </v-card-title>

        <v-card-text>
            <BookId offline label="BookId" v-model="value.bookId" :editMode="editMode" @change="change"/>
            <Number label="ReporterId" v-model="value.reporterId" :editMode="editMode"/>
            <String label="Reason" v-model="value.reason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createBookReport"
            >
                CreateBookReport
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
    name: 'CreateBookReportCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.bookId = {};
        this.value.reporterId = 0;
        this.value.reason = '';
    },
    watch: {
    },
    methods: {
        createBookReport() {
            this.$emit('createBookReport', this.value);
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

