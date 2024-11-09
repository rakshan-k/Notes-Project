package com.example.notesproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NoteCreationActivity extends AppCompatActivity {

    private EditText etTitle, etContent;
    private Button btnSave;
    private NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_creation);

        etTitle = findViewById(R.id.etTitle);
        etContent = findViewById(R.id.etContent);
        btnSave = findViewById(R.id.btnSave);

        noteRepository = new NoteRepository(getApplication());

        btnSave.setOnClickListener(v -> saveNoteToDatabase());
    }

    private void saveNoteToDatabase() {
        String title = etTitle.getText().toString().trim();
        String content = etContent.getText().toString().trim();
        String category = "General"; // Default category

        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note(title, content, category);
            boolean isInserted = noteRepository.insert(note); // Check if insertion was successful
            if (isInserted) {
                Toast.makeText(this, "Note saved successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed to save note", Toast.LENGTH_SHORT).show();
            }
            finish(); // Return to main activity
        } else {
            Toast.makeText(this, "Title and content cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }
}
