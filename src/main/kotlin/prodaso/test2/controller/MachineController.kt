package prodaso.test2.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import prodaso.test2.model.Machine
import prodaso.test2.repository.MachineDataProvider

@CrossOrigin( "http://localhost:8081" )
@RestController
@RequestMapping("/prodaso/machines")
class MachineController {

    @Autowired
    lateinit var machineDataProvider : MachineDataProvider

    @GetMapping
    fun getAllMachines(): List<Machine> = machineDataProvider.getAll()

    @GetMapping("/{id}")
    fun getMachine(@PathVariable id: Int): Machine? = machineDataProvider.getById(id)

    @DeleteMapping("/{id}")
    fun removeMachine(@PathVariable id: Int) = machineDataProvider.removeById(id)

    @PostMapping
    fun updateMachine(@RequestBody machine: Machine): Int {
        machineDataProvider.addOrUpdate(machine)
        return machine.id
    }
}