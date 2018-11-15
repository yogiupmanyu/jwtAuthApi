package com.devglan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.ModuleDao;
import com.devglan.dao.SubModuleDao;
import com.devglan.model.Module;
import com.devglan.model.SubModule;
import com.devglan.service.ModuleService;

@Service(value = "moduleService")
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleDao moduleDao;
	

	@Override
	public void save(Module module) {
		moduleDao.save(module);
	}

	@Override
	public List<Module> findAll() {
		List<Module> moduleList = new ArrayList<>();
		moduleDao.findAll().iterator().forEachRemaining(moduleList::add);  
		return moduleList;
	}

	@Override
	public void delete(long id) {
		moduleDao.delete(id);
	}

	@Override
	public Module findOne(String moduleName) {
		return moduleDao.findByModuleName(moduleName);
	}

	@Override
	public Module findById(Long id) {
		return moduleDao.findOne(id);
	}

}
