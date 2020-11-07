import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
  mode: "history", // Use browser history
  routes: [
    {
      path: "/",
      name: "Home",
      component: () => import("./components/ProdasoApp")
    },
    {
      path: "/machines",
      name: "Machines",
      component: () => import("./components/ProdasoApp")
    },
    {
      path: "/machines/:id",
      name: "Machine State",
      component: () => import("./components/Machine")
    }
  ]
});

export default router;