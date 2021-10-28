<template>
  <div id="contenedor_tabs">
    <b-card no-body>
      <b-tabs v-model="tabIndex">
        <b-tab id="tab_hotel" title="Hotel" active>
          <p><b>Nombre:</b> {{ hotelDetalles.nombre }}</p>
          <p><b>Zona:</b> {{ hotelDetalles.zona }}</p>
          <p><b>Localizacion:</b> {{ hotelDetalles.localizacion }}</p>
          <p><b>Estrellas:</b> {{ hotelDetalles.estrellas }}</p>
          <p><b>Valoraciones:</b> {{ hotelDetalles.mediaValoraciones }}</p>
          <div id="div_formulario">
            <p>Habitacion</p>
            <b-form-select v-model="selected" class="mb-3">
              <b-form-select-option :value="null"
                >Singular</b-form-select-option
              >
              <b-form-select-option :value="null">Doble</b-form-select-option>
              <b-form-select-option :value="null">Triple</b-form-select-option>
            </b-form-select>

            <p>Camas</p>
            <b-form-select v-model="selected" class="mb-3">
              <b-form-select-option :value="null"
                >Doble, pequeña</b-form-select-option
              >
              <b-form-select-option :value="null"
                >Triple pequeña</b-form-select-option
              >
              <b-form-select-option :value="null">Doble</b-form-select-option>
            </b-form-select>

            <p>Personas</p>
            <b-form-select v-model="selected" class="mb-3">
              <b-form-select-option :value="null">1</b-form-select-option>
              <b-form-select-option :value="null">2</b-form-select-option>
              <b-form-select-option :value="null">3</b-form-select-option>
            </b-form-select>
          </div>
        </b-tab>
        <b-tab id="tab_usuario" title="Usuario">
          <div>
            <p><b>Nombre:</b> Javi</p>
            <p><b>Apellido:</b> Barrientos</p>
            <p><b>Dni:</b> 23590276J</p>
            <p><b>Email:</b> pepe.man@pepe.com</p>
          </div>
        </b-tab>
        <b-tab title="Pago"></b-tab>
      </b-tabs>
    </b-card>
    <div class="mt-2 botones_index">
      <b-button @click="tabIndex--" variant="danger">Atras</b-button>
      <b-button @click="tabIndex++" variant="success">Continuar</b-button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ReservaHotelVue",
  data() {
    return {
      hotelDetalles: {},
      tabIndex: 1,
    };
  },
  mounted() {
    axios
      .get("http://localhost:3000/hoteles/" + this.$route.params.id)
      .then((response) => {
        this.hotelDetalles = response.data;
      });
  },
};
</script>

<style scoped>
#contenedor_tabs {
  width: 80%;
  margin: 0 auto;
  margin-top: 20px;
}

#tab_usuario {
  width: 50%;
  display: flex;
  margin: 10px;
}

#tab_hotel {
  margin: 10px;
}

#div_formulario {
  display: flex;
}

.botones_index :first-child {
  margin-right: 5px;
}
</style>
