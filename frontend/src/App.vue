<template>
  <div id="container">
    <ProdasoApp/>
  </div>
</template>

<script>
import ProdasoApp from './components/ProdasoApp.vue'

export default {
  name: 'Prodaso',
  components: {
    ProdasoApp
  }
}
</script>

<style>
#container {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
