package com.smedialink.abakarmagomedov.githubapplication.adapters

import android.support.v7.widget.RecyclerView
import com.smedialink.abakarmagomedov.githubapplication.adapters.UsersAdapter.UsersHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.smedialink.abakarmagomedov.githubapplication.R
import com.bumptech.glide.Glide
import com.smedialink.abakarmagomedov.githubapplication.data.entity.User
import com.smedialink.abakarmagomedov.githubapplication.databinding.UserItemBinding

/**
 * Created by abakarmagomedov on 15/05/17.
 */
class UsersAdapter(private val userList: List<User>, private val listener: UserClickListener) :
    RecyclerView.Adapter<UsersHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.user_item, parent, false)
        return UsersHolder(view)
    }

    override fun onBindViewHolder(holder: UsersHolder, position: Int) {
        holder.bindView(userList[position], listener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    interface UserClickListener {
        fun userClicked(login: String)
    }

    class UsersHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = UserItemBinding.bind(itemView)
        private lateinit var listener: UserClickListener
        private lateinit var login: String

        fun bindView(user: User, listener: UserClickListener) {
            Glide.with(binding.userAvatar.context)
                .load(user.avatarUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_mood_bad_black_24dp)
                .into(binding.userAvatar)
            binding.userData.text = user.login
            this.listener = listener
            login = user.login
            binding.userCard.setOnClickListener {
                listener.userClicked(login)
            }
        }
    }
}
