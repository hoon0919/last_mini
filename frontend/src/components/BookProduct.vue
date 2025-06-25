<template>
    <div>
        <String
            label="ProductId"
            v-model="value.productId"
            :editMode="editMode"
        />
        <Date
            label="RegistrationDate"
            v-model="value.registrationDate"
            :editMode="editMode"
        />
        <PublishingJobId
            offline
            label="출판 작업 ID"
            v-model="value.publishingJobId"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'BookProduct',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "bookProducts",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
