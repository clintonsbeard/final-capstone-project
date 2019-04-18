<template>
    <div class="employer-form">
        <div class="container-fluid">
            <div class="jumbotron">
                <h3>Employer Submission Form</h3>
                <hr>
                <form v-on:submit.prevent="submitEmployerForm()">
                    <div class="form-group">
                        <label for="name">Company Name</label>
                        <input type="text" class="form-control" id="name" placeholder="Enter Company Name..." v-model="employer.companyName" required>
                    </div>
                    <div class="form-group">
                        <label for="companySummary">Company Summary</label>
                        <textarea class="form-control" id="companySummary" rows="5" placeholder="Enter Company Summary..." v-model="employer.companySummary" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="email">E-Mail Address</label>
                        <input type="email" class="form-control" id="email" placeholder="Enter E-Mail Address..." v-model="employer.email" required>
                    </div>
                    <div class="form-group">
                        <label for="website">Website</label>
                        <input type="text" class="form-control" id="website" placeholder="Enter Website..." v-model="employer.website" required>
                    </div>
                    <div class="form-group">
                        <label for="companyJobs">Summary of Open Positions</label>
                        <textarea class="form-control" id="companyJobs" rows="5" placeholder="Enter Position Information..." v-model="employer.positionsSummary" required></textarea>
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
                            <input class="form-check-input" type="checkbox" id="daysAttending" v-model="employer.daysAttending[schedule.scheduleId - 1]" :value="schedule.scheduleId" >
                            <label class="form-check-label" for="daysAttending">
                                {{ schedule.matchmakingDate | moment("dddd, MMMM Do YYYY") }}
                                <br>
                                {{ [ schedule.startTime, "HH:mm" ] | moment("h:mm a") }} - {{ [ schedule.endTime, "HH:mm" ] | moment("h:mm a") }}
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="numberOfTeams">Number Of Teams Attending</label>
                        <input type="number" class="form-control" id="numberOfTeams" placeholder="Enter Number of Teams Attending..." v-model="employer.numberOfTeams" min="1">
                    </div>
                    <div class="form-group">    
                        <label for="restrictions">Additional Restrictions</label>
                        <textarea class="form-control" id="restrictions" placeholder="Enter Additional Restrictions..." v-model="employer.restrictions" rows="5"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary btn-custom ">Submit</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import auth from '../auth';

export default {

    name: 'employerForm',
    data () {
        return {
            employer: {
                companyName: '',
                companySummary: '',
                email: '',
                website: '',
                positionsSummary: '',
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
            console.table(this.employer)
            fetch(`${process.env.VUE_APP_API_URL}/employerForm`, {
                method: 'POST',
                headers: new Headers({
                    Authorization: 'Bearer ' + auth.getToken(),   
                    "Content-Type" : "application/json"
                }),
                body: JSON.stringify(this.employer),
                credentials: 'same-origin'            
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
        },
    },
    created() {
        fetch(`${process.env.VUE_APP_API_URL}/schedules`,  {
        method: 'GET',
        headers: new Headers({
          Authorization: 'Bearer ' + auth.getToken(),   
        }),
        credentials: 'same-origin'
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