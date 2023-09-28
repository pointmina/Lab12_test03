//텝화면 하나하나 프레그먼트로 처리

package com.example.lab12

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab12.databinding.ActivityTest02Binding
import com.google.android.material.tabs.TabLayout

class test02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest02Binding.inflate(layoutInflater)
        setContentView(binding.root)


        //초기에 뭐가 떠야하는지 정하는 것
        supportFragmentManager.beginTransaction().add(R.id.tabContent, OneFragment()).commit()

        //나머지는 유저 이벤트 걸기

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when(tab?.text){
                    "Tab1" -> transaction.replace(R.id.tabContent, OneFragment())
                    "Tab2" -> transaction.replace(R.id.tabContent, TwoFragment())
                    "Tab3" -> transaction.replace(R.id.tabContent, ThreeFragment())
                }

                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {


            }



        })


    }
}

