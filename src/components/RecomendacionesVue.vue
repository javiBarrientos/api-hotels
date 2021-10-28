<template>
  <div id="container_recomendaciones">
    <h2>
      Recomendaciones de los usuarios
    </h2>
    <b-carousel
      style="text-shadow: 0px 0px 2px #000"
      fade
      controls
      id="container_carousel"
    >
      <b-carousel-slide
        v-for="(hotel, item) in hoteles.slice(0, 4)"
        :key="item"
        :caption="hotel.name"
        img-src="../assets/img/id1.jpg"
        class="imagenes_carousel"
      >
        <h1>{{ hotel.name }}</h1>
        <b-button
          :to="{ name: 'particular', params: { id: hotel.id } }"
          type="submit"
          variant="primary"
          >Mas info</b-button
        >
        <b-button
          :to="{ name: 'particular', params: { id: hotel.id } }"
          type="submit"
          variant="primary"
          >{{ hotel.valorations }}</b-button
        >
        <b-button
          :to="{ name: 'particular', params: { id: hotel.id } }"
          type="submit"
          variant="primary"
          >{{ hotel.comments }}</b-button
        >
      </b-carousel-slide>
    </b-carousel>
  </div>
</template>

<script>
import HotelDataService from "../services/hotel.service";

export default {
  // name: "container",
  name: "RecomendacionesVue",
  data() {
    return {
      hoteles: [],
    };
  },
  mounted() {
    this.show();
  },
  methods: {
    show() {
      HotelDataService.getAll()
        .then((response) => {
          this.hoteles = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}

#container_recomendaciones {
  margin-top: 20px;
  width: 80%;
  margin: 0 auto;
}

#container_recomendaciones :nth-child(2) {
  margin: 0 auto;
}

#container_carousel {
  width: 60%;
  box-shadow: 0 0 3rem rgba(0, 0, 0, 0.466);
}

#container_recomendaciones h2 {
  text-align: center;
  margin-bottom: 30px;
  margin-top: 30px;
}

.imagenes_carousel :nth-child(1) {
  height: 600px !important;
}

@media (min-width: 500px) {
  #container_carousel {
    width: 80%;
  }
}

@media (min-width: 1200px) {
  #container_carousel {
    width: 70%;
  }
}
</style>
