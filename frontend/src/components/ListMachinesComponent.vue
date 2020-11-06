<template>
  <div class="container" align="center">
    <h3>All machines</h3>
    <div v-if="message" class="alert alert-success">
      {{message}}
    </div>
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
            <td>
              <button
                class="btn btn-warning"
                v-on:click="deleteMachineClicked(machine.id)"
              >
                Delete
              </button>
            </td>
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
        },
        deleteMachineClicked(id) {
            // eslint-disable-next-line no-unused-vars
            MachineDataService.deleteMachine(id).then(response => {
                this.message = `Delete of machine ${id} succeeded`;
                this.refreshMachines();
          });
        }
    },
    created() {
        this.refreshMachines();
    }
};
</script>

<style>
</style>