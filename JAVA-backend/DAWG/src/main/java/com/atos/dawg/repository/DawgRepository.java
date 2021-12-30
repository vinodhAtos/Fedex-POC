package com.atos.dawg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.dawg.model.DawgModel;


	
public interface DawgRepository extends JpaRepository<DawgModel, Long> {
  
}
