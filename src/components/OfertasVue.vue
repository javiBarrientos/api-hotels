<template>
  <div id="container_ofertas">
    <h2>
      Ofertas de hoteles
    </h2>
    <b-container class="bv-example-row">
      <b-col
        v-for="(hotel, item) in hoteles.slice(0, 4)"
        :key="item"
        cols="12"
        md="6"
        lg="4"
        xl="3"
      >
        <b-card
          :title="hotel.name"
          img-src="../assets/img/id1.jpg"
          img-alt="Image"
          img-top
          tag="article"
          class="mb-2"
          id="card"
        >
          <b-card-text>
            <b-button
              :to="{ name: 'particular', params: { id: hotel.id } }"
              type="submit"
              variant="primary"
              >Mas info</b-button
            >
          </b-card-text>
          <b-card-text>
            <b-form-rating
              id="rating_hotel"
              :value="hotel.stars"
              disabled
            ></b-form-rating>
          </b-card-text>
        </b-card>
      </b-col>
    </b-container>
  </div>
</template>

<script>
import HotelDataService from "../services/hotel.service";

export default {
  // name: "container",
  name: "OfertasVue",
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

#rating_hotel {
  color: rgb(218, 218, 0);
  background-color: transparent;
  border: none;
}

#container_ofertas {
  width: 80%;
  margin: 0 auto;
}

#container_ofertas h2 {
  text-align: center;
  padding-bottom: 10px;
  padding-top: 10px;
}

#container_ofertas .container {
  display: flex;
  flex-wrap: wrap;
  width: 100%;
  margin-top: 20px;
  max-width: none;
}

.container img {
  height: 300px;
}

.container #card {
  box-shadow: 0 0 3rem rgba(0, 0, 0, 0.466);
}

article h4 {
  text-align: center;
  font-size: 1.2em;
}

article .card-body .card-text {
  display: flex;
  justify-content: space-between;
}

#container_ofertas h3 {
  margin-bottom: 30px;
  margin-top: 30px;
}
</style>
