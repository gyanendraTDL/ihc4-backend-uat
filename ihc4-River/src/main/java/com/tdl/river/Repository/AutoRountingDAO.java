package com.tdl.river.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tdl.river.models.AutoRoutingCriteria;


public interface AutoRountingDAO extends JpaRepository<AutoRoutingCriteria, Integer>{

	@Query(value="select id,word,(select u.username from itx_users u where u.id=escalationid),(select b.name from im_branch b where b.id=branchid),typeid from auto_routing_criteria where companyid=:companyID and (:branchID is null || :branchID='' || branchid=:branchID ) and (:typeID is null || :typeID='' || typeid=:typeID )",nativeQuery = true)
	List<String[]> autoescaltion(Integer companyID, Integer branchID, String typeID);

	AutoRoutingCriteria findByWordAndCompanyID(String word, int companyID);

	AutoRoutingCriteria findByWordAndCompanyIDAndBranchID(String word, int companyID, int branchID);

	List<AutoRoutingCriteria> findByCompanyIDAndBranchID(int companyID, int branchID);

	List<AutoRoutingCriteria> findByCompanyIDAndBranchIDAndTypeID(int companyID, int branchID, String type);


}
