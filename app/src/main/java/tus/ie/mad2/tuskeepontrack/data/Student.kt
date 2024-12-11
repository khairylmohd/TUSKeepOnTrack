package tus.ie.mad2.tuskeepontrack.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey val email: String,
    val password: String
)
