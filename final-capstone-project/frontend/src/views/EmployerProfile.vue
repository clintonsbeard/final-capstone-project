<template>
  <div class="employers-profile">
    <div class="container-fluid">
      <div class="jumbotron">
        <h1>Employer Profile</h1>
        <hr class="my-4">
        <div class="list-group">
          <div class="list-group-item list-group-item-action">
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">{{employer.companyName}}</h5>
              <a href="#" class="edit-review">
                  <router-link :to="{name: 'update-employer-profile', params:{employer: this.employer, schedules: this.schedules}}">
                    edit
                  </router-link>
              </a>
            </div>
            <hr>
            <h6>Company Summary</h6>
              <p>{{employer.companySummary}}</p>
            <h6>Email</h6>
              <p>{{employer.email}}</p>
            <h6>Website</h6>
              <p>{{employer.website}}</p>
            <h6>Positions Summary</h6>
              <p>{{employer.positionsSummary}}</p>
            <h6>Path Preference</h6>
              <p>{{employer.pathPreference}}</p>
            <h6>Days Attending</h6>
              <div v-for="schedule in schedules" :key="schedule.scheduleId">
                {{ schedule.matchmakingDate | moment("dddd, MMMM Do YYYY") }}
                <br>
                {{ [ schedule.startTime, "HH:mm" ] | moment("h:mm a") }} - {{ [ schedule.endTime, "HH:mm" ] | moment("h:mm a") }}
              </div>
              <p></p>
            <h6>Number Of Teams Attending</h6>
              <p>{{employer.numberOfTeams}}</p>
            <h6>Additional Restrictions</h6>
              <p>{{employer.restrictions}}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import auth from '../auth';

export default {
  props: [
    'employer_id'
  ],
  data() {
    return {
      employer: [],
      schedules: []
    };
  },
  created() {
    fetch(`${process.env.VUE_APP_API_URL}/employers/${this.$route.params.employer_id}`,  {
        method: 'GET',
        headers: new Headers({
          Authorization: 'Bearer ' + auth.getToken(),   
        }),
        credentials: 'same-origin',  
      })
      .then(response => {
        return response.json();
      })
      .then(employer => {
        this.employer = employer;
      })
      .catch(err => {
        console.log(err);
      });
    fetch(`${process.env.VUE_APP_API_URL}/schedules`,  {
        method: 'GET',
        headers: new Headers({
          Authorization: 'Bearer ' + auth.getToken(),   
        }),
        credentials: 'same-origin',  
      })
      .then(response => {
          return response.json();
      })
      .then((schedules) => {
          this.schedules = schedules;
      })
      .catch(err => {
          console.log(err);
      });
    }
}
</script>