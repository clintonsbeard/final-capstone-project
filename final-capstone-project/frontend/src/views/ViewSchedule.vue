<template>
    <div class="view-schedule">
        <div class="container-fluid">
            <div class="jumbotron">
                <h1>View Final Schedule <small class="text-muted">{{ schedule.matchmakingDate | moment("dddd, MMMM Do YYYY") }} ({{ [ schedule.startTime, "HH:mm" ] | moment("h:mm A") }} - {{ [ schedule.endTime, "HH:mm" ] | moment("h:mm A") }})</small></h1>
                <hr class="my-4">
                <table class="table table-responsive table-borderless table-hover table-striped">
                <thead>
                    <tr>
                        <th scope="col" style="width: 5%"></th>
                        <th scope="col" v-for="employer in employers" :key="employer.employerId" class="text-center align-middle" style="width: 5%">{{employer.companyName}}</th>
                    </tr>
                </thead>
                    <tbody>
                        <tr v-for="(time) in timeArray" class="table-warning" v-if="time[0] === schedule.breakStartTime">
                            <th scope="row" class="text-center align-middle">{{ [ time[0], "HH:mm" ] | moment("h:mm A") }} {{ time[1] }} {{ [ time[2], "HH:mm" ] | moment("h:mm A") }}</th>
                            <td :colspan="employers.length" class="text-center align-middle">
                                BREAK
                            </td>
                        </tr>
                        <tr v-else>
                            <th scope="row" class="text-center align-middle" style="width: 5%">{{ [ time[0], "HH:mm" ] | moment("h:mm A") }} {{ time[1] }} {{ [ time[2], "HH:mm" ] | moment("h:mm A") }}</th>
                            <td v-for="(student, index) in filterStudents" :key="index" class="text-center align-middle" style="width: 5%">{{student.lastName}}, {{student.firstName}}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
import auth from '../auth';

export default {
    data() {
        return{
            employers: [],
            timeSlots: [],
            schedule: [],
            finalSchedule: [],
            filteredStudents: []
        }
    },
    created() {
        fetch(`${process.env.VUE_APP_API_URL}/timeslots/${this.$route.params.scheduleChoice}`, {
            method: 'GET',
            headers: new Headers({
            Authorization: 'Bearer ' + auth.getToken(),   
            }),
            credentials: 'same-origin',  
        })
        .then(response => {
            return response.json();
        }).then ((timeSlots) => {
            this.timeSlots = timeSlots;
        }).catch(err => {
            console.log(err);
        });
        fetch(`${process.env.VUE_APP_API_URL}/employersBySchedule/${this.$route.params.scheduleChoice}`, {
            method: 'GET',
            headers: new Headers({
            Authorization: 'Bearer ' + auth.getToken(),   
            }),
            credentials: 'same-origin',  
        })
        .then(response => {
            return response.json();
        }).then ((employers) => {
            this.employers = employers;
        }).catch(err => {
            console.log(err);
        });
        fetch(`${process.env.VUE_APP_API_URL}/schedule/${this.$route.params.scheduleChoice}`, {
            method: 'GET',
            headers: new Headers({
            Authorization: 'Bearer ' + auth.getToken(),   
            }),
            credentials: 'same-origin',  
        })
        .then(response => {
            return response.json();
        }).then ((schedule) => {
            this.schedule = schedule;   
        }).catch(err => {
            console.log(err);
        });
        fetch(`${process.env.VUE_APP_API_URL}/getFinalSchedule/${this.$route.params.scheduleChoice}`, {
            method: 'GET',
            headers: new Headers({
            Authorization: 'Bearer ' + auth.getToken(),   
            }),
            credentials: 'same-origin',  
        }).then( (response) => {
            return response.json();
        }).then ( (data) => {
            console.table(data);
            this.finalSchedule = data;
        })
    },
    computed: {
        timeArray() {
            let timeSlots = [this.timeSlots]
            let timeArray = []
        timeSlots.forEach(timeSlot => {
            timeSlot.forEach(slot => {
                slot = String(slot)
                timeArray.push(slot.split(" "))
            })
        })
        return timeArray;
        },
        filterStudents(vm) {
            vm.filteredStudents = []
            for (let i = 0; i < vm.employers.length; i++) {
                vm.filteredStudents.push(vm.finalSchedule[0])
                vm.finalSchedule.shift();
            }
            console.table(vm.filteredStudents);
            console.table(vm.finalSchedule);
            return vm.filteredStudents;
        }
    }
}
</script>