package com.smedialink.abakarmagomedov.githubapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smedialink.abakarmagomedov.githubapplication.R;
import com.smedialink.abakarmagomedov.githubapplication.data.entity.Repository;
import com.smedialink.abakarmagomedov.githubapplication.data.entity.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ReposHolder> {

    private List<Repository> repoList;
    private RepoClickListener listener;

    public PostsAdapter(List<Repository> repoList, RepoClickListener listener) {
        this.repoList = repoList;
        this.listener = listener;
    }


    @Override
    public ReposHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.repos_item, parent, false);
        return new ReposHolder(view);
    }

    @Override
    public void onBindViewHolder(ReposHolder holder, int position) {
        holder.bindView(repoList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public interface RepoClickListener {
        void userClicked(Integer watchers, Integer forks, Integer stars, String info);
    }


    static class ReposHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repos_textview) TextView description;
        private RepoClickListener listener;
        private Integer watchers, forks, stars;
        private String info;

        @OnClick(R.id.repo_field)
        void onCardClick(){
            listener.userClicked(watchers, forks, stars, info);
        }

        public ReposHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        void bindView(Repository repository, RepoClickListener listener) {
            description.setText(repository.getFullName());
            this.listener = listener;
            watchers = repository.getWatchersCount();
            forks = repository.getForksCount();
            stars = repository.getStargazersCount();
            if(repository.getDescription() != null)  info = repository.getDescription().toString();
            else info = "Info is not visible";
        }
    }


}
