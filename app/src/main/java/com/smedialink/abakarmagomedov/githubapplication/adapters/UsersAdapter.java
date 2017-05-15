package com.smedialink.abakarmagomedov.githubapplication.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smedialink.abakarmagomedov.githubapplication.R;
import com.smedialink.abakarmagomedov.githubapplication.data.entity.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by abakarmagomedov on 15/05/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersHolder> {

    private List<User> userList;
    private UserClickListener listener;

    public UsersAdapter(List<User> userList, UserClickListener listener) {
        this.userList = userList;
        this.listener = listener;
    }


    @Override
    public UsersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_item, parent, false);
        return new UsersHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersHolder holder, int position) {
        holder.bindView(userList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public interface UserClickListener {
        void userClicked(String login);
    }


    static class UsersHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.user_avatar) ImageView avatar;
        @BindView(R.id.user_data) TextView description;
        private UserClickListener listener;
        private String login;

        @OnClick(R.id.user_card)
        void onCardClick(){
            listener.userClicked(login);
        }

        public UsersHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        void bindView(User user, UserClickListener listener) {
            Glide.with(avatar.getContext())
                    .load(user.getAvatarUrl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_mood_bad_black_24dp)
                    .into(avatar);
            description.setText(user.getLogin());
            this.listener = listener;
            login = user.getLogin();
        }
    }
}


















