package com.example.pol1.Acitivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pol1.Noti
import com.example.pol1.NotiRVAdapter
import com.example.pol1.R
import com.example.pol1.databinding.ActivityNotiBinding

class NotiActivity : AppCompatActivity(){
    private lateinit var viewBinding: ActivityNotiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotiBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val notiList: ArrayList<Noti> = arrayListOf()

        notiList.apply {
            add(Noti(R.drawable.img_pol, "알림1", "1m ago"))
            add(Noti(R.drawable.img_pol, "알림2", "2m ago"))
            add(Noti(R.drawable.img_pol, "알림3", "3m ago"))
        }

        val notiRVAdapter = NotiRVAdapter(notiList)

        viewBinding.RVNOTI.adapter = notiRVAdapter
        viewBinding.RVNOTI.layoutManager = LinearLayoutManager(this)

    }
}