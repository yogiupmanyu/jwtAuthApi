package com.devglan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devglan.model.Screen;
import com.devglan.model.SubModule;


@Repository
public interface ScreenDao extends JpaRepository<Screen, Long> {
	public List<Screen> findBySubModule(SubModule subModule);
	public Screen findByScreenName(String username);
}
