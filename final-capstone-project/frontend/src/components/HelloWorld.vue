<template>
  <div class="hello">
    <div class="container-fluid">
      <div class="col-12">
        <h4>Wikimedia Foundation</h4>
        <img src="../assets/img/wm-logo.png" class="img-fluid">
        <h5>San Fransicso, CA</h5>
        <p>Wikimedia is a global movement whose mission is to bring free educational content to the world.</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
