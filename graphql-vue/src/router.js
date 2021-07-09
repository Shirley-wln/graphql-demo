import Vue from "vue";
import VueRouter from "vue-router";

// 引入组件
import CreateUser from "./components/CreateUser.vue";
import UserList from "./components/UserList.vue";
import Home from "./components/Home.vue";
// import Form from "./components/Form.vue";

// 要告诉 vue 使用 vueRouter
Vue.use(VueRouter);

const routes = [
  { path: "/create-user", component: CreateUser },
  { path: "/users", component: UserList },
  { path: "/", component: Home },
  //   { path: "/debug", component: Form },
];

var router = new VueRouter({
  routes,
});
export default router;
