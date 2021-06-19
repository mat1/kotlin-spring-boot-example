package ch.dsiag.agentclient

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.annotation.PostConstruct

@RestController("/api/v1/")
class BookingController(val bookingRepository: BookingRepository) {

    val logger = LoggerFactory.getLogger(this.javaClass)

    @PostConstruct
    fun init() {
        logger.info("Init booking")
        bookingRepository.save(Booking(uuid(), "Matthias Brun"))
        bookingRepository.save(Booking(uuid(), "Romana Rimar"))
    }

    @GetMapping("bookings")
    fun getBookings(): List<Booking> {
        return bookingRepository.findAll().toList()
    }

    @PostMapping("bookings")
    fun createBooking(@RequestBody createBooking: CreateBooking): Booking {
        logger.info("Create booking $createBooking")
        return bookingRepository.save(Booking(uuid(), createBooking.name))
    }

    private fun uuid() = UUID.randomUUID().toString()

    data class CreateBooking(val name: String)

}
