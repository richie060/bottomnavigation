package com.example.bottom_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val home = Home_fragment()
        val map = Map_fragment()
        val account = Account_fragment()
        val progress = Progress_fragment()

        setCurrentFragment(home)

        bottomnavbar.setOnItemReselectedListener {
            when(it.itemId){
                R.id.mihome -> setCurrentFragment(home)
                R.id.mimap -> setCurrentFragment(map)
                R.id.miaccount -> setCurrentFragment(account)
                R.id.miprogress-> setCurrentFragment(progress)
            }
            true


        }







    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frlayout, fragment)
            commit()
        }

}