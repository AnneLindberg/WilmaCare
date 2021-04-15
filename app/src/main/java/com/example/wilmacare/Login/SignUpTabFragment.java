package com.example.wilmacare.Login;

import android.content.Intent;
import android.os.Bundle;
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


public class SignUpTabFragment extends Fragment {

    EditText edtUserName;
    EditText edtName;
    EditText edtEmail;
    EditText edtPhone;
    EditText edtPassWord;
    Button signIn;

    float v=0;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        edtUserName = root.findViewById(R.id.edtUserName);
        edtName = root.findViewById(R.id.edtSignFullName);
        edtEmail = root.findViewById(R.id.edtSignUpEmail);
        edtPhone = root.findViewById(R.id.edtSignUpPhone);
        edtPassWord = root.findViewById(R.id.edtSignUpPassword);
        signIn = root.findViewById(R.id.btnSignUp);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        edtUserName.setTranslationX(300);
        edtName.setTranslationY(300);
        edtEmail.setTranslationX(300);
        edtPhone.setTranslationY(300);
        edtPassWord.setTranslationX(300);
        signIn.setTranslationY(300);

        edtUserName.setAlpha(v);
        edtName.setAlpha(v);
        edtEmail.setAlpha(v);
        edtPhone.setAlpha(v);
        edtPassWord.setAlpha(v);
        signIn.setAlpha(v);



        edtUserName.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        edtName.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        edtEmail.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        edtPhone.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();
        edtPassWord.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        signIn.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();


        return root;
    }
}
