<template>
    <div class="employer-form">
        <div class="container-fluid">
            <div class="jumbotron">
                <h3>Employer Submission Form</h3>
                <hr>
                <form v-on:submit.prevent="submitEmployerForm()">
                    <div class="form-group">
                        <label for="companyName">Company Name</label>
                        <input type="text" class="form-control" id="companyName" placeholder="Enter Company Name..." v-model="employer.companyName" required>
                    </div>
                    <div class="form-group">
                        <label for="companySummary">Company Summary</label>
                        <textarea class="form-control" id="companySummary" rows="5" placeholder="Enter Company Summary..." v-model="employer.companySummary" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="companyEmail">E-Mail Address</label>
                        <input type="text" class="form-control" id="companyEmail" placeholder="Enter E-Mail Address..." v-model="employer.companyEmail" required>
                    </div>
                    <div class="form-group">
                        <label for="companyWebsite">Website</label>
                        <input type="text" class="form-control" id="companyWebsite" placeholder="Enter Website..." v-model="employer.companyWebsite" required>
                    </div>
                    <div class="form-group">
                        <label for="companyJobs">Position Information</label>
                        <textarea class="form-control" id="companyJobs" rows="5" placeholder="Enter Position Information..." v-model="employer.companyJobs" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="pathPreference">Path Preference</label>
                        <select class="form-control" v-model="employer.pathPreference" required>
                            <option value="" selected disabled>Choose...</option>
                            <option value="Java">Java</option>
                            <option value=".NET">.NET</option>
                            <option value="Either">Either</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="daysAttending">Days Attending</label>
                        <div class="form-check" v-for="schedule in schedules" :key="schedule.scheduleId">
                            <input class="form-check-input" type="checkbox" id="defaultCheck1" v-model="employer.daysAttending[schedule.scheduleId - 1]" :value="schedule.scheduleId" required>
                            <label class="form-check-label" for="defaultCheck1">
                                {{ schedule.matchmakingDate | moment("dddd, MMMM Do YYYY") }}
                            </label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-custom">Submit</button>
                </form>
            </div>
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
                companyEmail: '',
                companyWebsite: '',
                pathPreference: '',
                daysAttending: [],
                numberOfTeams: '',
                restrictions: ''
            },
            schedules: []
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
    created() {
        fetch(`${process.env.VUE_APP_API_URL}/schedules`)
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