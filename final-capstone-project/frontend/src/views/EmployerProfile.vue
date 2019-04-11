<template>
  <div class="employers-profile">
    <div class="container-fluid">
      <div class="col-12">
        <p>employer id is {{employer_id}}</p> 
        <p></p>       
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "viewEmployerProfile",
  props: [
    'employer_id'
  ],
  data() {
    return {
      fetchedEmployer: [],
    };
  },
  // computed: {
  //   employerIdParam(){
  //     return this.$route.params.employer_id;
  //   }
  // },
  created() {
      fetch(`${process.env.VUE_APP_API_URL}/employers/${this.employer_id}`)
      .then(response => {
        return response.json();
      })
      .then(employer => {
        this.fetchedEmployer = employer;
      })
      .catch(err => {
        console.log(err);
      }); 
  }
}
</script>