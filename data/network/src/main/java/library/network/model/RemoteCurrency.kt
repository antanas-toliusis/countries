package library.network.model

import com.google.gson.annotations.SerializedName

data class RemoteCurrency(
    @SerializedName("code")
    val code: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)
