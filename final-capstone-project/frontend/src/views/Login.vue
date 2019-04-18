<template>
  <div class="login">
    <div class="container-fluid">
      <div class="jumbotron">
        <form @submit.prevent="login">
          <h1>Please Sign In</h1>
          <hr class="my-4">
          <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
            Invalid username and password!
          </div>
          <div class="alert alert-success" role="alert" v-if="this.$route.query.registration">
            Thank you for registering, please sign in.
          </div>
          <div class="form-group col-xs-12 col-md-6 d-md-inline-block">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" placeholder="Enter Username..." v-model="user.username" required autofocus/>
          </div>
          <div class="form-group col-xs-12 col-md-6 d-md-inline-block">
            <label for="password">Password</label>
            <input type="password" id="password" class="form-control" placeholder="Enter Password..." v-model="user.password" required/>
          </div>
          <div class="form-group col-xs-12 col-md-6 d-md-inline-block">
            <button class="btn btn-primary btn-custom" type="submit">
              Sign In
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import auth from '../auth';

export default {
  name: 'login',
  components: {},
  data() {
    return {
      user: {
        username: '',
        password: '',
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      fetch(`${process.env.VUE_APP_API_URL}/login`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            return response.text();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then((token) => {
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, '');
            }
            auth.saveToken(token);
            this.$router.push('/');
          }
        })
        .catch((err) => console.error(err));
    },
  },
};
</script>