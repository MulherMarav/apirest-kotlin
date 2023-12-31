package br.com.mulhermarav.repositories

import br.com.mulhermarav.models.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<Person, Long?> {
}