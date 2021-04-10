package com.example.wilmacare.ui.feedPost;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "feedPost_table")
public class FeedPost {
    @PrimaryKey(autoGenerate = true)
    private int postId;
    private String userName;
    private String description;

    public FeedPost(String userName, String description) {
        this.userName = userName;
        this.description = description;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
