<template>
    <div>
        <h1>PRODASO Lite</h1>
        <ListMachinesComponent></ListMachinesComponent>
    </div>
</template>

<script>
import ListMachinesComponent from "./ListMachinesComponent";
export default {
    name: "ProdasoApp",
    components: {
        ListMachinesComponent
    }
};
</script>

<style scoped>

</style>