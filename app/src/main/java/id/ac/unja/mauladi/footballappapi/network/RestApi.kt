package id.ac.unja.mauladi.footballappapi.network

import id.ac.unja.mauladi.footballappapi.mpv.model.ResponseLeague
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {
       @GET("api/v1/json/1/eventspastleague.php")
       fun getLastMatch(@Query("id") leagueid: Int) : Call<ResponseLeague>
}
