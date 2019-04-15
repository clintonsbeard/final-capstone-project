<template>
<v-container fill-height fluid grid-list-md mt-0 class='about'>
    <v-layout column fill-height>
      <h1>This is an about page</h1>
      <v-layout row fill-height>
        <v-flex xs4>
          <draggable class='dragArea' v-model='peopleList' :options='{group: "people"}'>
            <div v-for='person in peopleList' :key='person.id'>{{ person.name }}</div>
          </draggable>
        </v-flex>
        <v-flex xs4>
          <draggable class='dragArea' v-model='employeeList' :options='{group: "people"}'>
            <div v-for='person in employeeList' :key='person.id'>{{ person.name }}</div>
          </draggable>
        </v-flex>
      </v-layout>
    </v-layout>
</v-container>
</template>
<script>
import draggable from 'vuedraggable'

export default {
  name: 'test-page',
  data () {
    return {
      employees: [{ id: 6, name: 'Pete' },
        { id: 7, name: 'Pat' }],
      people: [
        { id: 1, name: 'Bob' },
        { id: 2, name: 'Mary' },
        { id: 3, name: 'Jane' },
        { id: 4, name: 'Alex' },
        { id: 5, name: 'Jim' }
      ]
    }
  },
  components: { draggable },
  computed: {
    employeeList: {
      get () {
        return this.employees
      },
      set (value) {
        this.employees = value
      }
    },
    peopleList: {
      get () {
        return this.people
      },
      set (value) {
        this.people = value
      }
    }
  }
}
</script>
<style>
div.dragArea {
  border: 1px solid black;
  min-width: 100px;
}
</style>