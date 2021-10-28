<template>
  <div>
    <div>
      <BannerVue />
    </div>
    <div id="alojamientos_form_cajas">
      <b-col cols="12" lg="3">
        <FormAlojamientosVue />
      </b-col>
      <b-col cols="12" lg="9">
        <AlojamientosVue />
      </b-col>
    </div>
  </div>
</template>

<script>
import AlojamientosVue from "../components/AlojamientosVue.vue";
import FormAlojamientosVue from "../components/FormAlojamientosVue.vue";
import BannerVue from "../components/BannerVue.vue";

export default {
  name: "alojamientos",
  components: {
    AlojamientosVue,
    FormAlojamientosVue,
    BannerVue,
  },
};
</script>

<style scoped>
#alojamientos_form_cajas {
  display: flex;
  flex-wrap: wrap;
  width: 80%;
  margin: 0 auto;
}

#formulario_alojamientos {
  margin-top: 75px;
}
</style>
