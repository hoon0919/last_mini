<template>

    <v-card outlined>
        <v-card-title>
            SetBookHidden
        </v-card-title>

        <v-card-text>
            <Number label="BookId" v-model="value.bookId" :editMode="editMode"/>
            <String label="HiddenReason" v-model="value.hiddenReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="setBookHidden"
            >
                SetBookHidden
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
    name: 'SetBookHiddenCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.bookId = 0;
        this.value.hiddenReason = '';
    },
    watch: {
    },
    methods: {
        setBookHidden() {
            this.$emit('setBookHidden', this.value);
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

