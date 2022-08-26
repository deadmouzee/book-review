package com.project.bookreview.activities_aktywnosci_ekrany;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.bookreview.Database.ReviewsDatabase;
import com.project.bookreview.R;
import com.project.bookreview.entities_jednostki.Review;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Add_Book_Review extends AppCompatActivity {
    Button saveOpinion;
    EditText etTitle, etReview;
    TextView tvTime_date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_review);

        saveOpinion = (Button) findViewById(R.id.save_button);
        etTitle = (EditText) findViewById(R.id.add_book_name);
        etReview = (EditText) findViewById(R.id.add_book_review);
        tvTime_date = (TextView) findViewById(R.id.time_date_add);

        tvTime_date.setText(
                new SimpleDateFormat(" EEEE, dd MMMM yyyy HH:mm", Locale.getDefault())
                        .format(new Date())
        );


        saveOpinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveReview();
            }
        });
    }

    private void saveReview() {
        if(etTitle.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Tytuł książki nie może być pusty",Toast.LENGTH_SHORT).show();
            return;
        } else if(etReview.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Uzupełnij recenzje/opinie",Toast.LENGTH_SHORT).show();
            return;
        }

        final Review review = new Review();
        review.setTitle(etTitle.getText().toString());
        review.setReview(etReview.getText().toString());
        review.setDate_time(tvTime_date.getText().toString());

        @SuppressLint("StaticFieldLeak")
        class SaveReviewTask extends AsyncTask<Void,Void,Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                ReviewsDatabase.getReviewsDatabase(getApplicationContext()).reviewDao().insertReview(review);
                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        }
        new SaveReviewTask().execute();
    }
}
