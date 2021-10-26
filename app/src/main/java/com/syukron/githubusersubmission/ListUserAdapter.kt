package com.syukron.githubusersubmission

import android.content.Intent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.syukron.githubusersubmission.UserDetailActivity.Companion.EXTRA_USER
import com.syukron.githubusersubmission.databinding.ItemRowUserBinding

class ListUserAdapter: RecyclerView.Adapter<ListUserAdapter.UserViewHolder>() {

    private val userList = ArrayList<User>()

    fun setAllData(data: List<User>) {
        userList.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    inner class UserViewHolder(private val view: ItemRowUserBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(user: User) {

            view.apply {
                tvUsername.text = user.username
                tvName.text = user.name
                tvCompany.text = user.company
            }

            Glide.with(itemView.context)
                .load(user.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(view.imgItemPhoto)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, UserDetailActivity::class.java)
                intent.putExtra(EXTRA_USER, user)
                itemView.context.startActivity(intent)
            }
        }
    }
}