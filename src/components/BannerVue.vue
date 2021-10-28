<template>
  <div id="imagen_banner">
    <img src="../assets/banner_hotel.png" alt="banner" />
  </div>
</template>

<script>
export default {
  name: "BannerVue",
};
</script>

<style scoped>
#imagen_banner {
  display: flex;
  justify-content: center;
}

#imagen_banner img {
  width: 80%;
  margin-top: 20px;
  box-shadow: 0 0 0.5rem rgba(0, 0, 0, 0.466);
}
</style>
