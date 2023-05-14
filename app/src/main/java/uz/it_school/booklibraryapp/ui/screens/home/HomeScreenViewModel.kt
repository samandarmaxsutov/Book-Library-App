package uz.it_school.booklibraryapp.ui.screens.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.booklibraryapp.model.room.AppDatabase
import uz.it_school.booklibraryapp.model.room.entities.BookEntity

class HomeScreenViewModel : ViewModel() {
    private val appDatabase= AppDatabase.getAppDatabase()
    val countriesLiveData= MediatorLiveData<List<BookEntity>>()
    val openBookAboutScreenLiveData=MutableLiveData<BookEntity>()
     fun open(country: BookEntity) {
        openBookAboutScreenLiveData.value=country
    }


    init {
        countriesLiveData.addSource(appDatabase.getBookDao().getBooks()){
            countriesLiveData.value=it
        }

    }

    fun search(words:String){
        if (words.isNotEmpty()) {
            countriesLiveData.addSource(appDatabase.getBookDao().getBooksByTitle(words)) {
                countriesLiveData.value = it
            }
        }else{
            countriesLiveData.addSource(appDatabase.getBookDao().getBooks()){
                countriesLiveData.value=it
            }
        }
    }
}