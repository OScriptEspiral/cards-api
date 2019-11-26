package model

data class Card(val _id: String? = null, val title: String, val deckId: String, val face: CardFace, val back: CardBack)

data class CardFace(val content: String)

data class CardBack(val content: String)