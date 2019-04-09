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
                    <input type="date" class="form-control" id="daysAttending" placeholder="Enter Days Attending..." v-model="employer.daysAttending" required>
                </div>
                <div class="form-group">
                    <label for="numberOfTeams">Number of Teams Attending</label>
                    <input type="number" class="form-control" id="numberOfTeams" placeholder="Enter Number of Teams Attending..." v-model="employer.numberOfTeams" min="1" required>
                </div>
                <div class="form-group">
                    <label for="restrictions">Additional Appointment Restrictions</label>
                    <textarea class="form-control" id="restrictions" placeholder="Enter Additional Appointment Restrictions..." v-model="employer.restrictions" rows="3"></textarea>
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
                if (response.ok) {
                    console.log("response was ok");
                    this.$router.push({ path: '/thankyou' });
                }
            })
            .catch((err) => console.error(err));
        }
    }
}
</script>