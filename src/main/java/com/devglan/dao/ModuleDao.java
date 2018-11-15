package com.devglan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devglan.model.Module;


@Repository
public interface ModuleDao extends JpaRepository<Module, Long>{

	public Module findByModuleName(String moduleName);
}
