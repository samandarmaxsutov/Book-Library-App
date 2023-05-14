package uz.it_school.booklibraryapp.ui.screens.bookMarks
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.booklibraryapp.model.room.AppDatabase
import uz.it_school.booklibraryapp.model.room.entities.BookEntity

class BookMarksViewModel : ViewModel() {
    private val appDatabase= AppDatabase.getAppDatabase()
    val countriesLiveData= MediatorLiveData<List<BookEntity>>()
    val openCountryScreenLiveData= MutableLiveData<BookEntity>()
    fun open(country: BookEntity) {
        openCountryScreenLiveData.value=country
    }


    init {
        countriesLiveData.addSource(appDatabase.getBookDao().getBooksByMarks()){
            countriesLiveData.value=it
        }

    }
}