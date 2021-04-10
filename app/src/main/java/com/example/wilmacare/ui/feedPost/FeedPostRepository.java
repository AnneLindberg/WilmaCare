package com.example.wilmacare.ui.feedPost;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.wilmacare.DAO.WilmaCareDatabase;

import java.util.List;

public class FeedPostRepository {

    private FeedPostDao feedPostDAO;
    private LiveData<List<FeedPost>> allFeedPost;

    public FeedPostRepository(Application application) {
        WilmaCareDatabase database = WilmaCareDatabase.getInstance(application);
        feedPostDAO = database.feedPostDAO();
        allFeedPost = feedPostDAO.getAllFeedPost();
    }


    public void insert(FeedPost feedPost) {
        new InsertFeedPostAsync(feedPostDAO).execute(feedPost);
    }

    public void update(FeedPost feedPost) {
        new UpdateFeedPostAsync(feedPostDAO).execute(feedPost);
    }

    public void delete(FeedPost feedPost) {
        new DeleteFeedPostAsync(feedPostDAO).execute(feedPost);
    }

    public void deleteAllPost(FeedPost feedPost) {
        new DeleteAllFeedPostAsync(feedPostDAO).execute();
    }

    public LiveData<List<FeedPost>> getAllFeedPost() {
        return allFeedPost;
    }

    private static class InsertFeedPostAsync extends AsyncTask<FeedPost, Void, Void> {
        private FeedPostDao feedPostDAO;

        public InsertFeedPostAsync(FeedPostDao feedPostDAO) {
            this.feedPostDAO = feedPostDAO;
        }

        @Override
        protected Void doInBackground(FeedPost... feedPosts) {
            feedPostDAO.insert(feedPosts[0]);
            return null;
        }
    }

    private static class UpdateFeedPostAsync extends AsyncTask<FeedPost, Void, Void> {
        private FeedPostDao feedPostDAO;

        public UpdateFeedPostAsync(FeedPostDao feedPostDAO) {
            this.feedPostDAO = feedPostDAO;
        }

        @Override
        protected Void doInBackground(FeedPost... feedPosts) {
            feedPostDAO.update(feedPosts[0]);
            return null;
        }
    }

    private static class DeleteFeedPostAsync extends AsyncTask<FeedPost, Void, Void> {
        private FeedPostDao feedPostDAO;

        public DeleteFeedPostAsync(FeedPostDao feedPostDAO) {
            this.feedPostDAO = feedPostDAO;
        }

        @Override
        protected Void doInBackground(FeedPost... feedPosts) {
            feedPostDAO.delete(feedPosts[0]);
            return null;
        }
    }

    private static class DeleteAllFeedPostAsync extends AsyncTask<Void, Void, Void> {
        private FeedPostDao feedPostDAO;

        public DeleteAllFeedPostAsync(FeedPostDao feedPostDAO) {
            this.feedPostDAO = feedPostDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            feedPostDAO.deleteAllFeedPost();
            return null;
        }
    }


}
