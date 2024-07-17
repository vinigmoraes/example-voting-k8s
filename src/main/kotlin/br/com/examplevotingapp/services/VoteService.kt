package br.com.examplevotingapp.services

import br.com.examplevotingapp.entities.Vote
import br.com.examplevotingapp.repository.VoteRepository
import org.springframework.stereotype.Service

@Service
class VoteService(
    private val repository: VoteRepository
) {

    fun vote(animalName: String) {
        val vote = repository.findByName(animalName)

        vote.addQuantity()

        repository.save(vote)
    }

    fun getVotesResult(): List<Vote> {
        return repository.findAll()
    }
}