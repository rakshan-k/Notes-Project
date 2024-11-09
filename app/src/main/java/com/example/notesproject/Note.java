// Note.java
package com.example.notesproject;

public class Note {
    private String title;
    private String content;

    // Add constructor, getters, and setters
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
