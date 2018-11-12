package id.ac.unja.mauladi.footballappapi.mpv.model


import com.google.gson.annotations.SerializedName


data class ResponseLeague(

	@field:SerializedName("events")
	val events: List<EventsItem>? = null
)