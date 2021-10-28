<template>
  <div id="header_contendor">
    <b-navbar toggleable="lg" type="dark" variant="dark">
      <img
        src="../assets/logo_hotel.png"
        class="d-inline-block align-top"
        alt="logo"
        id="logo"
      />

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item to="/">
            <b-icon icon="house"> </b-icon>
            Home
          </b-nav-item>

          <b-nav-item to="/alojamientos">
            <b-icon icon="geo-alt-fill"> </b-icon>
            Alojamientos</b-nav-item
          >

          <b-nav-item v-if="showAdminBoard" to="/admin">
            <b-icon icon="display"></b-icon>
            Admin
          </b-nav-item>

          <b-nav-item v-if="showModeratorBoard" to="/mod">
            <b-icon icon="display"></b-icon>
            Moderator
          </b-nav-item>

          <b-nav-item v-if="currentUser" to="/user">
            <b-icon icon="display"></b-icon>
            User
          </b-nav-item>
        </b-navbar-nav>

        <b-navbar-nav v-if="!currentUser" class="ml-auto">
          <b-nav-item to="/login">
            <b-icon icon="person-circle"> </b-icon>
            Login
          </b-nav-item>
          <b-nav-item to="/register">
            <b-icon icon="person-plus"> </b-icon>
            Registro
          </b-nav-item>
        </b-navbar-nav>

        <b-navbar-nav v-if="currentUser" class="ml-auto">
          <b-nav-item to="/perfil">
            <b-icon icon="people"> </b-icon>
            Perfil</b-nav-item
          >
          <a class="nav-link" href @click.prevent="logOut">
            <b-icon icon="person-dash"> </b-icon> Logout</a
          >
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "HeaderVue",
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes("ROLE_ADMIN");
      }
      return false;
    },
    showModeratorBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes("ROLE_MODERATOR");
      }
      return false;
    },
  },
  methods: {
    logOut() {
      this.$store.dispatch("auth/logout");
      this.$router.push("/login");
    },
  },
};
</script>

<style>
#logo {
  height: 90px;
}
</style>
