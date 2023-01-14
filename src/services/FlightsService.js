import axios from "axios";

const FLIGHT_BASE_REST_API_URL = 'http://localhost:8080/api-flights/flights';

class FlightService{

    getAllFlights(){
        return axios.get(FLIGHT_BASE_REST_API_URL);
    }
}

export default new FlightService();