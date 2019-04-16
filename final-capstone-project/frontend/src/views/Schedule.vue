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
                            <td v-for="student in students" :key="student.studentId">
                                <ol>
                                    <li>Test</li>
                                    <li>Test</li>
                                    <li>Test</li>
                                    <li>Test</li>
                                </ol>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <hr class="my-4">

                <form>
                <table class="table table-responsive table-borderless table-hover table-striped">
                <thead>
                    <tr>
                        <th scope="col" style="width: 6%"></th>
                        <th scope="col" v-for="employer in employers" :key="employer.employerId" class="text-center align-middle" style="width: 5%">{{employer.companyName}}</th>
                    </tr>
                </thead>
                    <tbody>
                        <tr>
                            <th scope="row" class="text-center align-middle">2:00 - 2:30 pm</th>
                            <td v-for="employer in employers" :key="employer.employerId" class="text-center align-middle">
                                <select class="form-control" required>
                                    <option value="" selected disabled>Choose...</option>
                                    <option v-for="student in students" :key="student.studentId">{{student.firstName}} {{student.lastName}}</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row" class="text-center align-middle">2:30 - 3:00 pm</th>
                            <td v-for="employer in employers" :key="employer.employerId" class="text-center align-middle">
                                <select class="form-control" required>
                                    <option value="" selected disabled>Choose...</option>
                                    <option v-for="student in students" :key="student.studentId">{{student.firstName}} {{student.lastName}}</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row" class="text-center align-middle">3:00 - 3:30 pm</th>
                            <td v-for="employer in employers" :key="employer.employerId" class="text-center align-middle">
                                <select class="form-control" required>
                                    <option value="" selected disabled>Choose...</option>
                                    <option v-for="student in students" :key="student.studentId">{{student.firstName}} {{student.lastName}}</option>
                                </select>
                            </td>
                        </tr>
                        <tr class="table-warning">
                            <th scope="row" class="text-center align-middle">3:30 - 4:00 pm</th>
                            <td colspan="11" class="text-center align-middle">
                                BREAK
                            </td>
                        </tr>
                        <tr>
                            <th scope="row" class="text-center align-middle">4:00 - 4:30 pm</th>
                            <td v-for="employer in employers" :key="employer.employerId" class="text-center align-middle">
                                <select class="form-control" required>
                                    <option value="" selected disabled>Choose...</option>
                                    <option v-for="student in students" :key="student.studentId">{{student.firstName}} {{student.lastName}}</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row" class="text-center align-middle">4:30 - 5:00 pm</th>
                            <td v-for="employer in employers" :key="employer.employerId" class="text-center align-middle">
                                <select class="form-control" required>
                                    <option value="" selected disabled>Choose...</option>
                                    <option v-for="student in students" :key="student.studentId">{{student.firstName}} {{student.lastName}}</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row" class="text-center align-middle">5:00 - 5:30 pm</th>
                            <td v-for="employer in employers" :key="employer.employerId" class="text-center align-middle">
                                <select class="form-control" required>
                                    <option value="" selected disabled>Choose...</option>
                                    <option v-for="student in students" :key="student.studentId">{{student.firstName}} {{student.lastName}}</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row" class="text-center align-middle">5:30 - 6:00 pm</th>
                            <td v-for="employer in employers" :key="employer.employerId" class="text-center align-middle">
                                <select class="form-control" required>
                                    <option value="" selected disabled>Choose...</option>
                                    <option v-for="student in students" :key="student.studentId">{{student.firstName}} {{student.lastName}}</option>
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
export default {
    data() {
        return{
            employers: [],
            everything: [],
            students: []
        }
    },
    created(){
        fetch(`${process.env.VUE_APP_API_URL}/studentForm`)
        .then(response => {
            return response.json();
        }).then ((employers) => {
            this.employers = employers;
        }).catch(err => {
            console.log(err);
        });
        fetch(`${process.env.VUE_APP_API_URL}/getEverything`)
        .then(response => {
            return response.json();
        }).then ((everything) => {
            this.everything = everything;
            console.table(everything);
        }).catch(err => {
            console.log(err);
        });
        fetch(`${process.env.VUE_APP_API_URL}/students`)
        .then(response => {
            return response.json();
        }).then ((students) => {
            this.students = students;
            console.table(students);
        }).catch(err => {
            console.log(err);
        });
    }
}
</script>