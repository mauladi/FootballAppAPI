package id.ac.unja.mauladi.footballappapi.mpv.view

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import id.ac.unja.mauladi.footballappapi.R
import id.ac.unja.mauladi.footballappapi.mpv.view.fragment.LastMatchFragment
import id.ac.unja.mauladi.footballappapi.mpv.view.fragment.NextMatchFragment
import kotlinx.android.synthetic.main.acivity_football.*

class FootballActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football)

        tablayout.addTab(tablayout.newTab().setText(getString(R.string.lastmatch)))
        tablayout.addTab(tablayout.newTab().setText(getString(R.string.nextmatch)))

        val adapter = CustomAdapter(supportFragmentManager)
        pager.adapter = adapter

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
               pager.currentItem = p0!!.position
            }

        })



    }

    class CustomAdapter(supportFragmentManager: FragmentManager?) : FragmentStatePagerAdapter(supportFragmentManager) {
        private val fragmenlist = listOf<Fragment>(LastMatchFragment(),NextMatchFragment())
        override fun getItem(p0: Int) = fragmenlist[p0]

        override fun getCount(): Int = fragmenlist.size

    }

}
