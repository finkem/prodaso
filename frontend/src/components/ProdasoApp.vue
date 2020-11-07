<template>
    <div align="center">
        <h1>PRODASO Lite</h1>
        <ListMachinesComponent/>
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