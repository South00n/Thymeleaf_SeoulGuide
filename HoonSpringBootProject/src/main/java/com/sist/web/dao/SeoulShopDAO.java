package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.SeoulShopEntity;

@Repository
public interface SeoulShopDAO extends JpaRepository<SeoulShopEntity, Integer>{
	@Query(value="SELECT * FROM seoul_shop ORDER BY no LIMIT 0,3",nativeQuery = true)
	public List<SeoulShopEntity> seoulShopData();
	public SeoulShopEntity findByno(@Param("no") Integer no);
	
}
