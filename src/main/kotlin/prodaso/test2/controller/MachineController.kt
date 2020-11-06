package prodaso.test2.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import prodaso.test2.model.Machine
import prodaso.test2.repository.MachineService

@RestController
@RequestMapping("/machines")
class MachineController {

    @Autowired
    lateinit var machineService : MachineService

    @GetMapping
    fun getAllMachines(): List<Machine> = machineService.getAll()

    @GetMapping("/{id}")
    fun getMachine(@PathVariable id: Int): Machine? = machineService.getById(id)

    @DeleteMapping("/{id}")
    fun removeMachine(@PathVariable id: Int) = machineService.removeById(id)

    @PostMapping
    fun updateMachine(@RequestBody machine: Machine): Int {
        machineService.addOrUpdate(machine)
        return machine.id
    }
}