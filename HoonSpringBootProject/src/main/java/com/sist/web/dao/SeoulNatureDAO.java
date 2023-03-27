package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.SeoulNatureEntity;

@Repository
public interface SeoulNatureDAO extends JpaRepository<SeoulNatureEntity, Integer>{
	@Query(value="SELECT * FROM seoul_nature ORDER BY no LIMIT 0,3",nativeQuery = true)
	public List<SeoulNatureEntity> seoulNatureData();
	public SeoulNatureEntity findByno(@Param("no") Integer no);
	
}
