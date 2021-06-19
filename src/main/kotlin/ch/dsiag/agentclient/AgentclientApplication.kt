package ch.dsiag.agentclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AgentclientApplication

fun main(args: Array<String>) {
	runApplication<AgentclientApplication>(*args)
}
