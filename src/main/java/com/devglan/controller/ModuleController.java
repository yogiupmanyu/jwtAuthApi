package com.devglan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.model.Module;
import com.devglan.model.Screen;
import com.devglan.model.SubModule;
import com.devglan.requests.Module_SubModule_ScreenParams;
import com.devglan.service.ModuleService;
import com.devglan.service.ScreenService;
import com.devglan.service.SubModuleService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800)
@RequestMapping("/module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private SubModuleService subModuleService;
	@Autowired
	private ScreenService screenService;
	
	@PostMapping("/saveModule")
	public void saveModule(@RequestBody Module_SubModule_ScreenParams requestParam) {
		Module module = new Module();
		SubModule subModule = new SubModule();
		Screen screen = new Screen();
		
		module.setModuleName(requestParam.getModuleName());
		if(module.getSubModuleList() == null) {
			List<SubModule> list = new ArrayList<>();
			list.add(subModule);
			module.setSubModuleList(list);
		}
		
		subModule.setSubModuleName(requestParam.getSubModuleName());
		subModule.setModule(module);
		if(subModule.getScreenList() == null) {
			List<Screen> list = new ArrayList<>();
			list.add(screen);
			subModule.setScreenList(list);
		}
		
		screen.setScreenName(requestParam.getScreenName());
		screen.setScreenUrl(requestParam.getScreenUrl());
		screen.setSubModule(subModule);
		
		moduleService.save(module);
		subModuleService.save(subModule);
		screenService.save(screen);

	}
	
	@PostMapping("/saveSubModule")
	public void saveSubModule(@RequestBody Module_SubModule_ScreenParams requestParam) {
		Module module = moduleService.findById(requestParam.getModuleId());
		SubModule subModule = new SubModule();
		Screen screen = new Screen();
		
		if(module.getSubModuleList()!=null) {
			module.getSubModuleList().add(subModule);
		}
		
		subModule.setSubModuleName(requestParam.getSubModuleName());
		subModule.setModule(module);
		if(subModule.getScreenList() == null) {
			List<Screen> list = new ArrayList<>();
			list.add(screen);
			subModule.setScreenList(list);
		}
		
		screen.setScreenName(requestParam.getScreenName());
		screen.setScreenUrl(requestParam.getScreenUrl());
		screen.setSubModule(subModule);
		
		moduleService.save(module);
		subModuleService.save(subModule);
		screenService.save(screen);
		
	}
	
	@PostMapping("/saveScreen")
	public void saveScreen(@RequestBody Module_SubModule_ScreenParams requestParam) {
		Module module = moduleService.findById(requestParam.getModuleId());
		SubModule subModule = subModuleService.findById(requestParam.getSubModuleId());
		Screen screen = new Screen();
		
		if(subModule.getScreenList()!=null)
			subModule.getScreenList().add(screen);
		
		screen.setScreenName(requestParam.getScreenName());
		screen.setScreenUrl(requestParam.getScreenUrl());
		screen.setSubModule(subModule);
		
		moduleService.save(module);
		subModuleService.save(subModule);
		screenService.save(screen);
		
	}
	
	@GetMapping("/getSubModule/{moduleId}")
	public List<SubModule> getSubModle(@PathVariable Integer moduleId){
		Module module = new Module();
		module.setModuleId(moduleId);
		return subModuleService.findSubModuleInModule(module);
	}
	
	@GetMapping("/getScreen/{subModuleId}")
	public List<Screen> getScreen(@PathVariable Integer subModuleId){
		SubModule subModule = new SubModule();
		subModule.setSubModuleId(subModuleId);
		return screenService.findScreenInSubModule(subModule);
	}
	
	@GetMapping("/getModule")
	public List<Module> getModule(){
		return moduleService.findAll();
	}
	
}
