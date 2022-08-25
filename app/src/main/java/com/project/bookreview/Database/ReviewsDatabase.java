package com.project.bookreview.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.project.bookreview.dao_obiekt_bazy.ReviewDao;
import com.project.bookreview.entities_jednostki.Review;

@Database(entities = Review.class, version = 1, exportSchema = false)
public abstract class ReviewsDatabase extends RoomDatabase {
    private static ReviewsDatabase reviewsDatabase;

    public static synchronized ReviewsDatabase getReviewsDatabase(Context context) {
        if (reviewsDatabase == null) {
            reviewsDatabase = Room.databaseBuilder(
                    context,
                    ReviewsDatabase.class,
                    "reviews_db"
            ).build();
        }
        return reviewsDatabase;
    }

    public abstract ReviewDao reviewDao();

}
