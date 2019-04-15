<template>
    <div>
        <div class="card-body">
        <div v-for="employer in allEmployer" :key="employer.employerId">
              <h5 class="card-title">{{ employer.companyName }}</h5>
            </div>
        </div>
        <div class="card-body">
        <div v-for="student in allStudents" :key="student.studentId">
              <h5 class="card-title">{{ student.firstName }} {{ student.lastName }}</h5>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            allEmployer: [],
            allStudents:[],
        }
    },
    created(){
        fetch(`${process.env.VUE_APP_API_URL}/studentForm`)
        .then(response => {
            console.table(response);
            return response.json();
        }).then (data => {
            this.allEmployer = data;
        }).catch(err => {
            console.log(err);
        });
        fetch(`${process.env.VUE_APP_API_URL}/students`)
        .then(response => {
            console.table(response);
            return response.json();
        }).then (data => {
            this.allStudents = data;
        }).catch(err => {
            console.log(err);
        })
    }
}
</script>

<style>

</style>
