<template>
  <div class="employers-list">
    <div class="container-fluid">
      <h2>Matchmaking Information</h2>
      <hr>
      <div class="card">
        <img src="../assets/img/matchmaking.jpeg" class="card-img-top" alt="...">
        <div class="card-body">
          <h4 class="card-title">1:00 - 5:00 pm</h4>
          <h5 class="card-title">April 19th & 21st 2019</h5>
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
</template>

<script>
export default {
  name: "studentForm",
  props: {
  },
  data() {
    return {
      employers: []
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
  }
};
</script>