<template>
  <div id="contenedor_alojamientos">
    <div id="botones_alojamientos">
      <b-button type="submit" variant="primary" v-on:click="ordenarEstrellas"
        >Estrellas</b-button
      >
      <b-button type="submit" variant="primary" v-on:click="ordenarValoraciones"
        >Valoraciones</b-button
      >
    </div>
    <b-container class="bv-example-row">
      <b-col v-for="(hotel, item) in hotel_filtrado" :key="item" cols="12">
        <b-card
          :title="hotel.name"
          img-src="../assets/img/id1.jpg"
          img-alt="Image"
          img-top
          tag="article"
          class="mb-2 hotel_card"
        >
          <b-card-text>
            Valoraciones: {{ hotel.valorations }}
            <br />
            <div id="boton_formulario_alojamientos">
              <b-button
                :to="{ name: 'particular', params: { id: hotel.id } }"
                type="submit"
                variant="primary"
                >Mas info</b-button
              >
            </div>
            <b-form-rating
              id="rating_hotel"
              :value="hotel.stars"
              disabled
            ></b-form-rating>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Sapiente,
              quisquam ratione? Qui, nihil? Voluptas at nam velit. Asperiores
              odio, accusamus, veritatis vel maxime dolorem corrupti laudantium
              quod perspiciatis consectetur voluptatibus.
            </p>
          </b-card-text>
        </b-card>
      </b-col>
    </b-container>
  </div>
</template>

<script>
import { getImgUrl } from "../util/javascriptUtils.js";
import { bus } from "../main";
import HotelDataService from "../services/hotel.service";

export default {
  name: "AlojamientosVue",
  data() {
    return {
      valor_filtro: null,
      hoteles: [],
    };
  },
  mounted() {
    this.show();
  },
  methods: {
    getImgUrl,
    ordenarEstrellas() {
      function compare(a, b) {
        if (a.stars < b.stars) return -1;
        if (a.stars > b.stars) return 1;
        return 0;
      }

      return this.hoteles.sort(compare);
    },
    ordenarValoraciones() {
      function compare(a, b) {
        if (a.valorations > b.valorations) return -1;
        if (a.valorations < b.valorations) return 1;
        return 0;
      }

      return this.hoteles.sort(compare);
    },
    show() {
      HotelDataService.getAll()
        .then((response) => {
          this.hoteles = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  computed: {
    hotel_filtrado() {
      var hoteles_filtrados = this.hoteles;
      if (this.valor_filtro) {
        if (this.valor_filtro.wifi != false) {
          let resultado = hoteles_filtrados.filter(
            (hotel) => hotel.wifi == this.valor_filtro.wifi
          );
          hoteles_filtrados = resultado;
        }
        if (this.valor_filtro.breakfast != false) {
          let resultado = hoteles_filtrados.filter(
            (hotel) => hotel.breakfast == this.valor_filtro.breakfast
          );
          hoteles_filtrados = resultado;
        }
        /*
        if (this.valor_filtro.entrada != null) {
          let resultado = hoteles_filtrados.filter(
            (hotel) => hotel.diaEntrada <= this.valor_filtro.entrada
          );
          hoteles_filtrados = resultado;
        }
        if (this.valor_filtro.salida != null) {
          let resultado = hoteles_filtrados.filter(
            (hotel) => hotel.diaSalida >= this.valor_filtro.salida
          );
          hoteles_filtrados = resultado;
        }
        */
        if (this.valor_filtro.stars != null) {
          let resultado = hoteles_filtrados.filter(
            (hotel) => hotel.stars == this.valor_filtro.stars
          );
          hoteles_filtrados = resultado;
        }
        if (this.valor_filtro.max_people != null) {
          let resultado = hoteles_filtrados.filter(
            (hotel) => hotel.maxmax_people <= this.valor_filtro.max_people
          );
          hoteles_filtrados = resultado;
        }
        if (this.valor_filtro.precioMinimo != null) {
          let resultado = hoteles_filtrados.filter(
            (hotel) => hotel.fee >= this.valor_filtro.precioMinimo
          );
          hoteles_filtrados = resultado;
        }
        if (this.valor_filtro.precioMaximo != null) {
          let resultado = hoteles_filtrados.filter(
            (hotel) => hotel.fee <= this.valor_filtro.precioMaximo
          );
          hoteles_filtrados = resultado;
        }
      }
      return hoteles_filtrados;
    },
  },
  created() {
    bus.$on("valor_filtro", (filtros) => {
      this.valor_filtro = filtros;
    });
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}

#botones_alojamientos {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

#botones_alojamientos > :first-child {
  margin-right: 20px;
}

.container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-top: 20px;
}

.hotel_card {
  box-shadow: 0 0 3rem rgba(0, 0, 0, 0.466);
}

.container h4 {
  text-align: center;
  font-size: 1.2em;
}

#rating_hotel {
  color: rgb(218, 218, 0);
  background-color: transparent;
  border: none;
}

.container img {
  width: 40%;
  height: 300px;
}

article {
  width: 100%;
  display: flex;
  flex-direction: row;
}

article .card-body .card-text {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

#boton_formulario_alojamientos {
  justify-content: center;
}

article .card-body {
  width: 60%;
}
</style>
