<template>
    <div class="choose-view-schedule">
        <div class="container-fluid">
            <div class="jumbotron">
                <h3>Choose Matchmaking Day</h3>
                <hr>
                <form v-on:submit.prevent="submitSchedule()">
                    <div class="form-group">
                        <label for="pathPreference">Select Below</label>
                        <select class="form-control" v-model="scheduleChoice" required>
                            <option value="" selected disabled>Choose...</option>
                            <option v-for="schedule in schedules" :key="schedule.scheduleId" :value="schedule.scheduleId">
                                {{ schedule.matchmakingDate | moment("dddd, MMMM Do YYYY") }} ({{ [ schedule.startTime, "HH:mm" ] | moment("h:mm a") }} - {{ [ schedule.endTime, "HH:mm" ] | moment("h:mm a") }})
                            </option>
                        </select>
                    </div>
                    <router-link class="btn btn-primary btn-custom" :to="{ name: 'view-schedule', params: { scheduleChoice : this.scheduleChoice } }">
                        Submit
                    </router-link>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import auth from '../auth';

export default {
    data() {
        return {
            schedules: [],
            scheduleChoice: ''
        };
    },
    created() {
        fetch(`${process.env.VUE_APP_API_URL}/schedules`, {
            method: 'GET',
            headers: new Headers({
            Authorization: 'Bearer ' + auth.getToken(),   
            }),
            credentials: 'same-origin',  
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