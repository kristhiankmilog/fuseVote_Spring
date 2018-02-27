package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Change;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChangeServiceImpl implements ChangeService {


    private List<Change> todos = new ArrayList<Change>();

    @Autowired
    public ChangeServiceImpl() {

    }

    @Override
    public List<Change> getChangeList() {
        return todos;
    }

    @Override
    public Change addChange(Change change) {
        todos.add(change);
        return todos.get(todos.size() - 1);
    }
}
