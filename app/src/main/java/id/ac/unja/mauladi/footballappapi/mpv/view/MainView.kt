package id.ac.unja.mauladi.footballappapi.mpv.view

import id.ac.unja.mauladi.footballappapi.mpv.model.EventsItem

interface MainView {
        fun showloading()
        fun hideloading()
        fun showmessage(message : String?)
        fun showlistteam(listteam : List<EventsItem>?)
}