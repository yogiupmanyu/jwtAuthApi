package com.devglan.service;

import java.util.List;

import com.devglan.model.Module;

public interface ModuleService {

	void save(Module module);
	List<Module> findAll();
    void delete(long id);
    Module findOne(String username);
    Module findById(Long id);
	
}
