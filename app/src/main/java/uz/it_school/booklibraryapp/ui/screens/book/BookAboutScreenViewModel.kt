package uz.it_school.booklibraryapp.ui.screens.book

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.booklibraryapp.model.room.AppDatabase
import uz.it_school.booklibraryapp.model.room.entities.BookEntity

class BookAboutScreenViewModel : ViewModel() {
    var id=0
    private val appDatabase= AppDatabase.getAppDatabase()
    val getUiChange=MediatorLiveData<BookEntity>()
    private var bookEntity:BookEntity?=null
    fun update(){
        bookEntity!!.bookMarks=!bookEntity!!.bookMarks
        appDatabase.getBookDao().update(bookEntity!!)
    }
    fun init(book:BookEntity) {
            getUiChange.addSource(appDatabase.getBookDao().getBook(book.id)){
                bookEntity=it
                getUiChange.value=it
            }
        }

}