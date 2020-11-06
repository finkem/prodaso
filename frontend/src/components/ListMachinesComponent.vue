<template>
  <div class="container">
    <h3>All machines</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>State</th>
          </tr>
        </thead>
        <tbody>
         <tr v-for="machine in machines" v-bind:key="machine.id">
            <td>{{machine.id}}</td>
            <td>{{machine.name}}</td>
            <td>{{machine.state}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import MachineDataService from '../service/MachineDataService';
export default {
  name: "MachinesList",
  data() {
      return {
          machines: [],
          message: null
      }
  },
  methods: {
        refreshMachines() {
            MachineDataService.retrieveAllMachines()
            .then(response => {
                this.machines = response.data;
            })
        }
    },
    created() {
        this.refreshMachines();
    }
};
</script>

<style>

</style>