package com.devglan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devglan.model.Module;
import com.devglan.model.SubModule;

@Repository
public interface SubModuleDao extends JpaRepository<SubModule,Long>{

	public List<SubModule> findByModule(Module module);
	//public SubModule findBySubModule(String module);

	public SubModule findBySubModuleName(String subModuleName);
}
