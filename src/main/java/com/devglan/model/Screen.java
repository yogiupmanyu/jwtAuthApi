package com.devglan.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Screen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long screenId;
	
	@NotNull
	private String screenName;
	
	@NotNull
	private String screenUrl;
	
	@JsonIgnore
	@ManyToOne
	private SubModule subModule;

	public Screen(long screenId, String screenName, String screenUrl) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.screenUrl = screenUrl;
	}

	public Screen() {
		super();
	}

	public long getScreenId() {
		return screenId;
	}

	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getScreenUrl() {
		return screenUrl;
	}

	public void setScreenUrl(String screenUrl) {
		this.screenUrl = screenUrl;
	}

	public SubModule getSubModule() {
		return subModule;
	}

	public void setSubModule(SubModule subModule) {
		this.subModule = subModule;
	}
	

}
