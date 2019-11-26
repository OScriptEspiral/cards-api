package repository

import arrow.data.Reader
import arrow.data.ReaderApi.ask
import arrow.data.map
import com.mongodb.client.model.Filters
import configuration.server.RepositoryContext
import kotlinx.coroutines.runBlocking
import model.Card

fun save(card: Card): Reader<RepositoryContext, Card> =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            card.also {
                ctx.coroutineCollection.insertOne(card)
            }
        }
    }

fun getById(id: String) =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            ctx.coroutineCollection.findOneById(id)
        }
    }

fun getByDeck(deckId: String) =
    ask<RepositoryContext>().map { ctx ->
        ctx.coroutineCollection.find(Filters.eq("deckId", deckId))
    }

fun delete(id: String) =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            ctx.coroutineCollection.deleteOneById(id)
        }
    }

fun replace(id: String, card: Card) =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            ctx.coroutineCollection.replaceOneById(id, card)
        }
    }
