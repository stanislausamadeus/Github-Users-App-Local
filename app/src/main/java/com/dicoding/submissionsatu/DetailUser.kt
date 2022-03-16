package com.dicoding.submissionsatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val tvUsername: TextView = findViewById(R.id.detail_username)
        val tvFollower: TextView = findViewById(R.id.detail_follower)
        val tvFollowing: TextView = findViewById(R.id.detail_following)
        val tvRepositories: TextView = findViewById(R.id.detail_repositories)
        val imgAvatar: ImageView = findViewById(R.id.detail_avatar)
        val tvName: TextView = findViewById(R.id.detail_name)
        val tvCompany: TextView = findViewById(R.id.detail_company)
        val tvLocation: TextView = findViewById(R.id.detail_location)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        val avatarImage = user.dataAvatar
        val usernameText = user.dataUsername
        val nameText = user.dataName
        val companyText = user.dataCompany
        val locationText = user.dataLocation
        val followerText = getString(R.string.follower) + user.dataFollower
        val followingText = getString(R.string.following) + user.dataFollowing
        val repositoriesText = getString(R.string.repositories) + user.dataRepositories
        Glide.with(this)
             .load(avatarImage)
             .circleCrop()
             .into(imgAvatar)
        tvUsername.text = usernameText
        tvName.text = nameText
        tvCompany.text = companyText
        tvLocation.text = locationText
        tvFollower.text = followerText
        tvFollowing.text = followingText
        tvRepositories.text = repositoriesText
        Log.d("Detail Name", user.dataName)
    }

    companion object{
        const val EXTRA_USER ="extra_user"
    }
}