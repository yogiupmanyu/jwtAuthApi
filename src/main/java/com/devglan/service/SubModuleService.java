package com.devglan.service;

import java.util.List;

import com.devglan.model.Module;
import com.devglan.model.SubModule;

public interface SubModuleService {
	void save(SubModule subModule);
	List<SubModule> findAll();
    void delete(long id);
    SubModule findOne(String username);
    SubModule findById(Long id);
    List<SubModule> findSubModuleInModule(Module module);
}
