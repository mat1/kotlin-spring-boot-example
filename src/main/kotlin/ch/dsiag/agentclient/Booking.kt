package ch.dsiag.agentclient

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Booking(@Id val id: String,
                   val name: String)
