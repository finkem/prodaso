import axios from 'axios'

const API_URL = "http://localhost:8080";
const PRODASO_API_URL = `${API_URL}/prodaso`

class MachineDataService {
    retrieveAllMachines() {
        return axios.get(`${PRODASO_API_URL}/machines`);
    }
}

export default new MachineDataService();