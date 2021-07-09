import Vue from "vue";
import App from "./App.vue";
import Antd from "ant-design-vue";
import router from "./router.js";
import { apolloProvider } from "./apollo.js";
// import VueApollo from "vue-apollo";
import "ant-design-vue/dist/antd.css";

Vue.config.productionTip = false;

Vue.use(Antd);

new Vue({
  el: "#app",
  router,
  // 不加会导致：使用<a-form>时，控制台报错Cannot read property 'form' of undefined
  apolloProvider,
  render: (h) => h(App),
});
