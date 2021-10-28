<template>
  <div>
    <BannerVue />
    <DetallesHotelVue />
  </div>
</template>

<script>
import DetallesHotelVue from "../components/DetallesHotelVue.vue";
import BannerVue from "../components/BannerVue.vue";

export default {
  name: "particular",
  components: {
    DetallesHotelVue,
    BannerVue,
  },
};
</script>
