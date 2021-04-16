package com.example.wilmacare.ui.feedPost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wilmacare.R;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "com.example.wilmacare.ui.feedPost.EXTRA_USERNAME";
    public static final String EXTRA_DESCRIPTION = "com.example.wilmacare.ui.feedPost.EXTRA_DESCRIPTION";

    private EditText editTextUsername;
    private EditText editTextDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextUsername = findViewById(R.id.edt_NameOfPerson);
        editTextDescription = findViewById(R.id.edt_description);

        setTitle("Add post");
    }

    private void savePost() {
        String username = editTextUsername.getText().toString();
        String description = editTextDescription.getText().toString();

        if (username.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Skriv venligst noget i alle felter", Toast.LENGTH_SHORT);
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_USERNAME, username);
        data.putExtra(EXTRA_DESCRIPTION, description);

        setResult(RESULT_OK, data);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_post:
                savePost();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}