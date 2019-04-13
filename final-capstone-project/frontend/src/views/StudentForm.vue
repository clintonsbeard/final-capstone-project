<template>
  <div class="student-form">
    <div class="container-fluid">
      <div class="jumbotron">
        <h3>Matchmaking: Student Form</h3>
        <hr>
        <form v-if="rankingSystem.choice === false" v-on:submit.prevent="rankFourCompanies()">
          <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" placeholder="Enter First Name..." v-model="student.firstName" required>
          </div>
          <div class="form-group">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName" placeholder="Enter Last Name..." v-model="student.lastName" required>
          </div>
          <div class="form-group">
            <label for="choice1">Choice #1</label>
            <select v-model="student.choice1" class="form-control" required>
              <option value="" selected disabled>Choose...</option>
              <option v-for="employer in listOfEmployers" :key="employer.employerId">{{employer.companyName}}</option>
            </select>
          </div>
          <div class="form-group">
            <label for="choice2">Choice #2</label>
            <select v-model="student.choice2" class="form-control">
              <option value="" selected disabled>Choose...</option>
              <option v-for="employer in listOfEmployers" :key="employer.employerId">{{employer.companyName}}</option>
            </select>
          </div>
          <div class="form-group">
            <label for="choice3">Choice #3</label>
            <select v-model="student.choice3" class="form-control">
              <option value="" selected disabled>Choose...</option>
              <option v-for="employer in listOfEmployers" :key="employer.employerId">{{employer.companyName}}</option>
            </select>
          </div>
          <div class="form-group">
            <label for="choice4">Choice #4</label>
            <select v-model="student.choice4" class="form-control">
              <option value="" selected disabled>Choose...</option>
              <option v-for="employer in listOfEmployers" :key="employer.employerId">{{employer.companyName}}</option>
            </select>
          </div>
          <button type="submit" class="btn btn-primary btn-custom">Submit</button>
        </form>

        <form v-else v-on:submit.prevent="rankAllCompanies()">
          <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" placeholder="Enter First Name..." v-model="student.firstName" required>
          </div>
          <div class="form-group">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName" placeholder="Enter Last Name..." v-model="student.lastName" required>
          </div>
          <div class="form-group" v-for="employer in listOfEmployers" :key="employer.employerId">
            <label for="choice1">Choice #{{employer.employerId}}</label>
            <select class="form-control" required>
              <option value="" selected disabled>Choose...</option>
              <option v-for="employer in listOfEmployers" :key="employer.employerId">{{employer.companyName}}</option>
            </select>
          </div>
          <button type="submit" class="btn btn-primary btn-custom">Submit</button>
        </form>

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
      rankingSystem: [],
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
      rankFourCompanies(){
          fetch(`${process.env.VUE_APP_API_URL}/studentForm`, {
              method: 'POST',
              headers: {
                  "Content-Type": "application/json"
              },
              body: JSON.stringify(this.student)
          })
          .then( (response) => {
            return response.json();
          })
          .then( (student) => {          
            this.studentChoices = student;
            this.$router.push('/thank-you');      
          })
          .catch((err) => console.error(err));
      },
      rankAllCompanies(){
          fetch(`${process.env.VUE_APP_API_URL}/studentForm`, {
              method: 'POST',
              headers: {
                  "Content-Type": "application/json"
              },
              body: JSON.stringify(this.student)
          })
          .then( (response) => {
            return response.json();
          })
          .then( (student) => {          
            this.studentChoices = student;
            this.$router.push('/thank-you');      
          })
          .catch((err) => console.error(err));
      }
  },
  created() {
    fetch(`${process.env.VUE_APP_API_URL}/studentForm`)
      .then(response => {
        return response.json();
      })
      .then((employers) => {
        this.listOfEmployers = employers;
      })
      .catch((err) => {
        console.log(err);
      });
    fetch(`${process.env.VUE_APP_API_URL}/checkRankingChoice`)
      .then(response => {
        return response.json();
      })
      .then((rankingSystem) => {
        this.rankingSystem = rankingSystem;
      })
      .catch((err) => {
        console.log(err);
      });
  }
};
</script>