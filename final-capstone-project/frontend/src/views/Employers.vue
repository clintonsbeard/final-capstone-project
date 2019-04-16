<template>
  <div class="employers-list">
    <div class="container-fluid">
      <div class="jumbotron">
        <h3>Matchmaking Information</h3>
        <hr>
        <div class="card">
          <img src="../assets/img/matchmaking.jpeg" class="card-img-top" alt="...">
          <div class="card-body">
            <div v-for="schedule in schedules" :key="schedule.scheduleId">
              <h4 class="card-title">{{ [ schedule.startTime, "HH:mm" ] | moment("h:mm a") }} - {{ [ schedule.endTime, "HH:mm" ] | moment("h:mm a") }}</h4>
              <h5 class="card-title">{{ schedule.matchmakingDate | moment("dddd, MMMM Do YYYY") }}</h5>
            </div>
            <p class="card-text">1275 Kinnear Rd, Columbus, OH 43212</p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item" v-for="employer in employers" :key="employer.employerId">
              <router-link :to="{name: 'employer-profile', params:{employer_id: employer.employerId}}">
                {{employer.companyName}}
              </router-link>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "studentForm",
  props: {
  },
  data() {
    return {
      employers: [],
      schedules: []
    };
  },
  created() {
    fetch(`${process.env.VUE_APP_API_URL}/studentForm`)
      .then(response => {
        return response.json();
      })
      .then(employers => {
        this.employers = employers;
      })
      .catch(err => {
        console.log(err);
      });
    fetch(`${process.env.VUE_APP_API_URL}/schedules`)
      .then(response => {
        return response.json();
      })
      .then(schedules => {
        this.schedules = schedules;
      })
      .catch(err => {
        console.log(err);
      });
  }
};
</script>