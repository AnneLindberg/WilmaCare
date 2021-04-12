package com.example.wilmacare.ui.feedPost;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class FeedPostViewModel extends AndroidViewModel {

    private FeedPostRepository repository;
    private LiveData<List<FeedPost>> allPosts;
    private MutableLiveData<String> mText;


    public FeedPostViewModel(@NonNull Application application) {
        super(application);
        repository = new FeedPostRepository(application);
        allPosts = repository.getAllFeedPost();
        mText = new MutableLiveData<>();
        mText.setValue("heheh");
    }

    public void insert(FeedPost feedPost){
        repository.insert(feedPost);
    }


    public void update(FeedPost feedPost){
        repository.update(feedPost);
    }


    public void delete(FeedPost feedPost){
        repository.delete(feedPost);
    }

    public void deleteAllFeedPost(){
        repository.deleteAllPost();
    }

    public LiveData<List<FeedPost>> getAllPosts(){
        return allPosts;
    }

    public LiveData<String> getText() {
        return mText;
    }

}




