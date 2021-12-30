package com.atos.dawg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.atos.dawg.model.DawgModel;
import com.atos.dawg.repository.DawgRepository;

@Service
public class DawgServiceImpl implements DawgService{

	@Autowired
	DawgRepository dawgRepository;
	
	public Optional<DawgModel> getDawgById(long id) {
		Optional<DawgModel> dawgModelData = dawgRepository.findById(id);
		return dawgModelData;
		
	}
	
	public boolean deleteDawg(long id) {
		try {
			dawgRepository.deleteById(id);
			return true;//new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return false;//new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public boolean deleteAllDawg() {
		try {
			dawgRepository.deleteAll();
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	
	public DawgModel createDawg(DawgModel dawgModelValue) {
		
		try {			
			DawgModel dawgModel = dawgRepository
					.save(new DawgModel(dawgModelValue.getFormId(), dawgModelValue.getTitle(), dawgModelValue.getAttachments(), dawgModelValue.getDataAnalytics(),dawgModelValue.getPpmProjectId(),dawgModelValue.getForm_submittedby(),dawgModelValue.getNeed_by_time(),dawgModelValue.getNeed_by_rationalization(),dawgModelValue.getDawg_follow_up_questions(),dawgModelValue.getDawg_recommendation(),dawgModelValue.getDawg_cross_reference(),dawgModelValue.getDawg_additional_comments(),dawgModelValue.getKanban_state(),dawgModelValue.getDetailed_desc(),dawgModelValue.getPurpose(),dawgModelValue.getAcceptance_criteria(),dawgModelValue.getData_source(),dawgModelValue.getBusiness_contact(),dawgModelValue.getReq_managing_director(),dawgModelValue.getTechnical_contact(),dawgModelValue.getImpactedOpc(),dawgModelValue.getValueBenefit(),dawgModelValue.getSubmitted_date(),dawgModelValue.getDawg_FLW_UP(),dawgModelValue.getDawg_ready_for_dba_review(),dawgModelValue.getPlus_member(),dawgModelValue.getModified_on(),dawgModelValue.getModifier_name(),dawgModelValue.getCompleted_first_id()));
			return dawgModel;
		} catch (Exception e) {			
			return null;
		}
	}
	
	
	public DawgModel updateDawg(long id,DawgModel dawgModelValue) {
		Optional<DawgModel> dawgModelData = dawgRepository.findById(id);
		
		if (dawgModelData.isPresent()) {
			DawgModel dawgModel = dawgModelData.get();
			
			//dawgModel.setFormId(dawgModelValue.getFormId());
			dawgModel.setAttachments(dawgModelValue.getAttachments());
			dawgModel.setDataAnalytics(dawgModelValue.getDataAnalytics());
			dawgModel.setPpmProjectId(dawgModelValue.getPpmProjectId());
			//dawgModel.setRequest_title(dawgModelValue.getRequest_title());
			dawgModel.setForm_submittedby(dawgModelValue.getForm_submittedby());
			dawgModel.setNeed_by_time(dawgModelValue.getNeed_by_time());
			dawgModel.setNeed_by_rationalization(dawgModelValue.getNeed_by_rationalization());
			dawgModel.setDawg_follow_up_questions(dawgModelValue.getDawg_follow_up_questions());
			dawgModel.setDawg_recommendation(dawgModelValue.getDawg_recommendation());
			dawgModel.setDawg_cross_reference(dawgModelValue.getDawg_cross_reference());
			dawgModel.setDawg_additional_comments(dawgModelValue.getDawg_additional_comments());
			dawgModel.setKanban_state(dawgModelValue.getKanban_state());
			dawgModel.setDetailed_desc(dawgModelValue.getDetailed_desc());
			dawgModel.setPurpose(dawgModelValue.getPurpose());
			dawgModel.setAcceptance_criteria(dawgModelValue.getAcceptance_criteria());
			dawgModel.setData_source(dawgModelValue.getData_source());
			dawgModel.setBusiness_contact(dawgModelValue.getBusiness_contact());
			dawgModel.setReq_managing_director(dawgModelValue.getReq_managing_director());
			dawgModel.setTechnical_contact(dawgModelValue.getTechnical_contact());
			dawgModel.setImpactedOpc(dawgModelValue.getImpactedOpc());
			dawgModel.setValueBenefit(dawgModelValue.getValueBenefit());
			dawgModel.setSubmitted_date(dawgModelValue.getSubmitted_date());
			dawgModel.setDawg_FLW_UP(dawgModelValue.getDawg_FLW_UP());
			dawgModel.setDawg_ready_for_dba_review(dawgModelValue.getDawg_ready_for_dba_review());
			dawgModel.setPlus_member(dawgModelValue.getPlus_member());
			dawgModel.setModified_on(dawgModelValue.getModified_on());
			dawgModel.setModifier_name(dawgModelValue.getModifier_name());
			dawgModel.setCompleted_first_id(dawgModelValue.getCompleted_first_id());
			return dawgRepository.save(dawgModel);
		} else {
			return null;
		}
	}
	
	
	public List<DawgModel> getAllDawg() {
		try {
			List<DawgModel> tutorials = new ArrayList<DawgModel>();
			dawgRepository.findAll().forEach(tutorials::add);			
			return tutorials;
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
