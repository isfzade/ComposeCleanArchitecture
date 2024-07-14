package az.isfan.composechallenge.domain.models.remote

data class DeviceApiData(
    val id: String,
    val name: String,
    val data: HashMap<String, String>
) {
    fun dataToString(): String {
        if (data == null) return "-"
        return data.map { (key, value) ->
            "$key: $value"
        }.joinToString(", ")
    }
}