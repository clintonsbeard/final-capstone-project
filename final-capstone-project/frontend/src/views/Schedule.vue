<template>
    <div class="change-ranking">
        <div class="container-fluid">
            <div class="jumbotron">
                <table class="table">
                <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col" v-for="employer in allEmployers" :key="employer.employerId" class="align-middle">
                            <div class="card-deck">
                                <div class="card text-center">
                                    <p>{{ employer.companyName }}</p>
                                </div>
                            </div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <th scope="col" class="align-middle">
                        <div class="card-deck">
                            <div class="card text-center">
                                <p>2:00 - 2:30 pm</p>
                            </div>
                        </div>
                    </th>
                        <draggable class='dragArea' v-model='allStudents' :options='{group: "student"}'>
                            <td class="text-center align-middle" v-for='student in allStudents' :key='student.studentId' colspan="4">{{ student.firstName }}  {{ student.lastName }}</td>
                        </draggable>
                    <tr>
                    <th scope="col" class="align-middle">
                        <div class="card-deck">
                            <div class="card text-center">
                                <p>2:30 - 3:00 pm</p>
                            </div>
                        </div>
                    </th>
                        <draggable class='dragArea' v-model='allStudents' :options='{group: "student"}'>
                            <td class="text-center align-middle" v-for='student in allStudents2nd' :key='student.studentId'>{{ student.firstName }}  {{ student.lastName }}</td>
                        </draggable>
                    </tr>
                    <tr>
                    <th scope="col" class="align-middle">
                        <div class="card-deck">
                            <div class="card text-center">
                                <p>3:00 - 3:30 pm</p>
                            </div>
                        </div>
                    </th>
                    <td class="text-center align-middle">Mark</td>
                    <td class="text-center align-middle">John</td>
                    <td class="text-center align-middle">Connor</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    <td class="text-center align-middle">Mark</td>
                    <td class="text-center align-middle">John</td>
                    <td class="text-center align-middle">Connor</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    </tr>
                    <tr>
                    <th scope="col" class="align-middle">
                        <div class="card-deck">
                            <div class="card text-center">
                                <p>3:30 - 4:00 pm</p>
                            </div>
                        </div>
                    </th>
                    <td class="text-center align-middle" colspan="12">Break</td>
                    </tr>
                    <tr>
                    <th scope="col" class="align-middle">
                        <div class="card-deck">
                            <div class="card text-center">
                                <p>4:00 - 4:30 pm</p>
                            </div>
                        </div>
                    </th>
                    <td class="text-center align-middle">Mark</td>
                    <td class="text-center align-middle">John</td>
                    <td class="text-center align-middle">Connor</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    <td class="text-center align-middle">Mark</td>
                    <td class="text-center align-middle">John</td>
                    <td class="text-center align-middle">Connor</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    </tr>
                    <tr>
                    <th scope="col" class="align-middle">
                        <div class="card-deck">
                            <div class="card text-center">
                                <p>4:30 - 5:00 pm</p>
                            </div>
                        </div>
                    </th>
                    <td class="text-center align-middle">Mark</td>
                    <td class="text-center align-middle">John</td>
                    <td class="text-center align-middle">Connor</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    <td class="text-center align-middle">Mark</td>
                    <td class="text-center align-middle">John</td>
                    <td class="text-center align-middle">Connor</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    </tr>
                    <tr>
                    <th scope="col" class="align-middle">
                        <div class="card-deck">
                            <div class="card text-center">
                                <p>5:00 - 5:30 pm</p>
                            </div>
                        </div>
                    </th>
                    <td class="text-center align-middle">Mark</td>
                    <td class="text-center align-middle">John</td>
                    <td class="text-center align-middle">Connor</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    <td class="text-center align-middle">Mark</td>
                    <td class="text-center align-middle">John</td>
                    <td class="text-center align-middle">Connor</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    </tr>
                    <tr>
                    <th scope="col" class="align-middle">
                        <div class="card-deck">
                            <div class="card text-center">
                                <p>5:30 - 6:00 pm</p>
                            </div>
                        </div>
                    </th>
                    <td class="text-center align-middle">Mark</td>
                    <td class="text-center align-middle">John</td>
                    <td class="text-center align-middle">Connor</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    <td class="text-center align-middle">Mark</td>
                    <td class="text-center align-middle">John</td>
                    <td class="text-center align-middle">Connor</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    <td class="text-center align-middle">Chad</td>
                    <td class="text-center align-middle">Dad</td>
                    </tr>
                </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
import draggable from 'vuedraggable'

export default {
    name: 'Schedule',
    components: { 
        draggable,
    },
    data() {
        return{
            allEmployers: [],
            allStudents: [],
            addedNewStudent: []
        }
    },
    created(){
        fetch(`${process.env.VUE_APP_API_URL}/studentForm`)
        .then(response => {
            console.table(response);
            return response.json();
        }).then (data => {
            this.allEmployers = data;
        }).catch(err => {
            console.log(err);
        });
        fetch(`${process.env.VUE_APP_API_URL}/students`)
        .then(response => {
            console.table(response);
            return response.json();
        }).then (data => {
            this.allStudents = data;
        }).catch(err => {
            console.log(err);
        })
    },
    computed: {
        allEmployersList: {
            get () {
                return this.allEmployers
        },
            set (value) {
                this.allEmployers = value
            }
        },
        allStudentsList: {
            get () {
                return this.allStudents
        },
            set (value) {
                this.allStudents = value
            }
        }
    }    
}
</script>
<style>
#dragArea {
  min-width: 100px;
}
</style>