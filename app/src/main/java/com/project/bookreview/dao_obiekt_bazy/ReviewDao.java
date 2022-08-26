package com.project.bookreview.dao_obiekt_bazy;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.project.bookreview.entities_jednostki.Review;

import java.util.List;

@SuppressWarnings("ALL")
@Dao
public interface ReviewDao {

    @Query("SELECT * FROM reviews ORDER BY id DESC") //zapytanie do bazy danych
    List<Review> getAllReviews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReview(Review review);

    @Delete
    void deleteReview(Review review);
}
