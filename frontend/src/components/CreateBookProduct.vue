<template>

    <v-card outlined>
        <v-card-title>
            CreateBookProduct
        </v-card-title>

        <v-card-text>
            <PublishingJobId offline label="PublishingJobId" v-model="value.publishingJobId" :editMode="editMode" @change="change"/>
            <Date label="RegistrationDate" v-model="value.registrationDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createBookProduct"
            >
                CreateBookProduct
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
    name: 'CreateBookProductCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publishingJobId = {};
        this.value.registrationDate = '2025-06-25';
    },
    watch: {
    },
    methods: {
        createBookProduct() {
            this.$emit('createBookProduct', this.value);
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

