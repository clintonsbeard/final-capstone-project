<template>
  <div class="student-form">
    <div class="container-fluid">
      <h3>Matchmaking: Student Form</h3>
      <hr>
      <form v-on:submit.prevent="submitStudentForm()">
        <div class="form-group">
          <label for="firstName">First Name</label>
          <input type="text" class="form-control" id="firstName" placeholder="Enter First Name..." v-model="student.firstName" required>
        </div>
        <div class="form-group">
          <label for="lastName">Last Name</label>
          <input type="text" class="form-control" id="lastName" placeholder="Enter Last Name..." v-model="student.lastName" required>
        </div>
        <div class="form-group">
          <label for="choice1">First Choice</label>
          <select v-model="student.choice1" class="form-control">
            <option value="" selected disabled>Choose...</option>
            <option v-for="employer in listOfEmployers" :key="employer.employerId">{{employer.companyName}}</option>
          </select>
        </div>
        <div class="form-group">
          <label for="choice2">Second Choice</label>
          <select v-model="student.choice2" class="form-control">
            <option value="" selected disabled>Choose...</option>
            <option v-for="employer in listOfEmployers" :key="employer.employerId">{{employer.companyName}}</option>
          </select>
        </div>
        <div class="form-group">
          <label for="choice3">Third Choice</label>
          <select v-model="student.choice3" class="form-control">
            <option value="" selected disabled>Choose...</option>
            <option v-for="employer in listOfEmployers" :key="employer.employerId">{{employer.companyName}}</option>
          </select>
        </div>
        <div class="form-group">
          <label for="choice4">Fourth Choice</label>
          <select v-model="student.choice4" class="form-control">
            <option value="" selected disabled>Choose...</option>
            <option v-for="employer in listOfEmployers" :key="employer.employerId">{{employer.companyName}}</option>
          </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
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
        firstName: '',
        lastName: '',
        choice1: '',
        choice2: '',
        choice3: '',
        choice4: ''
      }
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
    //load the list of employers for a choice - dropdown in student form
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