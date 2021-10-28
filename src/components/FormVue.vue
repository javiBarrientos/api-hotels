<template>
  <div id="formulario">
    <b-form id="formulario_form" class="justify-content-center" inline>
      <b-form-input
        class="mb-2 mr-sm-2 mb-sm-0"
        placeholder="Localizacion"
        v-model="form.formulario_localizacion"
      ></b-form-input>

      <b-form-select
        class="mb-2 mr-sm-2 mb-sm-0"
        v-model="form.formulario_personas"
        :options="[{ text: 'Personas', value: null }, '1', '2', '3', '4', '5']"
        :value="null"
      ></b-form-select>

      <b-form-datepicker
        locale="en"
        v-model="form.formulario_entrada"
        class="mb-2 mr-sm-2 mb-sm-0"
      ></b-form-datepicker>

      <b-form-datepicker
        locale="en"
        v-model="form.formulario_salida"
        class="mb-2 mr-sm-2 mb-sm-0"
      ></b-form-datepicker>

      <b-form-select
        class="mb-2 mr-sm-2 mb-sm-0"
        v-model="form.formulario_destino"
        :options="[{ text: 'Destino', value: null }, 'Mallorca', 'Galicia']"
        :value="null"
      ></b-form-select>
      <b-button type="submit" variant="primary">Buscar</b-button>
    </b-form>
  </div>
</template>

<script>
export default {
  name: "FormVue",
  data() {
    return {
      form: {
        formulario_localizacion: "",
        formulario_personas: null,
        formulario_entrada: "",
        formulario_salida: "",
        formulario_destino: null,
      },
    };
  },
  methods: {
    openStorage() {
      return JSON.parse(localStorage.getItem("form"));
    },
    saveStorage() {
      localStorage.setItem("form", JSON.stringify(form));
    },
  },
};
</script>

<style scoped>
#formulario {
  margin-top: 20px;
  margin-bottom: 20px;
  display: flex;
  justify-content: center;
}

#formulario_carta {
  width: 70%;
}
</style>
