package com.devglan.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Module {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long moduleId;
	
	@NotNull
	private String moduleName;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SubModule> subModuleList ;

	public Module() {
		super();
	}

	public Module(long moduleId, String moduleName) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<SubModule> getSubModuleList() {
		return subModuleList;
	}

	public void setSubModuleList(List<SubModule> subModuleList) {
		this.subModuleList = subModuleList;
	}
	
	public void addSubModule(SubModule subModule) {
		if(subModuleList == null) 
			subModuleList = new ArrayList<>();
		subModuleList.add(subModule);
	}
	
	
}
