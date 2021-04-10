package com.example.wilmacare.ui.feedPost;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FeedPostDao {
    @Insert
    void insert(FeedPost feedPost);

    @Update
    void update(FeedPost feedPost);

    @Delete
    void delete(FeedPost feedPost);

    @Query("DELETE FROM feedPost_table")
    void deleteAllFeedPost();

    @Query("SELECT * FROM feedPost_table ORDER BY postId DESC")
    LiveData<List<FeedPost>> getAllFeedPost();
}
