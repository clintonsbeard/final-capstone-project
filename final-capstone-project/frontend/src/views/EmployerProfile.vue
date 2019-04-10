<template>
  <div class="employers-profile">
    <div class="container-fluid">
      <div class="col-12">
        <h4>{{employer.companyName}}</h4>
        <p>employer id is {{employer_id}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "viewEmployerProfile",
  props: [
    "employer_id"
  ],
  data() {
    return {
      employer: []
    };
  },
  created() {
    fetch(`${process.env.VUE_APP_API_URL}/employers/:employer_id`, {
      method: 'GET',
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(employer_id)
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
  }
}
</script>