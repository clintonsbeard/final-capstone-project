<template>
  <div class="employers-list">
    <div class="container-fluid">
      <div class="col-12" v-for="employer in employers" :key="employer.employerId">
        <h4>
          <router-link :to="{name: 'employer-profile', params:{employer_id: employer.employerId}}">
              {{employer.companyName}}
          </router-link>
        </h4>
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