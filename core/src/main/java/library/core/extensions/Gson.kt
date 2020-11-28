package library.core.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

inline fun <reified T> fromJsonFile(fileName: String): T =
    T::class.java.classLoader?.getResource(fileName).let { url ->
        Gson().fromJson(BufferedReader(FileReader(File(url!!.path))), T::class.java)
    }

inline fun <reified T> Gson.fromJsonTypeToken(json: String): T = fromJson(json, object : TypeToken<T>() {}.type)
