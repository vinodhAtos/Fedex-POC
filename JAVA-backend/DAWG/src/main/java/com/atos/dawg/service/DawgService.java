package com.atos.dawg.service;

import java.util.List;
import java.util.Optional;

import com.atos.dawg.model.DawgModel;


public interface DawgService {

	public List<DawgModel> getAllDawg();
	
	public Optional<DawgModel> getDawgById(long id);
	
	public boolean deleteDawg(long id);
	
	public boolean deleteAllDawg();
	
	public DawgModel createDawg(DawgModel dawgModelValue);
	
	public DawgModel updateDawg(long id,DawgModel dawgModelValue);
}
