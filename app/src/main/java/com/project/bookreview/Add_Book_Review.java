package com.project.bookreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.bookreview.Database.DBHelper;

public class Add_Book_Review extends AppCompatActivity {
    DBHelper db;
    Button saveOpinion;
    EditText etTitle, etReview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_review);
        db = new DBHelper(this);
        saveOpinion = (Button) findViewById(R.id.save_button);
        etTitle = (EditText) findViewById(R.id.add_book_name);
        etReview = (EditText) findViewById(R.id.add_book_review);


        saveOpinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isItDone;
                isItDone = db.wstawDane(etTitle.getText().toString(),etReview.getText().toString());
                if (isItDone){
                    Toast.makeText(Add_Book_Review.this,"Udało się!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Add_Book_Review.this,"nie udało się...",Toast.LENGTH_LONG).show();
                }
                Intent b = new Intent(Add_Book_Review.this,MainActivity.class);
                startActivity(b);
            }
        });

    }
}
