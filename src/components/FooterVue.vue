<template>
  <div id="container_footer">
    <footer class="bg-light text-center text-lg-left">
      <cookie-law theme="dark-lime" buttonText="Got it!" storageType="cookies">
      </cookie-law>
      <div
        class="text-center p-3"
        style="background-color: rgba(0, 0, 0, 0.2);"
      >
        © 2020 Copyright:
        <a class="text-dark" href="https://mdbootstrap.com/">MDBootstrap.com</a>
      </div>
    </footer>
  </div>
</template>

<script>
import CookieLaw from "vue-cookie-law";

export default {
  name: "FooterVue",
  components: { CookieLaw },
};
</script>

<style scoped>
footer {
  margin-top: 20px;
}
</style>
