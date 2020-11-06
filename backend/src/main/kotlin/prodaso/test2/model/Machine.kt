package prodaso.test2.model

import javax.persistence.*

@Entity
data class Machine(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Int,
    @Column(nullable = false)
    var name : String,
    @Column(nullable = false)
    var state : String
)