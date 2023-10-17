package com.tdl.river.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tdl.river.models.FactorName;

@Repository
public interface FactorNameDao extends JpaRepository<FactorName, Integer>{

	@Query(value="select * from im_factor_questions f where f.commpanyid=:companyID and f.type=:type  and factor_name !='OVERALL_EXPERIENCE' and factor_name !='Overall experience' and   factor_name !='RECOMMENDATION' and factor_name !='Formal Complaints'  order by f.sequence",nativeQuery = true)
	List<FactorName> getFactorQue(String type,Integer companyID);
	
	@Query(value="select * from im_factor_questions f where f.commpanyid=:companyID and (:type is null || :type='' || f.type=:type) and id!=62   order by f.type, f.sequence",nativeQuery = true)
	List<FactorName> getFactorList(String type,Integer companyID);//
	
	@Query("select factor_name from FactorName where id=:factorNumber")
	String getFactorName(int factorNumber);
	
	@Query("select factor_name from FactorName where parentID=:id order by sequence ")
	String[] getSubQues(int id);
	
	@Query(value="select * from im_factor_questions where id=:id",nativeQuery = true)
	FactorName getFactorById(int id);
	
	@Query(value="select * from im_factor_questions f where f.commpanyid=:companyID and parentid=:parentID and factor_name !='OVERALL_EXPERIENCE' and factor_name !='Overall experience' and   factor_name !='RECOMMENDATION' and rating=:issueType order by f.sequence",nativeQuery = true)
	List<FactorName> getFactorByTypeParent(Integer companyID,Integer parentID, Integer issueType);//
	
	List<FactorName> findByTypeAndCommpanyidOrderBySequence(String type, String companyID);

	
}
