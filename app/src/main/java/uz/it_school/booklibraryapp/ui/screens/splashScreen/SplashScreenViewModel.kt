package uz.it_school.booklibraryapp.ui.screens.splashScreen


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.it_school.booklibraryapp.model.BooksList
import uz.it_school.booklibraryapp.model.room.AppDatabase
import uz.it_school.booklibraryapp.model.shared.LocalStorage


class SplashScreenViewModel : ViewModel() {

    private val localStorage= LocalStorage.getLocalStorage()
    private val appDatabase= AppDatabase.getAppDatabase()
    private val booksList=BooksList()
    val openMainScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            if (!localStorage.first){
                localStorage.first=true
                appDatabase.getBookDao().insertAll(booksList.list)
            }
            delay(1500)

                openMainScreenLiveData.value=Unit

        }
    }
}

