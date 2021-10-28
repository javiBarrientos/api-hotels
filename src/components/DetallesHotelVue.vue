<template>
  <div id="container_hotel">
    <h1>
      {{ hotelDetalles.name }}
    </h1>
    <b-row>
      <b-col id="segunda_columna" cols="8" xs="12" sm="12" md="6" lx="6">
        <img img-src="../assets/img/id1.jpg" :alt="hotelDetalles.name" />
      </b-col>
      <b-col id="tercera_columna" cols="8" xs="12" sm="12" md="6" lx="6">
        <gallery
          :images="images"
          :index="index"
          @close="index = null"
        ></gallery>
        <div
          class="image"
          v-for="(image, imageIndex) in images"
          :key="imageIndex"
          @click="index = imageIndex"
          :style="{
            backgroundImage: 'url(' + image + ')',
            width: '45%',
            height: '200px',
          }"
        ></div>
      </b-col>
      <b-col id="primera_columna" cols="12" xs="12" sm="12" md="4" lx="4">
        <b-card-text>
          Estrellas:
          <b-form-rating :value="hotelDetalles.stars" disabled></b-form-rating>

          Wifi:
          <b-form-checkbox v-model="hotelDetalles.wifi" disabled>
          </b-form-checkbox>

          Desayuno:
          <b-form-checkbox v-model="hotelDetalles.breakfast" disabled>
          </b-form-checkbox>

          Localizacion:
          {{ hotelDetalles.location }}
          <br />
          Zona:
          {{ hotelDetalles.zone }}
        </b-card-text>

        <div id="boton_reserva">
          <b-button
            v-if="isLoggedIn"
            type="submit"
            variant="primary"
            :to="{ name: 'reservaHotel', params: { id: hotelDetalles.id } }"
            >Reservar</b-button
          >
          <b-button v-else type="submit" variant="primary" to="/login"
            >Reservar</b-button
          >
        </div>
      </b-col>
    </b-row>
    <b-row id="formulario_mapa_video">
      <b-col cols="12" xs="12" sm="12" md="6" lx="6">
        <GoogleMap
          :latitude="hotelDetalles.latitude"
          :longitude="hotelDetalles.altitude"
          :title="'Titutlo Marcador'"
        ></GoogleMap>
      </b-col>
      <b-col cols="12" xs="12" sm="12" md="6" lx="6">
        <b-embed
          type="iframe"
          aspect="16by9"
          id="video_hotel"
          src="https://www.youtube.com/embed/sWBueqYA2Es"
        ></b-embed>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import GoogleMap from "./GoogleMap.vue";
import VueGallery from "vue-gallery";
import HotelDataService from "../services/hotel.service";

export default {
  name: "DetallesHotelVue",
  computed: {
    isLoggedIn: function() {
      return this.$store.getters.isLoggedIn;
    },
  },
  components: {
    GoogleMap,
    gallery: VueGallery,
  },
  data() {
    return {
      hotelDetalles: {},
      images: [
        "https://fenaer.es/wp-content/uploads/2020/07/black-370118_1280.png",
        "https://i.ytimg.com/vi/-QCoV4U1H1w/maxresdefault.jpg",
        "https://dummyimage.com/1280/000000/ffffff",
        "https://dummyimage.com/400/000000/ffffff",
      ],
      index: null,
    };
  },
  mounted() {
    this.show(this.$route.params.id);
  },
  methods: {
    show(id) {
      HotelDataService.getHotelById(id)
        .then((response) => {
          this.hotelDetalles = response.data;
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
#container_hotel {
  width: 80%;
  margin: 0 auto;
}

#container_hotel h1 {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin: 20px;
}

#primera_columna p {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  flex-direction: column;
}

#primera_columna #boton_reserva {
  display: flex;
  justify-content: center;
  align-items: flex-end;
}

#segunda_columna {
  display: flex;
  flex-wrap: wrap;
  margin-bottom: 10px;
}

#segunda_columna img {
  width: 100%;
  max-height: 500px;
  box-shadow: 0 0 3rem rgba(0, 0, 0, 0.466);
}

#tercera_columna {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.image {
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center center;
  margin: 5px;
  box-shadow: 0 0 3rem rgba(0, 0, 0, 0.466);
}

#formulario_mapa_video {
  width: 100%;
  margin-top: 20px;
}

#mapa {
  box-shadow: 0 0 3rem rgba(0, 0, 0, 0.466);
}

.embed-responsive {
  box-shadow: 0 0 3rem rgba(0, 0, 0, 0.466);
}

#formulario_mapa_video :only-child {
  width: 100%;
  height: 400px;
  margin-bottom: 10px;
}
</style>
