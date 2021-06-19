package ch.dsiag.agentclient

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.annotation.PostConstruct

@RestController("/api/v1/")
class BookingController(val bookingRepository: BookingRepository) {

    val logger = LoggerFactory.getLogger(this.javaClass)

    @PostConstruct
    fun init() {
        logger.info("Init booking")
        bookingRepository.save(Booking(UUID.randomUUID().toString(), "Matthias Brun"))
        bookingRepository.save(Booking(UUID.randomUUID().toString(), "Romana Rimar"))
    }

    @GetMapping("bookings")
    fun getBookings(): List<Booking> {
        return bookingRepository.findAll().toList()
    }

}
