package uz.it_school.booklibraryapp.model

import uz.it_school.booklibraryapp.R
import uz.it_school.booklibraryapp.model.room.entities.BookEntity

class BooksList {
    val list: List<BookEntity> = arrayListOf<BookEntity>(
        BookEntity(
            title = " In Search of Lost Time ",
            author = " Marcel Proust",
            description = "Swann's Way, the first part of A la recherche de temps perdu, Marcel Proust's seven-part cycle, was published in 1913. In it, Proust introduces the themes that run through the entire work. The narr...",
            image = R.drawable.book1,
            url = "https://thegreatestbooks.org/items/225"),
        BookEntity(
            title = " Ulysses ",
            author = "James Joyce",
            description = "Ulysses chronicles the passage of Leopold Bloom through Dublin during an ordinary day, June 16, 1904. The title parallels and alludes to Odysseus (Latinised into Ulysses), the hero of Homer's Odyss...",
            image = R.drawable.book2,
            url = "https://thegreatestbooks.org/items/122"),
        BookEntity(
            title = "Don Quixote",
            author = " Miguel de Cervantes",
            description = "Alonso Quixano, a retired country gentleman in his fifties, lives in an unnamed section of La Mancha with his niece and a housekeeper. He has become obsessed with books of chivalry, and believes th...",
            image = R.drawable.book3,
            url = "https://thegreatestbooks.org/items/190"),
        BookEntity(
            title = "One Hundred Years of Solitude ",
            author = "  Gabriel Garcia Marquez",
            description = "One of the 20th century's enduring works, One Hundred Years of Solitude is a widely beloved and acclaimed novel known throughout the world, and the ultimate achievement in a Nobel Prize–winning car...",
            image = R.drawable.book4,
            url = "https://thegreatestbooks.org/items/266"),
        BookEntity(
            title = " The Great Gatsby ",
            author = "F. Scott Fitzgerald",
            description = "Alonso Quixano, a retired country gentleman in his fifties, lives in an unnamed section of La Mancha with his niece and a housekeeper. He has become obsessed with books of chivalry, and believes th...",
            image = R.drawable.book5,
            url = "https://thegreatestbooks.org/items/38"),)

}