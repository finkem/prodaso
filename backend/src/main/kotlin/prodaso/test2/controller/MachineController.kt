package prodaso.test2.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
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

    @PutMapping("/{id}")
    fun updateMachine(@RequestBody machine: Machine): ResponseEntity<Machine> {
        val machineUpdated = machineDataProvider.addOrUpdate(machine)
        return ResponseEntity(machineUpdated, HttpStatus.OK)
    }

    @PostMapping
    fun addMachine(@RequestBody machine: Machine): ResponseEntity<Void> {
        val machineAdded = machineDataProvider.addOrUpdate(machine)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(machineAdded.id)
                .toUri()
        return ResponseEntity.created(uri).build();
    }
}