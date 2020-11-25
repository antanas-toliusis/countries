package library.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DBTodo(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
)
