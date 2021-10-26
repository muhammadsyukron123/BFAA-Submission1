package com.syukron.githubusersubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.syukron.githubusersubmission.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val userAdapter = ListUserAdapter()
        userAdapter.setAllData(ValueUser.getAllUsers(this))

        mainBinding.rvUsers.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = userAdapter
        }
    }
}