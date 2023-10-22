package ru.web.notes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.web.notes.dao.NotesDAO;
import ru.web.notes.models.Note;

@Controller
@RequestMapping("/notes")
public class NotesController {

    private final NotesDAO myNotesDAO;

    @Autowired
    public NotesController(NotesDAO myNotesDAO) {
        this.myNotesDAO = myNotesDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("notes",myNotesDAO.index());
        return "notes/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("note", myNotesDAO.show(id));
        return "notes/show";
    }

    @GetMapping("/new")
    public String newNote(Model model) {
        model.addAttribute("myNote", new Note());
        return "notes/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("myNote") Note myNote) {
        myNotesDAO.save(myNote);
        return "redirect:/notes";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("myNote",myNotesDAO.show(id));
        return "notes/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("myNote") Note myNote, @PathVariable("id") int id) {
        myNotesDAO.update(id, myNote);
        return "redirect:/notes";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        myNotesDAO.delete(id);
        return "redirect:/notes";
    }

    @GetMapping("/back")
    public String redirect() {
        return "redirect:/notes";
    }

}
