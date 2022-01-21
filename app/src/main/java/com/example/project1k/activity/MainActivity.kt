package com.example.project1k.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import com.example.project1k.BuildConfig
import com.example.project1k.R
import com.example.project1k.adapter.CustomAdapter
import com.example.project1k.helper.VersionChecker
import com.example.project1k.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var members: ArrayList<Member>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        refreshAdapter(prepareMemberList())

        versionCode()


    }

    private fun initViews() {
        context = this
        recyclerView = main_recycler_view
        recyclerView.layoutManager = GridLayoutManager(context, 1)
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val customAdapter = CustomAdapter(context, members)
        recyclerView.adapter = customAdapter
    }

    private fun prepareMemberList(): ArrayList<Member> {
        members = ArrayList()
        for (i in 1..30) members.add(Member("Muhammadrizo$i", "Nurullaxo'jayev$i"))
        return members
    }

    private fun versionCode() {
        val versionChecker = VersionChecker()
        try {
            val mLatestVersionName = versionChecker.execute().get()
            Log.d(
                "mLatestVersionName",
                "onCreate: $mLatestVersionName && ${BuildConfig.VERSION_NAME}"
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}



