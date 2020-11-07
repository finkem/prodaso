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
    retrieveMachine(id) {
        return axios.get(`${PRODASO_API_URL}/machines/${id}`);
    }
    updateMachine(id, machine) {
        return axios.put(`${PRODASO_API_URL}/machines/${id}`, machine);
    }
    addMachine(machine) {
        return axios.post(`${PRODASO_API_URL}/machines`, machine);
    }
}

export default new MachineDataService();