package prodaso.test2.model

import javax.persistence.*

@Entity
data class Machine(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long,
    @Column(nullable = false)
    var name : String,
    @Column(nullable = false)
    var state : String
)