<template>
    <div class="student-form">
        <div class="container-fluid">
            <h3>Student Matchmaking Form</h3>
            <hr>
            <form v-on:submit.prevent="submitEmployerForm()">
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" id="companyName" placeholder="Enter First Name..." v-model="student.firstName" required>
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="companyName" placeholder="Enter Last Name..." v-model="student.lastName" required>
                </div>
                <div class="form-group">
                    <label for="choice1">Choice #1</label>
                    <select class="form-control">
                        <option v-for="employer in employers" v-bind:key="employer.id">{{employer.companyName}}</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    name: 'employerForm',
    data () {
        return {
            student: {
                firstName: '',
                lastName: '',
                choice1: '',
                choice2: '',
                choice3: '',
                choice4: ''
            },
            employers: []
        }
    },
    methods: {
        submitEmployerForm() {
            fetch(`${process.env.VUE_APP_API_URL}/employerForm`, {
                method: 'POST',
                headers: {
                    "Content-Type" : "application/json"
                },
                body: JSON.stringify(this.employer),
            })
            .then((response) => {
                if (response.ok) {
                    return response.json();
                }
            })
            .then((data) => {
                if (data.studentId > 0) {
                    this.$router.push('/thank-you');
                }            
            })
            .catch((err) => console.error(err));
        }
    },
    created() {
        fetch('assets/data/data.json')
        .then((response) => {
            return response.json();
        })
        .then((employer) => {
            this.employers = employers;
        })
        .catch((err) => console.error(err));  
    }
}
</script>