<template>

    <v-card outlined>
        <v-card-title>
            UsePointForBook
        </v-card-title>

        <v-card-text>
            <String label="SubscriberId" v-model="value.subscriberId" :editMode="editMode"/>
            <String label="BookId" v-model="value.bookId" :editMode="editMode"/>
            <Number label="PointRequired" v-model="value.pointRequired" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="usePointForBook"
            >
                UsePointForBook
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
    name: 'UsePointForBookCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.subscriberId = '';
        this.value.bookId = '';
        this.value.pointRequired = 0;
    },
    watch: {
    },
    methods: {
        usePointForBook() {
            this.$emit('usePointForBook', this.value);
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

