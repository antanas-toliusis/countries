package library.core.extensions

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

inline fun <reified T> fromJsonFile(fileName: String): T =
    T::class.java.classLoader?.getResource(fileName).let { url ->
        Gson().fromJson(BufferedReader(FileReader(File(url!!.path))), T::class.java)
    }
