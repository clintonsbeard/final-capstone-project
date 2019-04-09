<template>
    <div class="employer-form">
        <div class="container-fluid">
            <h3>Student Choices Form</h3>
            <hr>
                <div class="form-group">
                    <label for="firstName">Student First Name</label>
                    <input type="text" class="form-control" id="firstName" placeholder="Student First Name<..." v-model="firstName" required>
                </div>
                <div class="form-group">
                    <label for="lastName">Student Last Name</label>
                    <input class="form-control" id="lastName" placeholder="Student last Name..." v-model="lastName" required>
                </div>   
                </div>
                <div>             
                <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'employerForm',
    data () {
        return {
            employer: {
                companyName: '',
            },
            student: {
                firstName: '',
                lastName: '',
                choice1: '',
                choice2: '',
                choice3: '',
                choice4: ''
            }
        }
    },
    methods: {
        submitEmployerForm() {
            fetch(`${process.env.VUE_APP_API_URL}/studentForm`, {
                method: 'GET',
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
            .then ( (data) => {
                if (data.studentId > 0){
                    this.$router.push({ path: '/thankyou' });
                }
            })
            .catch((err) => console.error(err));
        },
    }
}
</script>