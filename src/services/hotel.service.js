import axios from 'axios';

const API_URL = 'http://localhost:9000/api/hotels/';

class HotelDataService {
    getAll() {
        return axios.get(API_URL + "hotels");
    }

    getHotelById(id) {
        return axios.get(API_URL + `hotel/${id}`)
    }
}

export default new HotelDataService();