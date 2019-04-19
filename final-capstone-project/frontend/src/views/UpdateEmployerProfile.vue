<template> 
    <div class="update-employer-profile">
        <div class="container-fluid">
            <div class="jumbotron">
            <h1>Employer Profile</h1>
            <hr class="my-4">
            <div class="list-group">
                <div class="list-group-item list-group-item-action">
                    <div class="d-flex w-100 justify-content-between"> 
                        <h5 class="mb-1">{{employer.companyName}}</h5>
                            <router-link :to="{name: 'employer-profile', params:{employer: this.employer}}">
                                cancel
                            </router-link>
                    </div>
                    <hr>
                    <form v-on:submit.prevent="updateEmployerProfile()">
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="employerId" v-model="employer.employerId" required>
                        </div>
                        <div class="form-group">
                            <h6>Company Name</h6>
                            <input type="text" class="form-control" id="companyName" placeholder="Enter Company Name..." v-model="employer.companyName" required>
                        </div>
                        <div class="form-group">
                            <h6>Company Summary</h6>
                            <textarea class="form-control" id="companySummary" rows="5" placeholder="Enter Company Summary..." v-model="employer.companySummary" required></textarea>
                        </div>
                        <div class="form-group">
                            <h6>E-Mail Address</h6>
                            <input type="email" class="form-control" id="email" placeholder="Enter E-Mail Address..." v-model="employer.email" required>
                        </div>
                        <div class="form-group">
                            <h6>Website</h6>
                            <input type="text" class="form-control" id="website" placeholder="Enter Website..." v-model="employer.website" required>
                        </div>
                        <div class="form-group">
                            <h6>Position Summary</h6>
                            <textarea class="form-control" id="positionsSummary" rows="5" placeholder="Enter Positions Summary..." v-model="employer.positionsSummary" required></textarea>
                        </div>
                        <div class="form-group">
                            <h6>Path Preference</h6>
                            <select class="form-control" v-model="employer.pathPreference" required>
                                <option value="" selected disabled>Choose...</option>
                                <option value="Java">Java</option>
                                <option value=".NET">.NET</option>
                                <option value="Either">Either</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <h6>Days Attending</h6>
                            {{ employer.companyName }}
                            <div class="form-check" v-for="schedule in schedules" :key="schedule.scheduleId">
                                <input class="form-check-input" type="checkbox" id="daysAttending" :value="schedule.scheduleId"/>
                                {{ schedule.matchmakingDate | moment("dddd, MMMM Do YYYY") }}
                            </div>
                        </div>
                        <div class="form-group">
                            <h6>Number Of Teams Attending</h6>
                            <input type="number" class="form-control" id="numberOfTeams" placeholder="Enter Number of Teams Attending..." v-model="employer.numberOfTeams" min="1">
                        </div>
                        <div class="form-group">    
                            <h6>Additional Restrictions</h6>
                            <textarea class="form-control" id="restrictions" placeholder="Enter Additional Appointment Restrictions..." v-model="employer.restrictions" rows="3"></textarea>
                        </div>
                            <button type="submit" class="btn btn-primary">Submit Updates</button>
                    </form>
                </div>
            </div>
            </div>
        </div>
    </div>
</template>

<script>
import auth from '../auth';

export default {
    name: "updateProfile",
    props: [
        'employer',
        'schedules'
    ],
    methods: {
        updateEmployerProfile() {
            fetch(`${process.env.VUE_APP_API_URL}/employers/update`,  {
            method: 'PUT',
            headers: new Headers({
                Authorization: 'Bearer ' + auth.getToken(),
                "Content-Type": "application/json"
            }),
            body: JSON.stringify(this.employer),
            credentials: 'same-origin'
            })
            .then((response) => {
                if (response.ok) {
                    this.$router.push(`/employers/${this.employer.employerId}`);
                }
            })
            .catch((err) => console.error(err));
        }
    }
}
</script>



