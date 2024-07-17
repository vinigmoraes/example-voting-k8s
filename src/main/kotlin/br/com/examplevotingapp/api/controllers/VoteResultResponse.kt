package br.com.examplevotingapp.api.controllers

import br.com.examplevotingapp.entities.Vote

data class VoteWinner(
    val winner: String,
    val percentageOfVotes: Double
)

data class VoteResultResponse(
    val votes: Int,
    val winner: VoteWinner,
) {

    companion object {
        fun create(votes: List<Vote>) = VoteResultResponse(
            votes = votes.sumOf { it.quantity },
            winner = getWinner(votes),
        )

        private fun getWinner(votes: List<Vote>): VoteWinner {
            val totalVotes = votes.sumOf { it.quantity }
            val orderedVotes = votes.sortedByDescending { it.quantity }

            if (orderedVotes.isEmpty()) {
                return VoteWinner(
                    winner = "No votes",
                    percentageOfVotes = 0.0
                )
            }

            val drawVotes = orderedVotes.map { it.quantity }.toSet()

            if (drawVotes.size != orderedVotes.size) {
                return VoteWinner(
                    winner = "Draw",
                    percentageOfVotes = 0.0
                )
            }

            return VoteWinner(
                winner = orderedVotes.first().name,
                percentageOfVotes = orderedVotes.first().quantity.toDouble() / totalVotes * 100
            )
        }
    }
}

