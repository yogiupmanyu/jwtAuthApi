package com.devglan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.ScreenDao;
import com.devglan.dao.SubModuleDao;
import com.devglan.model.Module;
import com.devglan.model.SubModule;
import com.devglan.service.SubModuleService;

@Service(value = "subModuleService")
public class SubModuleServiceImpl implements SubModuleService {
	
	@Autowired
	private SubModuleDao subModuleDao ;

	@Autowired
	private ScreenDao screenDao;
	
	@Override
	public void save(SubModule subModule) {
		subModuleDao.save(subModule);
	}

	@Override
	public List<SubModule> findAll() {
		List<SubModule> subModuleList = new ArrayList<>();
		subModuleDao.findAll().iterator().forEachRemaining(subModuleList::add);
		return subModuleList;
	}

	@Override
	public void delete(long id) {
		subModuleDao.delete(id);
	}

	@Override
	public SubModule findOne(String subModuleName) {
		return subModuleDao.findBySubModuleName(subModuleName);
	}

	@Override
	public SubModule findById(Long id) {
		return subModuleDao.findOne(id);
	}

	@Override
	public List<SubModule> findSubModuleInModule(Module module) {
		return subModuleDao.findByModule(module);
	}

}
