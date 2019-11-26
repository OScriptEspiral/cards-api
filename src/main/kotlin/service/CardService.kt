package service

import arrow.core.fix
import configuration.server.RepositoryContext
import exceptions.EntityNotFoundException
import io.reactivex.Flowable
import model.Card

fun save(card: Card) = repository.save(card).run(RepositoryContext).fix().extract()

fun getById(id: String) = repository.getById(id).run(RepositoryContext).fix().extract() ?: throw EntityNotFoundException()

fun getByDeck(deckId: String) =
    Flowable.fromPublisher(repository.getByDeck(deckId).run(RepositoryContext).fix().extract().publisher)

fun delete(id: String) = repository.delete(id).run(RepositoryContext)

fun replace(id: String, card: Card) = repository.replace(id, card).run(RepositoryContext).fix().extract()
