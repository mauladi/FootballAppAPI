package id.ac.unja.mauladi.footballappapi.mpv.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.ac.unja.mauladi.footballappapi.R
import id.ac.unja.mauladi.footballappapi.adapter.ListLeagueAdapter
import id.ac.unja.mauladi.footballappapi.mpv.model.EventsItem
import id.ac.unja.mauladi.footballappapi.mpv.presenter.MainPresenter
import id.ac.unja.mauladi.footballappapi.mpv.view.MainView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LastMatchFragment : Fragment(), MainView {


    var mainPresenter : MainPresenter? = null
    var liga: MutableList<EventsItem> = mutableListOf()
    var idLiga: Int  = 4335
    var listLeagueAdapter : ListLeagueAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_last_match, container, false)
        // Inflate the layout for this fragment
       val layoutliga : RecyclerView = v.findViewById(R.id.listfootball)
        layoutliga.layoutManager = LinearLayoutManager(activity)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainPresenter = MainPresenter(this)
        mainPresenter?.getLastMatch(idLiga)
        listLeagueAdapter = ListLeagueAdapter(liga)

    }

    override fun showloading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideloading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showmessage(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showlistteam(listteam: List<EventsItem>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
