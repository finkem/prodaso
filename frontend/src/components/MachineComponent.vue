<template>
  <div>
    <h3>Machine</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <div v-if="errors.length">
            <div class="alert alert-warning" v-bind:key="index" v-for="(error, index) in errors"></div>
        </div>
        <fieldset class="form-group">
          <label>Name</label>
          <input type="text" class="form-control" v-model="name" disabled>
        </fieldset>
        <fieldset class="form-group">
          <label>State</label>
          <input type="text" class="form-control" v-model="state">
        </fieldset>
        <button class="btn btn-success" type="submit">Save</button>
      </form>
    </div>
  </div>
</template>

<script>
import MachineDataService from '../service/MachineDataService';
export default {
  name: "machineState",
  data() {
      return {
          state: "",
          errors: []
      };
  },
  computed: {
      id() {
          return this.$route.params.id;
      }
  },
  methods: {
      refreshMachineState() {
          MachineDataService.retrieveMachine(this.id)
          .then(response => {
              this.name = response.data.name;
              this.state = response.data.state;
          })
      },
      validateAndSubmit(e) {
            e.preventDefault();
            this.errors = [];
            if(this.state != "STANDBY" || this.state != "PRODUCTION") {
                this.errors.push("Enter valid values");
            }
        }
  },
  created() {
      this.refreshMachineState();
  }
};
</script>

<style>
</style>