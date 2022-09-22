package com.example.test_application.service;

import com.example.test_application.dao.EntryRepository;
import com.example.test_application.entity.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EntryServiceImpl implements EntryService{

    @Autowired
    private EntryRepository entryRepository;

    @Override
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    @Override
    public void saveEntry(Entry entry) {
        entryRepository.save(entry);
    }

    @Override
    public Entry getEntry(int id) {
        Optional<Entry> optional = entryRepository.findById(id);
        if(optional.isEmpty()){
            throw new RuntimeException();
        }
        return optional.get();
    }

    @Override
    public void deleteEntry(int id) {
        entryRepository.deleteById(id);
    }
}
