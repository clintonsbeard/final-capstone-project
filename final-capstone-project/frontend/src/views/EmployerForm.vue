<template>
    <div class="employer-form">
        <div class="container-fluid">
            <h3>Employer Submission Form</h3>
            <hr>
            <form v-on:submit.prevent="submitEmployerForm()">
                <div class="form-group">
                    <label for="companyName">Company Name</label>
                    <input type="text" class="form-control" id="companyName" placeholder="Enter Company Name..." v-model="employer.companyName" required>
                </div>
                <div class="form-group">
                    <label for="companySummary">Company Summary</label>
                    <textarea class="form-control" id="companySummary" rows="3" placeholder="Enter Company Summary..." v-model="employer.companySummary" required></textarea>
                </div>
                <div class="form-group">
                    <label for="daysAttending">Days Attending</label>
                    <input type="date" class="form-control" id="daysAttending" placeholder="Enter Days Attending..." v-model="employer.daysAttending">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    name: 'employerForm',
    data () {
        return {
            employer: {
                companyName: '',
                companySummary: '',
                daysAttending: '',
                numberOfTeams: '',
                restrictions: ''
            }
        }
    },
    methods: {
        submitEmployerForm() {
            fetch(`${process.env.VUE_APP_API_URL}/employerForm`, {
                method: 'POST',
                headers: {
                    "Content-Type" : "application/json"
                },
                body: JSON.stringify(this.employer),
            })
            .then((response) => {
                return response.json();
            })
            .then((data) => {
                if (data.employerId > 0) {
                    this.$router.push('/thank-you');
                }
            })
            .catch((err) => console.error(err));
        }
    },
}
</script>