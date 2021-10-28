<template>
  <div id="formulario_login">
    <form
      name="form"
      id="formulario"
      class="text-center border border-light p-5"
      @submit.prevent="handleLogin"
    >
      <p class="h4 mb-4">Inicio de sesion</p>
      <input
        v-model="user.username"
        v-validate="'required'"
        type="text"
        class="form-control"
        name="username"
        placeholder="Username"
      />
      <br />
      <div
        v-if="errors.has('username')"
        class="alert alert-danger"
        role="alert"
      >
        Username is required!
      </div>
      <input
        v-model="user.password"
        v-validate="'required'"
        type="password"
        class="form-control"
        name="password"
        placeholder="Password"
      />
      <br />
      <div
        v-if="errors.has('password')"
        class="alert alert-danger"
        role="alert"
      >
        Password is required!
      </div>
      <small
        id="defaultRegisterFormPasswordHelpBlock"
        class="form-text text-muted mb-4"
      >
      </small>
      <small
        id="defaultRegisterFormPhoneHelpBlock"
        class="form-text text-muted mb-4"
      >
      </small>
      <button block class="btn btn-primary btn-block" :disabled="loading">
        <span v-show="loading" class="spinner-border spinner-border-sm"></span>
        <span>Login</span>
      </button>
      <p id="enlace_registro">
        Si no tienes cuenta pulsa aqui para
        <b-nav-item to="/register">registrar</b-nav-item>
      </p>
      <div v-if="message" class="alert alert-danger" role="alert">
        {{ message }}
      </div>
    </form>
  </div>
</template>

<script>
import User from "../models/user";

export default {
  name: "LoginVue",
  data() {
    return {
      user: new User("", ""),
      loading: false,
      message: "",
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/perfil");
    }
  },
  methods: {
    handleLogin() {
      this.loading = true;
      this.$validator.validateAll().then((isValid) => {
        if (!isValid) {
          this.loading = false;
          return;
        }

        if (this.user.username && this.user.password) {
          this.$store.dispatch("auth/login", this.user).then(
            () => {
              this.$router.push("/perfil");
            },
            (error) => {
              this.loading = false;
              this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
            }
          );
        }
      });
    },
  },
};
</script>

<style scoped>
#formulario_login {
  display: flex;
  justify-content: center;
  margin-bottom: 21.7%;
}

#formulario {
  max-width: 500px;
}

#enlace_registro {
  display: flex;
  justify-content: center;
  list-style-type: none;
  align-items: center;
}

.nav-link {
  padding: 0.3rem;
}
</style>
