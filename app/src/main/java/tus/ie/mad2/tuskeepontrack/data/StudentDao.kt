package tus.ie.mad2.tuskeepontrack.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudents(students: List<Student>)

    @Query("SELECT * FROM students WHERE email = :email AND password = :password")
    suspend fun getStudent(email: String, password: String): Student?
}