package com.example.wilmacare.ui.feedPost;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wilmacare.MainActivity;
import com.example.wilmacare.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class FeedPostFragment extends Fragment {

    private FeedPostViewModel feedPostViewModel;
    private RecyclerView recyclerView;
    private Button buttonAddPost;
    public static final int ADD_POST_REQUEST = 1;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_feedpost, container, false);
        feedPostViewModel = new ViewModelProvider(this).get(FeedPostViewModel.class);


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

        buttonAddPost = root.findViewById(R.id.btnAddFeedPost);

        buttonAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Action button clicked", "");
                Intent intent = new Intent(getActivity(), AddNoteActivity.class);
                startActivityForResult(intent, ADD_POST_REQUEST);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_POST_REQUEST && resultCode == RESULT_OK) {
            String username = data.getStringExtra(AddNoteActivity.EXTRA_USERNAME);
            String description = data.getStringExtra(AddNoteActivity.EXTRA_DESCRIPTION);

            FeedPost feedPost = new FeedPost(username, description);
            feedPostViewModel.insert(feedPost);

        } else {
            //Toast.makeText(this,"Opslag ikke gemt", Toast.LENGTH_SHORT).show();
            Log.v("Opslag ikke gemt", "");
            //TODO: hvorfor virker toasten ikke?
        }
    }

}