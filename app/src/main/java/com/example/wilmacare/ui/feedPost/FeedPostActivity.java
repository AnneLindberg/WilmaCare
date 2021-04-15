package com.example.wilmacare.ui.feedPost;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wilmacare.R;

import java.util.List;

public class FeedPostActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private FeedPostViewModel feedPostViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        //FeedPost Recyclerview
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final FeedPostAdapter adapter = new FeedPostAdapter();
        recyclerView.setAdapter(adapter);

        //FeedPost ViewModel
        feedPostViewModel = new ViewModelProvider(this).get(FeedPostViewModel.class);
        setSupportActionBar(toolbar);
        feedPostViewModel.getAllPosts().observe(this, new Observer<List<FeedPost>>() {
            @Override
            public void onChanged(List<FeedPost> feedPosts) {
                adapter.setFeedPost(feedPosts);
            }
        });
    }
}
