import axios from 'axios'

const API_URL = "http://localhost:8080";
const PRODASO_API_URL = `${API_URL}/prodaso`

class MachineDataService {
    retrieveAllMachines() {
        return axios.get(`${PRODASO_API_URL}/machines`);
    }
    deleteMachine(id) {
        return axios.delete(`${PRODASO_API_URL}/machines/${id}`);
    }
}

export default new MachineDataService();