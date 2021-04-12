package com.example.wilmacare.ui.resident;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wilmacare.R;

public class ResidentFragment extends Fragment {

    private ResidentViewModel residentViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        residentViewModel =
                new ViewModelProvider(this).get(ResidentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_resident, container, false);

        return root;
    }
}