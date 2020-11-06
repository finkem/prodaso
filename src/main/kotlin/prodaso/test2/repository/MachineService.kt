package prodaso.test2.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import prodaso.test2.model.Machine

@Service
class MachineService {

    @Autowired
    lateinit var machineRepository : IMachineRepository

    fun getAll(): List<Machine> {
        val machines = arrayListOf<Machine>()
        machineRepository.findAll().forEach { machines.add(it) }
        return machines
    }

    fun getById(id: Int): Machine {
        return machineRepository.findById(id).get()
    }

    fun addOrUpdate(machine: Machine) {
        machineRepository.save(machine)
    }

    fun removeById(id: Int) {
        machineRepository.deleteById(id)
    }
}