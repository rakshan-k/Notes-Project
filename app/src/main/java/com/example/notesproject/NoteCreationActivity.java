package com.example.notesproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class NoteCreationActivity extends AppCompatActivity {

    private EditText etTitle, etContent;
    private Button btnSave;
    private NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_creation);

        // Initialize views
        etTitle = findViewById(R.id.etTitle);
        etContent = findViewById(R.id.etContent);
        btnSave = findViewById(R.id.btnSave);

        // Initialize repository
        noteRepository = new NoteRepository(getApplication());

        // Set OnClickListener for Save button
        btnSave.setOnClickListener(v -> saveNoteToDatabase());
    }

    private void saveNoteToDatabase() {
        // Get data from EditText views
        String title = etTitle.getText().toString().trim();
        String content = etContent.getText().toString().trim();

        // Default category (you can change this based on user input)
        String category = "General";

        // Check if title and content are not empty
        if (!title.isEmpty() && !content.isEmpty()) {
            // Create a new Note object with title, content, and category
            Note note = new Note(title, content, category);

            // Insert the note into the database via NoteRepository
            noteRepository.insert(note);

            // Finish the activity and return to the MainActivity
            finish();
        } else {
            // Optionally, show a Toast or AlertDialog for missing title/content
        }
    }
}
