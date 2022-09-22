package com.example.test_application.controller;

import com.example.test_application.entity.Entry;
import com.example.test_application.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private EntryService entryService;

    @GetMapping("/entries")
    public List<Entry> showAllEntries() {
        return entryService.getAllEntries();
    }

    @GetMapping("/entries/{id}")
    public Entry getEmployee(@PathVariable int id) {
        return entryService.getEntry(id);
    }

    @PostMapping("/entries")
    public Entry addNewEntry(@RequestBody Entry entry) {
        entry.setDate(LocalDateTime.now());
        entryService.saveEntry(entry);
        return entry;
    }

    @PutMapping("/entries")
    public Entry updateEntry(@RequestBody Entry entry) {
        entry.setDate(LocalDateTime.now());
        entryService.saveEntry(entry);
        return entry;
    }

    @DeleteMapping("/entries/{id}")
    public String deleteEntry(@PathVariable int id) {
        entryService.deleteEntry(id);
        return String.format("Entry with ID %d was deleted", id);
    }
}
