<template>
  <div class="employers-profile">
    <div class="container-fluid">
      <div class="list-group">
        <div class="list-group-item list-group-item-action">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">{{employer.companyName}}</h5>
            <small><a href="#" class="edit-review">
                <router-link :to="{name: 'update-employer-profile', params:{employer: this.employer}}">
                    edit
                </router-link>
            </a></small>
          </div>
          <hr>
          <h6>Summary</h6>
            <p>{{employer.companySummary}}</p>
          <h6>Days Attending</h6>
            <p>{{employer.daysAttending}}</p>
          <h6>Number Of Teams Attending</h6>
            <p>{{employer.numberOfTeams}}</p>
          <h6>Additional Restrictions</h6>
            <p>{{employer.restrictions}}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "employerProfile",
  props: [
    'employer_id'
  ],
  data() {
    return {
      employer: [],
    };
  },
  created() {
    fetch(`${process.env.VUE_APP_API_URL}/employers/${this.$route.params.employer_id}`)
    .then(response => {
      return response.json();
    })
    .then(employer => {
      this.employer = employer;
    })
    .catch(err => {
      console.log(err);
    });
  }
}
</script>