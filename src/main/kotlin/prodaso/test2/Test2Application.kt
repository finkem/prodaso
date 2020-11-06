package prodaso.test2

import org.apache.naming.factory.BeanFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import prodaso.test2.model.Machine
import prodaso.test2.repository.MachineRepository

@SpringBootApplication
class Test2Application

fun main(args: Array<String>) {
	var configurableApplicationContext : ConfigurableApplicationContext =
			runApplication<Test2Application>(*args)
	var machineRepository : MachineRepository = configurableApplicationContext.getBean(MachineRepository::class.java)
	var testMachine : Machine = Machine(id = 0, name = "Station1", state = "STANDBY")
	machineRepository.save(testMachine)
}
