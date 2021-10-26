package com.syukron.githubusersubmission

import android.content.Context
import android.content.res.TypedArray

object ValueUser {
    private lateinit var listOfUsername: Array<String>
    private lateinit var listOfName: Array<String>
    private lateinit var listOfLocation: Array<String>
    private lateinit var listOfCompany: Array<String>
    private lateinit var listOfRepository: Array<String>
    private lateinit var listOfFollower: Array<String>
    private lateinit var listOfFollowing: Array<String>
    private lateinit var listOFAvatar: TypedArray

    private fun prepareData(context: Context) {
        listOfUsername = context.resources.getStringArray(R.array.data_username)
        listOfName = context.resources.getStringArray(R.array.data_name)
        listOfLocation = context.resources.getStringArray(R.array.data_location)
        listOfCompany = context.resources.getStringArray(R.array.data_company)
        listOfRepository = context.resources.getStringArray(R.array.data_repository)
        listOfFollower = context.resources.getStringArray(R.array.data_followers)
        listOfFollowing = context.resources.getStringArray(R.array.data_following)
        listOFAvatar = context.resources.obtainTypedArray(R.array.data_avatar)
    }

    fun getAllUsers(context: Context): ArrayList<User> {
        val listOfUsers: ArrayList<User> = ArrayList()
        prepareData(context)

        for (position in listOfUsername.indices) {
            val user = User(
                username = listOfUsername[position],
                name = listOfName[position],
                location = listOfLocation[position],
                company = listOfCompany[position],
                repository = listOfRepository[position],
                followers = listOfFollower[position],
                following = listOfFollowing[position],
                avatar = listOFAvatar.getResourceId(position, 1)
            )
            listOfUsers.add(user)
        }

        return listOfUsers
    }
}