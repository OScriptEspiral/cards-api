package configuration.server

import configuration.database.mongoConnection
import model.Card
import org.litote.kmongo.coroutine.CoroutineCollection

object RepositoryContext {
    val coroutineCollection: CoroutineCollection<Card> = mongoConnection()
}