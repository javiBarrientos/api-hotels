<template>
  <div id="formulario_alojamientos">
    <form class="text-center border border-light p-5">
      <p class="h4 mb-4">Reserva</p>
      <b-form-checkbox v-model="form_wifi_filter" switch inline class="my-2">
        Wifi
      </b-form-checkbox>
      <b-form-checkbox
        v-model="form_desayuno_filter"
        switch
        inline
        class="my-2"
      >
        Desayuno
      </b-form-checkbox>

      <p>Fecha de entrada</p>
      <b-form-datepicker
        v-model="form_entrada_filter"
        locale="en"
      ></b-form-datepicker>
      <br />

      <p>Fecha de salida</p>
      <b-form-datepicker
        v-model="form_salida_filter"
        locale="en"
      ></b-form-datepicker>
      <br />

      <b-form-rating
        id="form_valoracion"
        v-model="form_estrellas_filter"
      ></b-form-rating>

      <br />
      <b-form-select
        v-model="form_personas_filter"
        class="mb-2 mr-sm-2 mb-sm-0"
        :options="[{ text: 'Personas', value: null }, '1', '2', '3', '4', '5']"
        :value="null"
      ></b-form-select>
      <br />
      <br />

      <p>Precio</p>
      <div id="prueba">
        <b-form-input
          v-model="form_precio_minimo_filter"
          placeholder="Precio minimo"
        ></b-form-input>
        <b-form-input
          v-model="form_precio_maximo_filter"
          placeholder="Precio maximo"
        ></b-form-input>
      </div>

      <br />
      <br />
      <b-button type="submit" variant="primary" v-on:click="filtrar_hoteles"
        >Buscar</b-button
      >
      <b-button type="submit" variant="danger" v-on:click="actualizar"
        >Borrar</b-button
      >
    </form>
  </div>
</template>

<script>
import { bus } from "../main";

export default {
  name: "FormAlojamientosVue",
  data() {
    return {
      form_wifi_filter: false,
      form_desayuno_filter: false,
      form_entrada_filter: null,
      form_salida_filter: null,
      form_estrellas_filter: null,
      form_personas_filter: null,
      form_precio_minimo_filter: null,
      form_precio_maximo_filter: null,
    };
  },
  methods: {
    filtrar_hoteles() {
      bus.$emit("valor_filtro", {
        wifi: this.form_wifi_filter,
        desayuno: this.form_desayuno_filter,
        entrada: this.form_entrada_filter,
        salida: this.form_salida_filter,
        estrellas: this.form_estrellas_filter,
        personas: this.form_personas_filter,
        precioMinimo: this.form_precio_minimo_filter,
        precioMaximo: this.form_precio_maximo_filter,
      });
    },
    actualizar() {
      window.location.reload();
    },
  },
};
</script>

<style scope>
#formulario_alojamientos {
  display: flex;
  justify-content: center;
  margin-top: 40px;
  box-shadow: 0 0 0.5rem rgba(0, 0, 0, 0.466);
}

#enlace_registro {
  display: flex;
  justify-content: flex-end;
  align-items: center;
}

#form_valoracion {
  border: 0px;
}

#prueba {
  display: flex;
  flex-wrap: wrap;
}

#prueba .form-control {
  width: 50%;
}
</style>
