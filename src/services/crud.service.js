import axios from 'axios';

const API_URL = 'http://localhost:9000/api/users/';

class CrudDataService {
    getAll() {
        return axios.get(API_URL + "users");
    }

    delete(user) {
        return axios.delete(API_URL + `delete/${user}`)
    }
}

export default new CrudDataService();