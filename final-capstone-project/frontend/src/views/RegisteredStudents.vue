<template>
  <div class="registered-students">
    <div class="container-fluid">
      <div class="jumbotron">
        <h2>Students Who Have Registered For Matchmaking:</h2>
        <hr>
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
export default {
  name: "registeredStudents",
  props: {
  },
  data() {
    return {
      listOfStudents: []
    };
  },
  created() {
    //load the list of employers for a choice - dropdown in student form
    fetch(`${process.env.VUE_APP_API_URL}/registeredStudents`)
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