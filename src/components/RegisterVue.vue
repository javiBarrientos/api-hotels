<template>
  <div id="formulario_registro">
    <form id="formulario" name="form" @submit.prevent="handleRegister">
      <p class="h4 mb-4">Registro</p>
      <div v-if="!successful">
        <input
          v-model="user.username"
          v-validate="'required|min:3|max:20'"
          type="text"
          class="form-control"
          name="username"
          placeholder="Username"
        />
        <br />
        <div v-if="submitted && errors.has('username')" class="alert-danger">
          {{ errors.first("username") }}
        </div>
        <div class="form-row mb-4">
          <div class="col">
            <input
              v-model="user.name"
              v-validate="'required|min:3|max:20'"
              type="text"
              class="form-control"
              name="name"
              placeholder="Name"
            />
          </div>
          <div class="col">
            <input
              v-model="user.surname"
              v-validate="'required|min:3|max:20'"
              type="text"
              class="form-control"
              name="surname"
              placeholder="Surname"
            />
          </div>
        </div>
        <input
          v-model="user.email"
          v-validate="'required|email|max:50'"
          type="email"
          class="form-control"
          name="email"
          placeholder="Email"
        />
        <br />
        <div v-if="submitted && errors.has('email')" class="alert-danger">
          {{ errors.first("email") }}
        </div>

        <input
          v-model="user.password"
          v-validate="'required|min:6|max:40'"
          type="password"
          class="form-control"
          name="password"
          placeholder="Password"
        />
        <br />
        <div v-if="submitted && errors.has('password')" class="alert-danger">
          {{ errors.first("password") }}
        </div>

        <button class="btn btn-primary btn-block">Sign Up</button>
        <p id="enlace_login">
          Si ya tienes cuenta pulsa aqui para hacer
          <b-nav-item to="/login">login</b-nav-item>
        </p>
      </div>
    </form>

    <div
      v-if="message"
      class="alert"
      :class="successful ? 'alert-success' : 'alert-danger'"
    >
      {{ message }}
    </div>
  </div>
</template>

<script>
import User from "../models/user";

export default {
  name: "RegisterVue",
  data() {
    return {
      user: new User("", "", "", "", ""),
      submitted: false,
      successful: false,
      message: "",
    };
  },

  methods: {
    handleRegister() {
      this.message = "";
      this.submitted = true;
      this.$validator.validate().then((isValid) => {
        if (isValid) {
          this.$store.dispatch("auth/register", this.user).then(
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
#formulario_registro {
  display: flex;
  justify-content: center;
  margin-bottom: 21.7%;
}

#formulario {
  max-width: 500px;
}

#enlace_login {
  display: flex;
  justify-content: center;
  list-style-type: none;
  align-items: center;
}

.nav-link {
  padding: 0.3rem;
}
</style>
