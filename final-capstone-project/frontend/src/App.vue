<template>
  <div id="app">
      <nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">
                Tech Elevator
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <router-link to="/" class="nav-link">Home</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/employer-form" class="nav-link">Employer Submission Form</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/student-form" class="nav-link">Student Submission Form</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/employers" class="nav-link">Employers Attending</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/login" class="nav-link">Login</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/logout" class="nav-link">Logout</router-link>
                    </li>
                </ul>
            </div>
        </nav>
    <router-view/>
  </div>
</template>

<style>
@import 'https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css';
@import 'assets/css/style.css';
</style>