<template> 
    <div class="update-employer-profile">
        <div class="container-fluid">
            <div class="list-group">
                <div class="list-group-item list-group-item-action">
                    <div class="d-flex w-100 justify-content-between"> 
                        <h5 class="mb-1">{{employer.companyName}}</h5>
                        <small><a href="#" class="edit-review">
                            <router-link :to="{name: 'update-employer-profile', params:{employer: this.employer}}">
                                cancel
                            </router-link>
                        </a></small>
                    </div>
                    <hr>
                    <form v-on:submit.prevent="updateEmployerProfile()">
                        <div class="form-group">
                            <h6>Company Name</h6>
                            <input type="text" class="form-control" id="companyName" placeholder="Enter Company Name..." v-model="employer.companyName" required>
                        </div>
                        <div class="form-group">
                            <h6>Summary</h6>
                            <textarea class="form-control" id="companySummary" rows="3" placeholder="Enter Company Summary..." v-model="employer.companySummary" required></textarea>
                        </div>
                        <div class="form-group">
                            <h6>Days Attending</h6>
                            <input type="date" class="form-control" id="daysAttending" placeholder="Enter Days Attending..." v-model="employer.daysAttending">
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
</template>

<script>
export default {
    name: "updateProfile",
    props: [
        'employer'
    ],
    data(){
        return{
            none: {
                
            }
        }
    },
    methods: {
        updateEmployerProfile() {
            fetch(`${process.env.VUE_APP_API_URL}/employers/${this.employer.employerId}`, {
                method: 'PUT',
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
                    this.$router.push(`/employers/${employer.employerId}`);
                }
            })
            .catch((err) => console.error(err));
        }
    }
}
</script>