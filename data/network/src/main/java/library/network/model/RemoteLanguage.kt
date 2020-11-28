package library.network.model

import com.google.gson.annotations.SerializedName

data class RemoteLanguage(
    @SerializedName("iso639_1")
    val iso6391: String?,
    @SerializedName("iso639_2")
    val iso6392: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("nativeName")
    val nativeName: String?
)
