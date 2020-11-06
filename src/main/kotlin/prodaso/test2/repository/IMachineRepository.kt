package prodaso.test2.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import prodaso.test2.model.Machine

@Repository
interface IMachineRepository : CrudRepository<Machine, Int> {}