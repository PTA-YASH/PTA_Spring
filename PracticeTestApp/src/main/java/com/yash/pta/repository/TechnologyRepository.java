package com.yash.pta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.pta.model.Technology;
/**
 * CRUD repository for Technology entity
 * Which performs all operations related to Technology.
 */
@Repository
public interface TechnologyRepository extends JpaRepository<Technology,Integer> {

}
