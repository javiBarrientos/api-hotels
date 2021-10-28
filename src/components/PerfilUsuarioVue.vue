<template>
  <b-card title="Perfil de usuario" id="card">
    <b-tabs content-class="mt-3">
      <b-tab title="Perfil" id="card_perfil" active>
        <b-avatar
          variant="info"
          src="https://placekitten.com/300/300"
          size="8rem"
        ></b-avatar>
        <p><strong>Username: </strong> {{ currentUser.username }}</p>
        <p><strong>Name: </strong> {{ currentUser.name }}</p>
        <p><strong>Surname: </strong> {{ currentUser.surname }}</p>
        <p><strong>Email: </strong> {{ currentUser.email }}</p>
      </b-tab>

      <b-tab title="Cuenta">
        <b-form @submit.prevent="handleUpdate" id="settings_form">
          Username
          <b-form-input
            v-model="user.username"
            class="input_formulario"
            v-validate="'required|min:3|max:20'"
            type="text"
            name="username"
            placeholder="Username"
          ></b-form-input>

          <br />

          Nombre
          <b-form-input
            v-model="user.name"
            class="input_formulario"
            v-validate="'required|min:3|max:20'"
            type="text"
            name="name"
            placeholder="Name"
          ></b-form-input>

          <br />

          Apellido
          <b-form-input
            v-model="user.surname"
            class="input_formulario"
            v-validate="'required|min:3|max:20'"
            type="text"
            name="surname"
            placeholder="Surname"
          ></b-form-input>

          <br />

          Correo
          <b-form-input
            v-model="user.email"
            class="input_formulario"
            v-validate="'required|email|max:50'"
            type="email"
            name="email"
            placeholder="Email"
          ></b-form-input>

          <br />

          Contraseña
          <b-form-input
            v-model="user.password"
            class="input_formulario"
            v-validate="'required|min:6|max:40'"
            type="password"
            name="password"
            placeholder="Password"
          ></b-form-input>

          <br />
          <b-button type="submit" variant="primary" id="boton_formulario"
            >Submit</b-button
          >
        </b-form>
        <br />
        <br />
        <div
          v-if="message"
          class="alert"
          :class="successful ? 'alert-success' : 'alert-danger'"
        >
          {{ message }}
        </div>
      </b-tab>

      <b-tab title="Hoteles"></b-tab>
    </b-tabs>
  </b-card>
</template>

<script>
import User from "../models/user";

export default {
  name: "PerfilUsuarioVue",
  data() {
    return {
      user: new User("", "", "", "", ""),
      submitted: false,
      successful: false,
      message: "",
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push("/login");
    }
  },
  methods: {
    handleUpdate() {
      this.message = "";
      this.submitted = true;
      this.$validator.validate().then((isValid) => {
        if (isValid) {
          this.$store.dispatch("auth/update", this.currentUser.username).then(
            (data) => {
              this.message = data.message;
              this.successful = true;
            },
            (error) => {
              this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
              this.successful = false;
            }
          );
        }
      });
    },
  },
};
</script>

<style scoped>
#card {
  width: 60%;
  margin-top: 20px;
  margin: 0 auto;
  margin-top: 20px;
  margin-bottom: 18.6%;
}

#card_perfil {
  display: flex;
  flex-direction: column;
  align-items: center;
}

h3 {
  padding: 10px;
}

img {
  height: 200px;
  width: 200px;
}

#boton_formulario {
  float: right;
}
</style>
