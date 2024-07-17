package br.com.examplevotingapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackages = ["br.com.examplevotingapp.repository"])
@SpringBootApplication()
class ExampleVotingAppApplication

fun main(args: Array<String>) {
    runApplication<ExampleVotingAppApplication>(*args)
}
