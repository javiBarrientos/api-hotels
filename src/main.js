import Vue from "vue";
import Vuex from "vuex";
import { BootstrapVue, BootstrapVueIcons } from "bootstrap-vue";
import App from "./App.vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import axios from "axios";
import router from "./router";
import store from "./store/index.js";
import * as VueGoogleMaps from "vue2-google-maps";
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import VeeValidate from 'vee-validate';

Vue.use(Vuex);
Vue.use(VeeValidate);
Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);
Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyDp3Ud3SixagW8bJOwtosy5bBMB5JRNS_k",
  },
});

Vue.config.productionTip = false;

Vue.prototype.$http = axios;

export const bus = new Vue({});

new Vue({
  router,
  store,
  el: "#app",
  render: (h) => h(App),
});
