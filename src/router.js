import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";
import Login from "./views/Login.vue";
import Register from "./views/Register.vue";
import Alojamientos from "./views/Alojamientos.vue";
import UsuarioPerfil from "./views/UsuarioPerfil.vue";
import HotelParticular from "./views/HotelParticular.vue";
import ProcesarReserva from "./views/ProcesarReserva.vue";
import DetallesHotelVue from "./components/DetallesHotelVue.vue";
import Admin from "./views/Admin.vue";
import User from "./views/User.vue"
import Moderator from "./views/Moderator.vue";

Vue.use(Router);

Vue.component("DetallesHotelVue", DetallesHotelVue);

const router = new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      component: Home,
    },
    {
      path: "/login",
      component: Login,
    },
    {
      path: "/register",
      component: Register,
    },
    {
      path: "/alojamientos",
      component: Alojamientos,
    },
    {
      path: "/admin",
      component: Admin,
    },
    {
      path: "/user",
      component: User,
    },
    {
      path: "/mod",
      component: Moderator,
    },
    {
      path: "/perfil",
      component: UsuarioPerfil
    },
    {
      path: "/hotel/:id",
      name: "particular",
      component: HotelParticular
    },
    {
      path: "/reserva/:id",
      name: "reservaHotel",
      component: ProcesarReserva
    },
  ],
});

export default router;
