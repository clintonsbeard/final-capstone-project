<template>
  <div class="student-form">
    <div class="container-fluid">
      <h3>Student Choices Form</h3>
      <div class="form">
        <div>First Choice</div>
        <div>
          <select v-model="student.choice1">
            <option
              v-for="employer in listOfEmployers"
              :key="employer.employerId"
            >{{employer.companyName}}</option>
          </select>
          <button :disabled="!isValidForm" v-on:click="submitStudentChoices">Submit</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "studentForm",
  props: {},
  data() {
    return {
      listOfEmployers: [],
      student: {
        choice1: ""
      },
      studentChoices: []
    };
  },
  methods: {
      submitStudentChoices(){
          fetch(`${process.env.VUE_APP_API_URL}/studentForm`, => {
              method: 'POST',
              headers: {
                  "Content-Type": "application/json"
              },
              body: JSON.stringify(this.student)
          }).then( (response) => {
                return response.json();
          }).then( (student) => {
                this.studentChoices = student;
          }).catch( (err) => console.error(err));
      }
  },
  created() {
    fetch(`${process.env.VUE_APP_API_URL}/studentForm`)
      .then(response => {
        return response.json();
      })
      .then(employers => {
        this.listOfEmployers = employers;
      })
      .catch(err => {
        console.log(err);
      });
  }
};
</script>