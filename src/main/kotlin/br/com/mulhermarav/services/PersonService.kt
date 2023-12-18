package br.com.mulhermarav.services

import br.com.mulhermarav.exceptions.ResourceNotFoundException
import br.com.mulhermarav.models.Person
import br.com.mulhermarav.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)


    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this Id!") }
    }

    fun findAll(): List<Person> {
        logger.info("Finding all people!")

        return repository.findAll()
    }

    fun create(person: Person): Person {
        logger.info("Creating one person with name ${person.firstName}!")

        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating one person with id ${person.id}!")

        val entity = findById(person.id)

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return repository.save(person)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id ${id}!")

        val entity = findById(id)
        repository.delete(entity)
    }

}