package uz.it_school.booklibraryapp.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title: String,
    val author: String,
    val url: String,
    val image:Int,
    val description: String,
    var bookMarks:Boolean=false
):Serializable