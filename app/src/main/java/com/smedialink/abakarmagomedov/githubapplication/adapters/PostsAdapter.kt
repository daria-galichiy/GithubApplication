package com.smedialink.abakarmagomedov.githubapplication.adapters

import android.support.v7.widget.RecyclerView
import com.smedialink.abakarmagomedov.githubapplication.adapters.PostsAdapter.ReposHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.smedialink.abakarmagomedov.githubapplication.R
import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository
import com.smedialink.abakarmagomedov.githubapplication.databinding.ReposItemBinding

/**
 * Created by abakarmagomedov on 15/05/17.
 */
class PostsAdapter(
    private val repoList: List<Repository>,
    private val listener: RepoClickListener
) : RecyclerView.Adapter<ReposHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.repos_item, parent, false)
        return ReposHolder(view)
    }

    override fun onBindViewHolder(holder: ReposHolder, position: Int) {
        holder.bindView(repoList[position], listener)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    interface RepoClickListener {
        fun userClicked(watchers: Int?, forks: Int?, stars: Int?, info: String?)
    }

    class ReposHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ReposItemBinding.bind(itemView)
        private lateinit var listener: RepoClickListener

        fun bindView(repository: Repository, listener: RepoClickListener) {
            binding.reposTextview.text = repository.fullName
            this.listener = listener
            val watchers = repository.watchersCount
            val forks = repository.forksCount
            val stars = repository.stargazersCount
            val info =
                if (repository.description != null) repository.description.toString() else "Info is not visible"
            binding.repoField.setOnClickListener {
                listener.userClicked(
                    watchers,
                    forks,
                    stars,
                    info
                )
            }
        }
    }
}
