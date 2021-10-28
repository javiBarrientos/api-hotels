<template>
  <div class="container">
    <table id="table">
      <h2>Users table</h2>
      <tr>
        <th scope="col">
          Username
        </th>
        <th scope="col">
          Name
        </th>
        <th scope="col">
          Surname
        </th>

        <th scope="col">
          Email
        </th>
        <th scope="col">
          Update
        </th>
        <th scope="col">
          Delete
        </th>
      </tr>
      <tr
        :class="{ active: index == currentIndex }"
        v-for="(user, index) in users"
        :key="index"
        @click="setActiveUser(user, index)"
      >
        <td>
          {{ user.username }}
        </td>
        <td>
          {{ user.name }}
        </td>
        <td>
          {{ user.surname }}
        </td>

        <td>
          {{ user.email }}
        </td>
        <td>
          <b-button variant="success">Update</b-button>
        </td>
        <td>
          <b-button variant="danger" v-on:click="deleteUser(user.id)"
            >Delete</b-button
          >
        </td>
      </tr>
      <b-button id="redirect_button" variant="outline-primary" to="/register"
        >Create</b-button
      >
    </table>
  </div>
</template>

<script>
import CrudDataService from "../../services/crud.service";

export default {
  name: "AdminBoard",
  data() {
    return {
      users: [],
      currentUser: null,
      currentIndex: -1,
      name: "",
    };
  },
  methods: {
    show() {
      CrudDataService.getAll()
        .then((response) => {
          this.users = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    setActiveUser(user, index) {
      this.currentUser = user;
      this.currentIndex = index;
    },
    deleteUser(user) {
      if (confirm("Do you really want to delete?")) {
        CrudDataService.delete(user)
          .then((response) => {
            console.log(response.data);
          })
          .catch((e) => {
            console.log(e);
          });
      }
    },
  },
  mounted() {
    this.show();
  },
};
</script>

<style scoped>
.container {
  margin-bottom: 32.4%;
  display: flex;
  justify-content: center;
}

table {
  margin: 10px;
}

th,
td {
  border-bottom: 1px solid grey;
  border-top: 1px solid grey;
  padding-left: 15px;
  padding-right: 15px;
}

#redirect_button {
  margin-top: 10px;
}
</style>
