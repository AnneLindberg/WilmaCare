package com.example.wilmacare.ui.feedPost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wilmacare.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class FeedPostFragment extends Fragment {

    private FeedPostViewModel feedPostViewModel;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_feedpost, container, false);
        feedPostViewModel = new ViewModelProvider(this).get(FeedPostViewModel.class);

        floatingActionButton = root.findViewById(R.id.fabAddFeedPost);
        View view = inflater.inflate(R.layout.fragment_feedpost, container, false);


        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setHasFixedSize(true);



        final FeedPostAdapter adapter = new FeedPostAdapter();
        recyclerView.setAdapter(adapter);

        //FeedPost ViewModel
        feedPostViewModel = new ViewModelProvider(this).get(FeedPostViewModel.class);

        feedPostViewModel.getAllPosts().observe(getViewLifecycleOwner(), new Observer<List<FeedPost>>() {
            @Override
            public void onChanged(List<FeedPost> feedPosts) {
                adapter.setFeedPost(feedPosts);
            }
        });

        return view;


    }
}