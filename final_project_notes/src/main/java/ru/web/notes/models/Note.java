package ru.web.notes.models;

// Модель заметки
public class Note {

    private int id;
    private String note = "Write your note";

    public Note() {}

    public Note(int id, String note) {
        this.id = id;
        this.note = note;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String text) {
        this.note = text;
    }

}
