package com.syukron.githubusersubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.syukron.githubusersubmission.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var detailBinding: ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER)

        Glide.with(this)
            .load(user?.avatar)
            .apply(RequestOptions().circleCrop())
            .into(detailBinding.detailAvatar)

        detailBinding.apply {
            detailUsername.text = user?.username
            detailRepository.text = user?.repository
            detailFollowers.text = user?.followers
            detailFollowing.text = user?.following
            detailName.text = user?.name
            detailCompany.text = user?.company
            detailLocation.text = user?.location
        }

        supportActionBar?.apply {
//            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            setDisplayHomeAsUpEnabled(true)
            title = user?.username
            elevation = 0f
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}