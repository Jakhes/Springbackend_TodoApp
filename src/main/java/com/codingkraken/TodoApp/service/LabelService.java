package com.codingkraken.TodoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingkraken.TodoApp.exception.LabelNotFoundException;
import com.codingkraken.TodoApp.model.Label;
import com.codingkraken.TodoApp.repo.LabelRepository;

@Service
public class LabelService {
    private final LabelRepository labelRepository;

    @Autowired
    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public Label addLabel(Label label) {
        return labelRepository.save(label);
    }

    public Iterable<Label> findAllLabels() {
        return labelRepository.findAll();
    }

    public Label updateLabel(Label label) {
        return labelRepository.save(label);
    }

    public Label findLabelById(Integer id) {
        return labelRepository.findById(
                id)
                .orElseThrow(() -> new LabelNotFoundException("Label by id " + id + " was not found."));
    }

    public void deleteLabel(Integer id) {
        labelRepository.deleteById(id);
    }
}