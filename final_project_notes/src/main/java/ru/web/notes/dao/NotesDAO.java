package ru.web.notes.dao;

import org.springframework.stereotype.Component;
import ru.web.notes.models.Note;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotesDAO {
    private static int NOTES_COUNT;
    private List<Note> notes;

    public NotesDAO() {
        notes = new ArrayList<Note>();
    }

    public List<Note> index() { // Метод, возвращающий все заметки
        return notes;
    }

    public Note show(int id) { // Метод возвращает заметку по id или null
        return notes.stream().filter(n -> n.getId() == id).findAny().orElse(null);
    }

    public void save(Note webNote) {
        webNote.setId(++NOTES_COUNT);
        notes.add(webNote);
    }

    public void update(int id, Note updatedNote) {
        Note toUpdateNote = show(id);
        toUpdateNote.setNote(updatedNote.getNote());
    }

    public void delete(int id) { // Метод удаления
        notes.removeIf(n -> n.getId() == id);
    }

}
