<template>
    <div class="set-schedule">
        <div class="container-fluid">
            <div class="jumbotron">
                <h3>Add Matchmaking Day</h3>
                <hr>
                <form v-on:submit.prevent="addDayToSchedule()">
                    <div class="form-group">
                        <label for="matchmakingDate">Matchmaking Date</label>
                        <input type="date" class="form-control" id="matchmakingDate" min="2019-04-10" data-provide="datepicker" v-model="schedule.matchmakingDate" required>
                    </div>
                    <div class="form-group">
                        <label for="startTime">Start Time</label>
                        <input type="time" class="form-control" id="startTime" step="300" v-model="schedule.startTime" required>
                    </div>
                    <div class="form-group">
                        <label for="endTime">End Time</label>
                        <input type="time" class="form-control" id="endTime" step="300" v-model="schedule.endTime" required>
                    </div>
                    <div class="form-group">
                        <label for="interviewLength">Interview Length (Including Stagger Period)</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">minutes</div>
                            </div>
                            <input type="number" class="form-control" id="interviewLength" step="5" v-model="schedule.interviewLength" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="breakStartTime">Break Start Time</label>
                        <input type="time" class="form-control" id="breakStartTime" step="300" v-model="schedule.breakStartTime" required>
                    </div>
                    <div class="form-group">
                        <label for="breakEndTime">Break End Time</label>
                        <input type="time" class="form-control" id="breakEndTime" step="300" v-model="schedule.breakEndTime" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-custom">Submit</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'addSchedule',
    data () {
        return {
            schedule: {
                scheduleId: '',
                matchmakingDate: '',
                startTime: '',
                endTime: '',
                interviewLength: '',
                breakStartTime: '',
                breakEndTime: ''
            }
        }
    },
    methods: {
        addDayToSchedule() {
            console.table(this.schedule)
            fetch(`${process.env.VUE_APP_API_URL}/schedule/add`, {
                method: 'POST',
                headers: new Headers({
                    Authorization: 'Bearer ' + auth.getToken(),   
                    "Content-Type" : "application/json"
                }),
                body: JSON.stringify(this.schedule),
                credentials: 'same-origin'

            })
            .then((response) => {
                if (response.ok) {
                    this.$router.push('/thank-you');
                }
            })
            .catch((err) => console.error(err));
        }
    }
}
</script>