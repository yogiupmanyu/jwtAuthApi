package com.devglan.service;

import java.util.List;

import com.devglan.model.Screen;
import com.devglan.model.SubModule;

public interface ScreenService {

	void save(Screen screen);
	List<Screen> findAll();
    void delete(long id);
    Screen findOne(String username);
    Screen findById(Long id);
	List<Screen> findScreenInSubModule(SubModule subModule);
}
