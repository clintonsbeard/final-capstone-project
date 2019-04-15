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
                                <p>2:30 - 3:00 pm</p>
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
export default {
    data() {
        return{
            allEmployers: [],
            allStudents: [],
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
    }
}
</script>