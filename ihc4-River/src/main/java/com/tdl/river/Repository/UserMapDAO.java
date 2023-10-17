package com.tdl.river.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tdl.river.models.UserMap;

public interface UserMapDAO extends JpaRepository<UserMap, Integer>{


	@Query(value="select id,drilldown_name,(select u.username from itx_users u where u.id=userid),(select b.name from im_branch b where b.id=branchid),form_type,userid,level,ward_name,(IFNULL(ELT(FIELD(location,1,2,3),'Reception','Concierge','Information Counter'), 'NA')) , (select f.factor_name from im_factor_questions  f where f.id=(select parentid from  im_factor_questions f2 where f2.id=drilldownid)) as parentfactor from itx_user_ticket_map where companyid=:companyID and (:branchID is null || :branchID ='' || branchID=:branchID) and (:typeID is null || :typeID='' || form_type=:typeID) and (:level=0 || level=:level)",nativeQuery = true)
	List<String[]> getTicketData(Integer companyID, Integer branchID, String typeID, int level);

	UserMap findByIdAndCompanyID(Integer id, Integer companyID);
	
	@Query(value="select ccmobnum from cc_config_mob where userid=:ID",nativeQuery = true)
	Integer[] findByccListNum(Integer ID);

	@Query(value="select * from itx_user_ticket_map where companyid=:companyID and form_type=:type and branchid=:branchID and ward_name=:wardNo and drilldownid=:factorName and level=1 order by id limit 1",nativeQuery = true)
	UserMap findEscalationByWard(int companyID, int branchID, String wardNo, int factorName, String type);

	List<UserMap> findByFormTypeAndBranchIDAndLevel(String type, int branchID, int i);

	@Query(value="select * from itx_user_ticket_map where companyid=:companyID and form_type=:type and branchid=:branchID and location=:location and drilldown_name=:factorName and level=1 order by id limit 1",nativeQuery = true)
	UserMap findEscalationByRegistration(int companyID, int branchID, String location, String factorName, String type);

	List<UserMap> findByFormTypeAndBranchIDAndLevelAndCompanyID(String type, int branchID, int i, int companyID);


	@Query(value="SELECT * FROM itx_user_ticket_map where drilldownid=:id and companyid=:companyid and level=:level order by id desc limit 1",nativeQuery = true)
	UserMap getUserMap(int id, int companyid, int level);

	@Query(value="select * from itx_user_ticket_map where companyid=:companyID and form_type=:type and branchid=:branchID and level=:level and drilldown_name='OVERALL_EXPERIENCE'",nativeQuery = true)
	UserMap getOverallExp(String type, int branchID, int level, int companyID);

	@Query(value="select  f.id,f.is_header,f.form_sequence,f.factor_name factorName ,(select concat (u.username ,\" (\",u.email,\" - \",u.contact_no,\")\" ) from itx_users u where u.id=userid ) level1,form_type type from itx_user_ticket_map um ,im_factor_questions f where f.id=drilldownid and um.companyid=:companyID and (:branchID is null || :branchID='' || um.branchid=:branchID ) and (:typeID is null || :typeID='' || f.type=:typeID ) order by sequence,um.form_type,level",nativeQuery = true)
	List<String[]> preapreEscalation(Integer companyID, Integer branchID, String typeID);

	UserMap findByBranchIDAndCompanyIDAndFormTypeAndDrilldownIDAndLevelAndWardID(int branchID, int companyID,
			String formType, int drilldownID, int level, int wardID);

	@Query(value="select um.level,(select u.email from itx_users u where u.id=userid) mailTo,(select GROUP_CONCAT(u.email ) from itx_users u, cc_config cc where u.id=cc.cc_id and cc.user_map_id=um.id) from itx_user_ticket_map um where drilldownid=:serviceID and companyid=:companyID and (level=1 || level=2) and if((drilldownid=10 || drilldownid=15) , ward_name=:wardName ,ward_name='')",nativeQuery = true)
	List<String[]> getuserMapData(int companyID, int serviceID,String wardName);


}
