package com.project.bookreview.activities_aktywnosci_ekrany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.bookreview.R;


public class MainActivity extends AppCompatActivity {
    FloatingActionButton addrvw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addrvw = (FloatingActionButton) findViewById(R.id.add_new_review_button);

        addrvw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Add_Book_Review.class);
                startActivity(i);
            }
        });
    }
}


