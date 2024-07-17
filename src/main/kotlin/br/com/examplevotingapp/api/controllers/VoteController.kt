package br.com.examplevotingapp.api.controllers

import br.com.examplevotingapp.services.VoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/votes")
class VoteController(
    private val service: VoteService
) {
    @GetMapping
    fun getVotesResult(): ResponseEntity<VoteResultResponse> {
        val votes = service.getVotesResult()

        return ResponseEntity(VoteResultResponse.create(votes), HttpStatus.OK)
    }

    @PostMapping
    fun vote(@RequestBody vote: VoteRequest): ResponseEntity<HttpStatus> {
        service.vote(vote.animalName)

        return ResponseEntity.ok().build()
    }

    @GetMapping(value  = ["/reset"])
    fun reset(): ResponseEntity<HttpStatus> {
        service.reset()

        return ResponseEntity.ok().build()
    }
}