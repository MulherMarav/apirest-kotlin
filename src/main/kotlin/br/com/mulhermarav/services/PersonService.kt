package br.com.mulhermarav.services

import br.com.mulhermarav.models.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        val person = Person()

        person.id = counter.incrementAndGet()
        person.firstName = "Dyane"
        person.lastName = "Andrade"
        person.address = "São Paulo - Brasil"
        person.gender = "Female"

        return person
    }

    fun findAll(): List<Person> {
        logger.info("Finding all people!")

        val persons: MutableList<Person> = ArrayList()

        for (i in 0..7) {
            val person = mockPerson(i)

            persons.add(person)
        }

        return persons
    }

    fun create(person: Person) = person

    fun update(person: Person) = person

    fun delete(id: Long) {}

    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person Name $i"
        person.lastName = "Last Name $i"
        person.address = "Some Address in Brasil"
        person.gender = "Female"

        return person

    }
}