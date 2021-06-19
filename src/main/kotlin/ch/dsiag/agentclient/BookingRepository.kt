package ch.dsiag.agentclient

import org.springframework.data.repository.CrudRepository

interface BookingRepository: CrudRepository<Booking, String>
