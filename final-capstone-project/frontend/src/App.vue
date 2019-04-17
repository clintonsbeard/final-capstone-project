<template>
  <div id="app">
      <nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="/">
                <img src="./assets/img/te-logo.png" height="35" class="d-inline-block align-top">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <router-link to="/employers" class="nav-link">Matchmaking Information</router-link>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Student Menu
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <router-link class="dropdown-item" to="/student-form">Student Submission Form</router-link>
                            <router-link class="dropdown-item" to="/student-form">View Schedule</router-link>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Employer Menu
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <router-link class="dropdown-item" to="/employer-form">Employer Submission Form</router-link>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Administrator Menu
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <router-link class="dropdown-item" to="/register">Create Account</router-link>
                            <router-link class="dropdown-item" to="/set-schedule">Add Matchmaking Day</router-link>
                            <router-link class="dropdown-item" to="/change-ranking">Change Ranking System</router-link>
                            <router-link class="dropdown-item" to="/choose-schedule">Finalize and Publish Schedule</router-link>
                        </div>
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