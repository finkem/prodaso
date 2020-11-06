package prodaso.test2.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class MachineDataProviderTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val machineDataProvider: MachineDataProvider) {

    @Test
    fun `NameOfTestCase`() {

    }
}