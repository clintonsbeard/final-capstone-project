<template>
    <div class="change-ranking">
        <div class="container-fluid">
            <div class="jumbotron">
                <h3>Create Final Schedule</h3>
                <hr>
                <table class="table table-responsive table-borderless table-hover table-striped">
                <thead>
                    <tr>
                        <th scope="col" v-for="student in students" :key="student.employerId" style="width: 5%">{{student.lastName}}, {{student.firstName}}</th>
                    </tr>
                </thead>
                    <tbody>
                        <tr>
                            <td v-for="student in students" :key="student.employerId">
                                <ol>
                                    <li v-for="studentSchedule in studentsBySchedule" v-if="student.studentId === studentSchedule.studentId" :key="studentSchedule.studentId">{{studentSchedule.companyName}}</li>
                                </ol>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <hr class="my-4">

                <form v-on:submit.prevent="submitFinalSchedule()">
                <table class="table table-responsive table-borderless table-hover table-striped">
                <thead>
                    <tr>
                        <th scope="col" style="width: 5%"></th>
                        <!-- <th scope="col" v-for="employer in employers" :key="employer.employerId" class="text-center align-middle" style="width: 5%"><input type="hidden" v-model="finalSchedule[employer.employerId]">{{employer.companyName}}</th> -->
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
                                <td v-for="(employer) in employers" :key="employer.employerId" class="text-center align-middle" style="width: 5%">
                                     <select class="form-control" v-model="finalSchedule['Key' + employer.employerId + time[0].replace(':','')]"> 
                                        <option value="" selected disabled>Choose...</option>
                                        <option v-for="student in getStudents" :key="student.studentId + employer.employerId + time[0]" :value="{scheduleId: finalSchedule.scheduleId, startTime: time[0], endTime: time[2], studentId: student.studentId, employerId: employer.employerId}">{{student.firstName}} {{student.lastName}}</option>
                                    </select>
                                </td>
                            </tr>
                    </tbody>
                </table>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-lg btn-custom">Submit Final Schedule</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import auth from '../auth';

export default {
    props: [
        'scheduleChoice'
    ],
    data() {
        return{
            employers: [],
            everything: [],
            studentsBySchedule: [],
            students: [],
            timeSlots: [],
            schedule: [],
            finalSchedule: {
	            scheduleId: this.scheduleChoice,
                studentNames: []
            }
        }
    },
    created() {
        fetch(`${process.env.VUE_APP_API_URL}/timeslots/${this.$route.params.scheduleChoice}`,  {
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

        fetch(`${process.env.VUE_APP_API_URL}/studentsBySchedule/${this.$route.params.scheduleChoice}`,  {
        method: 'GET',
        headers: new Headers({
          Authorization: 'Bearer ' + auth.getToken(),   
        }),
        credentials: 'same-origin',  
        })
        .then(response => {
            return response.json();
        }).then ((studentsBySchedule) => {
            this.studentsBySchedule = studentsBySchedule;
        }).catch(err => {
            console.log(err);
        });

        fetch(`${process.env.VUE_APP_API_URL}/employersBySchedule/${this.$route.params.scheduleChoice}`,  {
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
        
        fetch(`${process.env.VUE_APP_API_URL}/schedule/${this.$route.params.scheduleChoice}`,  {
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

        fetch(`${process.env.VUE_APP_API_URL}/students`,  {
        method: 'GET',
        headers: new Headers({
          Authorization: 'Bearer ' + auth.getToken(),   
        }),
        credentials: 'same-origin',  
        })
        .then(response => {
            return response.json();
        }).then ((students) => {
            this.students = students;
        }).catch(err => {
            console.log(err);
        })
    },
    methods: {
        submitFinalSchedule() {
            const sendArray = [];
            Object.keys(this.finalSchedule).forEach(k => {
                if(k.startsWith("Key")){
                    sendArray.push(this.finalSchedule[k])
                }
            })
            console.log(JSON.stringify(sendArray));

            fetch(`${process.env.VUE_APP_API_URL}/submitFinalSchedule`, {
                method: 'POST',
                headers: {
                    Authorization: 'Bearer ' + auth.getToken(),   
                    "Content-Type" : "application/json"
                },
                body: JSON.stringify(sendArray),
                credentials: 'same-origin'
            })
            .then((response) => {
                if(response.ok){
                    this.$router.push('/thank-you');
                }
            })
            .catch((err) => console.error(err));
        }
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
        getStudents() {
            return [...this.students];
        }
    }
}
</script>