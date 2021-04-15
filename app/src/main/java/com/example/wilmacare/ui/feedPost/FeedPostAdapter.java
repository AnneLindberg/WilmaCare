package com.example.wilmacare.ui.feedPost;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wilmacare.R;

import java.util.ArrayList;
import java.util.List;

public class FeedPostAdapter extends RecyclerView.Adapter<FeedPostAdapter.FeedPostHolder> {

    private List<FeedPost> feedPosts = new ArrayList<>();


    @NonNull
    @Override
    public FeedPostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View feedpostView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.feedpost_item, parent, false);
        return new FeedPostHolder(feedpostView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedPostHolder holder, int position) {
        FeedPost currentFeedPost = feedPosts.get(position);
        holder.textViewUserName.setText(currentFeedPost.getUserName());
        holder.textViewDescription.setText(currentFeedPost.getDescription());
    }

    @Override
    public int getItemCount() {
        return feedPosts.size();
    }

    public void setFeedPost(List<FeedPost> feedPosts){
        this.feedPosts = feedPosts;
        notifyDataSetChanged();
    }

    class FeedPostHolder extends RecyclerView.ViewHolder {
    private TextView textViewUserName;
    private TextView textViewDescription;
        public FeedPostHolder(@NonNull View itemView) {
            super(itemView);
            textViewUserName = itemView.findViewById(R.id.txtViewUserName);
            textViewDescription = itemView.findViewById(R.id.txtViewDescription);
        }
    }

}
