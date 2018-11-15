package com.devglan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.ScreenDao;
import com.devglan.model.Screen;
import com.devglan.model.SubModule;
import com.devglan.service.ScreenService;

@Service(value = "screenService")
public class ScreenServiceImpl implements ScreenService {

	@Autowired
	private ScreenDao screenDao;
	
	@Override
	public void save(Screen screen) {
		screenDao.save(screen);
	}

	@Override
	public List<Screen> findAll() {
		List<Screen> screenList = new ArrayList<>();
		screenDao.findAll().iterator().forEachRemaining(screenList::add);
		return screenList;
	}

	@Override
	public void delete(long id) {
		screenDao.delete(id);
	}

	@Override
	public Screen findOne(String username) {
		return screenDao.findByScreenName(username);
	}

	@Override
	public Screen findById(Long id) {
		return screenDao.findOne(id);
	}

	@Override
	public List<Screen> findScreenInSubModule(SubModule subModule) {
		return screenDao.findBySubModule(subModule);
	}

}
