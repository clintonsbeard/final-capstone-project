<template>
  <div class="registered-students">
    <div class="container-fluid">
      <div class="jumbotron">
        <h2>Students Who Have Registered For Matchmaking:</h2>
        <div class="card" v-for="student in listOfStudents" :key="student.studentId">
          <div class="card-body">
            <h5 class="card-title">{{student.firstName}} {{student.lastName}}</h5>
            <p class="card-text">Student ID: {{student.studentId}}</p>
            <p class="card-text">First Choice: {{student.choice1}}</p>
            <p class="card-text">Second Choice: {{student.choice2}}</p>
            <p class="card-text">Third Choice: {{student.choice3}}</p>
            <p class="card-text">Fourth Choice: {{student.choice4}}</p>
          </div>
        </div>
        <button type="submit" class="btn btn-primary">Confirm Student Selections</button>
      </div>
    </div>
  </div>
</template>

<script>
import auth from '../auth';

export default {
  name: "registered-students",
  props: {
  },
  data() {
    return {
      listOfStudents: []
    };
  },
  created() {
    //load the list of employers for a choice - dropdown in student form
    fetch(`${process.env.VUE_APP_API_URL}/students`,  {
        method: 'GET',
        headers: new Headers({
          Authorization: 'Bearer ' + auth.getToken(),   
        }),
        credentials: 'same-origin',  
      })
      .then(response => {
        return response.json();
      })
      .then((students) => {
        this.listOfStudents = students;
      })
      .catch((err) => {
        console.log(err);
      });
  }
};
</script>
