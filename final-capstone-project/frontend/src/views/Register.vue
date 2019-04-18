<template>
  <div class="register">
    <div class="container-fluid">
      <div class="jumbotron">
        <form class="form-register" @submit.prevent="register">
          <h1>Create New Account</h1>
          <hr class="my-4">
          <div class="alert alert-danger" role="alert" v-if="registrationErrors">
            There were problems registering this user.
          </div>
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" placeholder="Enter Username..." v-model="user.username" required autofocus/>
          </div>
          <div class="form-group col-xs-12 col-md-4 d-md-inline-block">
            <label for="password">Password</label>
            <input type="password" id="password" class="form-control" placeholder="Enter Password..." v-model="user.password" required/>
          </div>
          <div class="form-group col-xs-12 col-md-4 d-md-inline-block">
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm Password..." v-model="user.confirmPassword" required/>
          </div>
          <div class="form-group col-xs-12 col-md-4 d-md-inline-block">
            <label for="role">Assign Permissions</label>
            <select id="role" placeholder="Assign Permissions..."  class="form-control" v-model="user.role" required>
            <option disabled value="">Assign Permissions...</option>
              <option>Student</option>
              <option>Employer</option>
              <option>Admin</option>
            </select>
          </div>
          <button class="btn btn-primary btn-custom" type="submit">
            Create Account
          </button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import auth from '../auth';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: '',
      },
      registrationErrors: false,
    };
  },
  methods: {
    register() {
      fetch(`${process.env.VUE_APP_API_URL}/register`, {
        method: 'POST',
        headers: new Headers({
          Authorization: 'Bearer ' + auth.getToken(),   
          Accept: 'application/json',
          'Content-Type': 'application/json',
        }),
        body: JSON.stringify(this.user),
        credentials: 'same-origin'
      })
        .then((response) => {
          if (response.ok) {
            this.$router.push({ path: '/', query: { registration: 'success' } });
          } else {
            this.registrationErrors = true;
          }
        })

        .then((err) => console.error(err));
    },
  },
};
</script>