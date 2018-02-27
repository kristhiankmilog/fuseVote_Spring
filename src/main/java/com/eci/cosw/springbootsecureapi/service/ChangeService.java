package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Change;

import java.util.List;

public interface ChangeService {
    List<Change> getChangeList();
    Change addChange(Change change);
}
