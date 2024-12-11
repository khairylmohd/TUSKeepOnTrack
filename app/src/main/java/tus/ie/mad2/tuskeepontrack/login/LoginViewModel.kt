package tus.ie.mad2.tuskeepontrack.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tus.ie.mad2.tuskeepontrack.data.AppDatabase
import tus.ie.mad2.tuskeepontrack.data.Student
import tus.ie.mad2.tuskeepontrack.data.StudentDao

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val studentDao: StudentDao

    init {
        val database = AppDatabase.getDatabase(application)
        studentDao = database.studentDao()
    }

    suspend fun validateLogin(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            studentDao.getStudent(email, password) != null
        }
    }
}