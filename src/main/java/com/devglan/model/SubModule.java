package com.devglan.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SubModule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long subModuleId;
	
	@NotNull
	private String subModuleName;
	
	@JsonIgnore
	@ManyToOne
	private Module module;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Screen> screenList;

	public SubModule() {
		super();
	}

	public SubModule(long subModuleId, String subModuleName, Module module) {
		super();
		this.subModuleId = subModuleId;
		this.subModuleName = subModuleName;
		this.module = module;
	}

	public long getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(long subModuleId) {
		this.subModuleId = subModuleId;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Screen> getScreenList() {
		return screenList;
	}

	public void setScreenList(List<Screen> screenList) {
		this.screenList = screenList;
	} 
	
	public void addScreenList(Screen screen) {
		if(null == screenList)
			screenList = new ArrayList<>();
		screenList.add(screen);
	}
	
	
	
}
