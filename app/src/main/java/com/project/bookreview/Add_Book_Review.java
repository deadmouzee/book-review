package com.project.bookreview;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Add_Book_Review extends AppCompatActivity {
    Button saveOpinion;
    EditText etTitle, etReview, etStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_review);
        
    }

}
