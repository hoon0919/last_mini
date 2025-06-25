<template>

    <v-card outlined>
        <v-card-title>
            SaveManuscriptFinal
        </v-card-title>

        <v-card-text>
            <AuthorId offline label="AuthorId" v-model="value.authorId" :editMode="editMode" @change="change"/>
            <String label="Title" v-model="value.title" :editMode="editMode"/>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="saveManuscriptFinal"
            >
                SaveManuscriptFinal
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
    name: 'SaveManuscriptFinalCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.authorId = {};
        this.value.title = '';
        this.value.content = '';
    },
    watch: {
    },
    methods: {
        saveManuscriptFinal() {
            this.$emit('saveManuscriptFinal', this.value);
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

