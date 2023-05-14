package uz.it_school.booklibraryapp.model.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import uz.it_school.booklibraryapp.model.room.entities.BookEntity

@Dao
interface BookDao {
    @Query("SELECT * FROM books")
    fun getBooks(): LiveData<List<BookEntity>>
    @Query("SELECT * FROM books WHERE id = :id")
    fun getBook(id: Int): LiveData<BookEntity>
    @Query("SELECT * FROM books WHERE title like '%'||:title||'%' or author like '%'||:title||'%'")
    fun getBooksByTitle(title:String): LiveData<List<BookEntity>>

    @Query("SELECT * FROM books where bookMarks=1")
    fun getBooksByMarks(): LiveData<List<BookEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(bookList: List<BookEntity>)

    @Update
    fun update(book: BookEntity)
    @Query("DELETE FROM books")
    fun deleteAll()
    @Query("DELETE FROM books WHERE id = :id")
    fun delete(id: String)

    @Insert
    fun insert(book: BookEntity)


}