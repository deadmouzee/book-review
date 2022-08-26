package com.project.bookreview.activities_aktywnosci_ekrany;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.bookreview.Database.ReviewsDatabase;
import com.project.bookreview.R;
import com.project.bookreview.entities_jednostki.Review;

import java.util.List;


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
        getReview();
    }
    private void getReview(){
        @SuppressLint("StaticFieldLeak")
        class GetReviewsTask extends AsyncTask<Void, Void, List<Review>>{

            @Override
            protected List<Review> doInBackground(Void... voids) {
                return ReviewsDatabase
                        .getReviewsDatabase(getApplicationContext())
                        .reviewDao().getAllReviews();
            }

            @Override
            protected void onPostExecute(List<Review> reviews) {
                super.onPostExecute(reviews);
                Log.d("MY REVIEWS", reviews.toString());
            }
        }
        new GetReviewsTask().execute();
    }
}


