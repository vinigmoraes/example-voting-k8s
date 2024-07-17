package br.com.examplevotingapp.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "votes")
class Vote(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,
    val name: String = "",
    var quantity: Int = 0
) {

    fun addQuantity() { quantity += 1 }
}