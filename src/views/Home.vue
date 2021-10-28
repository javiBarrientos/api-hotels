<template>
  <div>
    <OfertasVue />
    <BannerVue />
    <FormVue />
    <RecomendacionesVue />
  </div>
</template>

<script>
import FormVue from "../components/FormVue.vue";
import OfertasVue from "../components/OfertasVue.vue";
import RecomendacionesVue from "../components/RecomendacionesVue.vue";
import BannerVue from "../components/BannerVue.vue";

export default {
  name: "home",
  components: {
    FormVue,
    OfertasVue,
    RecomendacionesVue,
    BannerVue,
  },
};
</script>
