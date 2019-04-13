import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Login from './views/Login.vue'
import EmployerForm from './views/EmployerForm.vue'
import Employers from './views/Employers.vue'
import EmployerProfile from './views/EmployerProfile.vue'
import StudentForm from './views/StudentForm.vue'
import Logout from './views/Logout.vue'
import ThankYou from './views/ThankYou.vue'
import SetSchedule from './views/SetSchedule.vue'
import UpdateEmployerProfile from './views/UpdateEmployerProfile.vue'
<<<<<<< HEAD
import ChangeRanking from './views/ChangeRanking.vue'
=======
import Register from './views/Register.vue'
import RegisteredStudents from './views/RegisteredStudents.vue'


>>>>>>> 043c9a4eba7ee1884ab2d75381cb57b294dd0a1b
// import auth from './auth'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/employer-form',
      name: 'employer-form',
      component: EmployerForm
    },
    {
      path: '/employers',
      name: 'employers',
      component: Employers
    },
    {
      path: '/employers/:employer_id',
      name: 'employer-profile',
      component: EmployerProfile,
      props: true
    },
    {
      path: '/student-form',
      name: 'student-form',
      component: StudentForm
    },
    {
      path: '/logout',
      name: 'logout',
      component: Logout
    },
    {
      path: '/thank-you',
      name: 'thank-you',
      component: ThankYou
    },
    {
      path: '/update-employer-profile/:employer_id',
      name: 'update-employer-profile',
      component: UpdateEmployerProfile,
      props: true
    },
    {
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/set-schedule',
      name: 'set-schedule',
<<<<<<< HEAD
      component: SetSchedule,
    },
    {
      path: '/change-ranking',
      name: 'change-ranking',
      component: ChangeRanking,
    },
=======
      component: SetSchedule
    },
    {
      path: '/registered-students',
      name: 'registered-students',
      component: RegisteredStudents
    }
>>>>>>> 043c9a4eba7ee1884ab2d75381cb57b294dd0a1b
  ]
});

// router.beforeEach((to, from, next) => {
  
//   // Add the path of components you want to be public to the publicPages array.
//   // this will allow a user to access them without being logged in.
//   const publicPages = ['/login', '/register'];

//   // Add the path of components you want only available for admins to the adminPages array.
//   // You can add other user types by creating new arrays in the same way.
//   const adminPages = ['/admin'];

//   // Determines if the page the user is trying to get to requires a login.  to.path contains the path
//   // the user is trying to access.  In this case, it is checking if the path is NOT in the Array, meaning it is not public
//   const authRequired = !publicPages.includes(to.path);

//   // Does the same for the Admin, by checking if the path is in the restricted admin pages
//   const adminRequired = adminPages.includes(to.path);

//   // Gets the User object from the auth.js
//   const loggedIn = auth.getUser();

//   // redirect to login page if not logged in and trying to access a restricted page
//   if (authRequired && !loggedIn) {
//       // next(path) redirects the user to another route
//       return next('/login');
//   }

//   // uses the userObj to check if the user has the the rol of admin. 
//   // If they do not and the page requires an admin role, then it redirects to the Login page
//   if (adminRequired && loggedIn.rol != 'admin') {
//     return next('/login');
//   }

//   // If everything is OK, then next() redirects the user to the page they are trying to access
//   next();
// });

export default router;