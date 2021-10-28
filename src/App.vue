<template>
  <div id="app">
    <HeaderVue />
    <!--<BannerVue />-->
    <router-view />
    <FooterVue />
  </div>
</template>

<script>
import HeaderVue from "./components/HeaderVue.vue";
import FooterVue from "./components/FooterVue.vue";
// import BannerVue from "./components/BannerVue.vue";

export default {
  name: "app",
  components: {
    HeaderVue,
    FooterVue,
   // BannerVue,
  },
};
</script>
