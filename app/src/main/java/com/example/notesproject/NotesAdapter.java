package com.example.notesproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesproject.R;
import com.example.notesproject.Note; // Make sure Note class is in the right package

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private final List<Note> notesList;

    public NotesAdapter(List<Note> notesList) {
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout for each note
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        // Bind the note data to the view
        Note note = notesList.get(position);
        holder.titleTextView.setText(note.getTitle());  // Set note title
        holder.contentTextView.setText(note.getContent());  // Set note content (brief preview)
    }

    @Override
    public int getItemCount() {
        return notesList.size();  // Return the size of the notes list
    }

    // ViewHolder for each note item
    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView contentTextView;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find the views by their IDs from the item layout
            titleTextView = itemView.findViewById(R.id.textTitle);
            contentTextView = itemView.findViewById(R.id.textContent);
        }
    }
}
