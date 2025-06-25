<template>
    <div>
        <Number
            label="AuthorId"
            v-model="value.authorId"
            :editMode="editMode"
        />
        <String
            label="Name"
            v-model="value.name"
            :editMode="editMode"
        />
        <String
            label="Email"
            v-model="value.email"
            :editMode="editMode"
        />
        <Date
            label="RegisteredAt"
            v-model="value.registeredAt"
            :editMode="editMode"
        />
        <Date
            label="ApprovedAt"
            v-model="value.approvedAt"
            :editMode="editMode"
        />
        <Date
            label="RejectedAt"
            v-model="value.rejectedAt"
            :editMode="editMode"
        />
        <AuthorBio
            offline
            label="Bio"
            v-model="value.bio"
            :editMode="editMode"
            @change="change"
        />
        <PortfolioUrl
            offline
            label="PortfolioUrl"
            v-model="value.portfolioUrl"
            :editMode="editMode"
            @change="change"
        />
        <AuthorRegistrationStatus
            offline
            label="RegistrationStatus"
            v-model="value.registrationStatus"
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
    name: 'Author',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "authors",
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
