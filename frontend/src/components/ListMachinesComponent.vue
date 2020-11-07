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
            <th>Name</th>
            <th>State</th>
          </tr>
        </thead>
        <tbody>
         <tr v-for="machine in machines" v-bind:key="machine.id">
            <td>{{machine.name}}</td>
            <td>{{machine.state}}</td>
            <td>
              <button class="btn btn-success"
                      v-on:click="updateMachineClicked(machine.id)">
                Update
              </button>
            </td>
            <td>
              <button class="btn btn-warning"
                      v-on:click="deleteMachineClicked(machine.id)">
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn btn-success" 
                v-on:click="addMachineClicked()">
                Add
        </button>
      </div>
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
        updateMachineClicked(id) {
            this.$router.push(`/machines/${id}`);
        },
        deleteMachineClicked(id) {
            // eslint-disable-next-line no-unused-vars
            MachineDataService.deleteMachine(id).then(response => {
                this.message = `Delete of machine ${id} succeeded`;
                this.refreshMachines();
          });
        },
        addMachineClicked() {
          this.$router.push(`/machines/-1`);
        }
    },
    created() {
        this.refreshMachines();
    }
};
</script>

<style>
</style>