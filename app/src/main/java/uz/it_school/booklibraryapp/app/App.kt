package uz.it_school.booklibraryapp.app

import android.app.Application
import uz.it_school.booklibraryapp.model.room.AppDatabase
import uz.it_school.booklibraryapp.model.shared.LocalStorage

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        LocalStorage.init(this)
        AppDatabase.init(this)
    }
}