package com.example.notesproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotesAdapter notesAdapter;
    private List<Note> notesList;
    private NotesDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the database helper
        databaseHelper = new NotesDatabaseHelper(this);

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the notes list and adapter
        notesList = new ArrayList<>();
        notesAdapter = new NotesAdapter(notesList);
        recyclerView.setAdapter(notesAdapter);

        // Load notes from the database
        loadNotesFromDatabase();

        // Set up Floating Action Button for adding a new note
        FloatingActionButton fabAddNote = findViewById(R.id.fabAddNote);
        fabAddNote.setOnClickListener(view -> {
            // Start NoteCreationActivity to create a new note
            Intent intent = new Intent(MainActivity.this, NoteCreationActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Reload notes when returning to the activity (after creating a new note)
        loadNotesFromDatabase();
    }

    private void loadNotesFromDatabase() {
        // Clear the list first to avoid duplication
        notesList.clear();

        // Retrieve notes from the database
        List<Note> loadedNotes = databaseHelper.getAllNotes();

        // If notes are found, add them to the list and update the adapter
        if (loadedNotes != null && !loadedNotes.isEmpty()) {
            notesList.addAll(loadedNotes);
            notesAdapter.notifyDataSetChanged();
        } else {
            // Show a message if no notes are found
            Toast.makeText(this, "No notes found", Toast.LENGTH_SHORT).show();
        }
    }
}
