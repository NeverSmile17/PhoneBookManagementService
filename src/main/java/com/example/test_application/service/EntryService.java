package com.example.test_application.service;

import com.example.test_application.entity.Entry;

import java.util.List;

public interface EntryService {
    List<Entry> getAllEntries();

    void saveEntry(Entry entry);

    Entry getEntry(int id);

    void deleteEntry(int id);
}
