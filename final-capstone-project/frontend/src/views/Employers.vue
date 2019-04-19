<template>
  <div class="employers-list">
    <vue-headful title="Tech Elevator Matchmaking - Matchmaking Information"/>
    <div class="container-fluid">
      <div class="jumbotron">
        <h1><font-awesome-icon icon="users"/> Matchmaking Information</h1>
        <hr class="my-4">
        <div class="card">
          <div v-for="schedule in schedules" :key="schedule.scheduleId" class="card-body col-xs-12 col-sm-6 d-sm-inline-block">
              <h2 class="card-title"><font-awesome-icon icon="clock"/> {{ [ schedule.startTime, "HH:mm" ] | moment("h:mm A") }} - {{ [ schedule.endTime, "HH:mm" ] | moment("h:mm A") }}</h2>
              <h4 class="card-title ml-1"><font-awesome-icon icon="calendar-day"/> {{ schedule.matchmakingDate | moment("dddd, MMMM Do YYYY") }}</h4>
            <p class="card-text ml-2"><font-awesome-icon icon="map-marked-alt"/> 1275 Kinnear Rd, Columbus, OH 43212</p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item" v-for="employer in employers" :key="employer.employerId">
              Company {{employer.employerId}}:
              <router-link :to="{ name: 'employer-profile', params:{ employer_id: employer.employerId } }">
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
import auth from '../auth';

export default {

  name: "studentForm",
  data() {
    return {
      schedules: [],
      employers: [],
      schedulesAndEmployers: []
    };
  },
  created() {
    fetch(`${process.env.VUE_APP_API_URL}/studentForm`,  {
        method: 'GET',
        headers: new Headers({
          Authorization: 'Bearer ' + auth.getToken(),   
        }),
        credentials: 'same-origin'
      })
      .then(response => {
        return response.json();
      })
      .then((employers) => {
        this.employers = employers;
      })
      .catch(err => {
          console.log(err);
      });
    fetch(`${process.env.VUE_APP_API_URL}/schedules`, {
        method: 'GET',
        headers: new Headers({
          Authorization: 'Bearer ' + auth.getToken(),   
        }),
        credentials: 'same-origin',  
      })
      .then(response => {
        return response.json();
      })
      .then(schedules => {
        this.schedules = schedules;
      })
      .catch(err => {
        console.log(err);
      });
      fetch(`${process.env.VUE_APP_API_URL}/getSchedulesAndEmployers`, {
        method: 'GET',
        headers: new Headers({
          Authorization: 'Bearer ' + auth.getToken(),   
        }),
        credentials: 'same-origin',  
      })
      .then(response => {
        return response.json();
      })
      .then(schedulesAndEmployers => {
        this.schedulesAndEmployers = schedulesAndEmployers;
        console.table(this.schedulesAndEmployers)
      })
      .catch(err => {
        console.log(err);
      });
  }
};
</script>