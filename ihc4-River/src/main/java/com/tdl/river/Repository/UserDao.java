package com.tdl.river.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tdl.river.models.Users;

public interface UserDao extends JpaRepository<Users, Integer>{

	Users findByEmail(String email);
	
	
	@Query(value="select * from itx_users where groupID!=3 and companyid=:companyID and (:countryID is null || :countryID='' || countryid=:countryID) and (:branchID is null || :branchID='' || branchid=:branchID)",nativeQuery = true)
	List<Users> getUserList(Integer companyID, Integer countryID, Integer branchID);
	
	@Query(value="select * from itx_users where groupID!=3 and companyid=:companyID and (:countryID is null || :countryID='' || countryid=:countryID) and (:branchID is null || :branchID='' || branchid=:branchID) order by username asc",nativeQuery = true)
	List<Users> getOrderedUserList(Integer companyID, Integer countryID, Integer branchID);
	
	@Query(value="select id,username,contact_no,email,level,(select b.name from im_branch b where b.id=branchID) from itx_users where  companyid=:companyID and (:countryID is null || :countryID='' || countryid=:countryID) and (:branchID is null || :branchID='' || branchid=:branchID) and (:clusterID is null || :clusterID='' || clusterid=:clusterID)",nativeQuery = true)
	List<String[]> getUserListData(Integer companyID, Integer countryID, Integer clusterID,Integer branchID);


	Users findByIdAndCompanyID(Integer id, Integer companyID);

	@Query(value="select distinct id,username,email,contact_no from itx_users  u,branch_config b where u.id=b.user_fk and u.companyid=:companyID and (:branchID is null || :branchID='' ||  b.branch_fk =:branchID)",nativeQuery = true)
	List<String[]> getBranchList(Integer companyID, Integer branchID);

	Users findByUsername(String username);


	//List<FunctionMaster> findByFunList(String userID);

	@Query(value="select id,username,email from itx_users where companyid=:companyID and groupid!=3",nativeQuery = true)
	List<String[]> getuserData(Integer companyID);
	
	@Query(value="select id,username,email from itx_users where companyid=:companyID and branchid=:branchID and groupid!=3",nativeQuery = true)
	List<String[]> findByComanyIDandBranchID(Integer companyID,Integer branchID);

    @Query(value="select username from itx_users where id=:createdBy",nativeQuery = true) 
	String getUserName(int createdBy);


	List<Users> findByCompanyID(Integer companyID);
	
	//Users findByBranchIDAndDeviceID(long branchID,String deviceID);

	@Query(value="select id from itx_users where branchid=:branchID and deviceid=:deviceID and companyid=:companyID",nativeQuery = true) 
	Integer getId(long branchID,int deviceID,int companyID);


	@Query(value="select countryid from itx_users where id=:updated_by",nativeQuery = true)
	Integer getCountryID(int updated_by);

    @Query(value="select pcipherpassword from itx_users where id=:userID ",nativeQuery = true)
	String getPassword(Integer userID);
    
    @Query(value="select id,username,contact_no,email,level,(select b.name from im_branch b where b.id=branchID) from itx_users where  companyid=:companyID and (:countryID is null || :countryID='' || countryid=:countryID) and (:branchID is null || :branchID='' || branchid=:branchID) and (:clusterID is null || :clusterID='' || clusterid=:clusterID) and groupID!=3",nativeQuery = true)
	List<String[]> getOfficerUser(Integer companyID, Integer countryID, Integer clusterID,Integer branchID);


	List<Users> findByCompanyIDAndDeviceID(Integer companyID, int i);


	List<Users> findByCompanyIDAndRoll(Integer countryID, Integer id);


	@Query(value = "select contact_no from itx_users where id=:ID", nativeQuery = true)
	String getConNo(int ID);


	@Query(value="Select * from itx_users where companyID=:companyID and (:countryID is null || :countryID='' || countryid=:countryID) and (:branchID is null || :branchID='' || branchid=:branchID) and (:clusterID is null || :clusterID='' || clusterid=:clusterID) and groupID!=3 order by username ",nativeQuery = true)
	List<Users> getUserList(Integer companyID, String countryID, String clusterID, String branchID);
}
