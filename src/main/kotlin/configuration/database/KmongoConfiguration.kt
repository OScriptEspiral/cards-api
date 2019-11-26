package configuration.database

import model.Card
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun mongoConnection() = KMongo.createClient("mongodb://localhost:27017")
    .coroutine
    .getDatabase("cards-api")
    .getCollection<Card>("cards")