package com.project.bookreview.adapters;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.bookreview.R;
import com.project.bookreview.entities_jednostki.Review;

public class NoteAdapter_Pokazywanie_notatki {
    static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView text_Title, text_review, text_date_time;

        public NoteViewHolder(@NonNull View itemView) { // przypisanie wartosci do layoutu
            super(itemView);
            text_Title = itemView.findViewById(R.id.text_Title);
            text_review = itemView.findViewById(R.id.text_review);
            text_date_time = itemView.findViewById(R.id.text_date_time);
        }

//        public setReview(Review review) {
//            text_Title.setText(review.getTitle());
//        }
    }
}
