package com.example.wilmacare.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.wilmacare.MainActivity;
import com.example.wilmacare.R;
import com.google.android.material.tabs.TabLayout;

public class LoginTabFragment extends Fragment {

    EditText edtEmail;
    EditText edtPassWord;
    Button login;
    TextView textViewForgotPassword;
    float v=0;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        edtEmail = root.findViewById(R.id.edtEmail);
        edtPassWord = root.findViewById(R.id.edtPassword);
        textViewForgotPassword = root.findViewById(R.id.txtForgotPassword);
        login = root.findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("CLICKED", "login");
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        edtEmail.setTranslationX(300);
        edtPassWord.setTranslationY(300);
        textViewForgotPassword.setTranslationX(300);
        login.setTranslationY(300);

        edtEmail.setAlpha(v);
        edtPassWord.setAlpha(v);
        textViewForgotPassword.setAlpha(v);
        login.setAlpha(v);



        edtEmail.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        edtPassWord.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        textViewForgotPassword.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();


        return root;
    }
}
