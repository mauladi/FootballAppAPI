package id.ac.unja.mauladi.footballappapi.mpv.presenter

import id.ac.unja.mauladi.footballappapi.mpv.model.ResponseLeague
import id.ac.unja.mauladi.footballappapi.mpv.view.MainView
import id.ac.unja.mauladi.footballappapi.network.InitRetrofit
import id.ac.unja.mauladi.footballappapi.network.RestApi
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(private val view : MainView) {
    fun getLastMatch(idLiga : Int){
        view.showloading()
        val serviceListLiga : RestApi = InitRetrofit.getInstance()
        serviceListLiga.getLastMatch(idLiga).enqueue(object : Callback<ResponseLeague> {
            override fun onResponse(call: Call<ResponseLeague>, response: Response<ResponseLeague>) {
                view.hideloading()
                async(UI) {
                    val datalist = bg {
                        response?.body()?.events
                    }
                    view.showlistteam(datalist.await())
                }
            }

            override fun onFailure(call: Call<ResponseLeague>, t: Throwable) {
                view.hideloading()
                view.showmessage(t?.message)
            }



        })
    }
}