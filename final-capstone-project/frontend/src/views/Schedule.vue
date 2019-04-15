<template>
    <div>
        <div class="card-body">
        <div v-for="employer in allEmployer" :key="employer.employerId">
              <h5 class="card-title">{{ employer.companyName }}</h5>
            </div>

          <draggable class='dragArea' v-model='peopleList' :options='{group: "people"}'>
            <div v-for='person in peopleList' :key='person.id'>{{ person.name }}</div>
          </draggable>
        </div>
        <div class="card-body">
        <div v-for="student in allStudents" :key="student.studentId">
              <h5 class="card-title">{{ student.firstName }} {{ student.lastName }}</h5>
            </div>
        </div>
    </div>
</template>

<script>
import draggable from 'vuedraggable';

export default {
  components: {
      draggable
  },
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
div.dragArea {
  border: 1px solid black;
  min-width: 100px;
}
</style>