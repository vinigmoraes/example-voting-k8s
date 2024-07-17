package br.com.examplevotingapp.repository

import br.com.examplevotingapp.entities.Vote
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VoteRepository : CrudRepository<Vote, Int> {
    fun save(vote: Vote)

    fun findByName(name: String): Vote

    override fun findAll() : List<Vote>
}