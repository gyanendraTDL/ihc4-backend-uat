package com.tdl.river.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tdl.river.models.Branch;

@Transactional
public interface BranchDAO extends CrudRepository<Branch, Long> {

	/**
	 * This method will find an User instance in the database by its email. Note
	 * that this method is not implemented and its working code will be
	 * automagically generated from its signature by Spring Data JPA.
	 */
	public List<Branch> findAll();

	/*
	 * @Query(
	 * value="select * from branch where companyID=:companyID and (:countryID is null or :countryID='' or countryID=:countryID) order by countryID,id"
	 * , nativeQuery = true ) public List<Branch> findByCompanyID(String companyID,
	 * String countryID);
	 * 
	 */
	@Query(value = "select * from im_branch b where b.id IN (select branch_fk from branch_config where user_fk=:userId) order by name", nativeQuery = true)
	public List<Branch> findByUserIdOrderByName(int userId);

	@Query(value = "select * from branch where branch_code=:branchcode and hospcode=:hospcode ", nativeQuery = true)
	public Branch findBranchData(String hospcode, String branchcode);

	@Query(value = "select * from im_branch where companyID=:companyID and (:countryID is null or :countryID='' or countryID=:countryID) and (:clusterID is null or :clusterID='' or clusterid=:clusterID) order by id,name,countryID", nativeQuery = true)
	public List<Branch> findByCompanyID(Integer companyID, Integer countryID, Integer clusterID);

	@Query(value = "select countryid from im_branch where id=:branchID ", nativeQuery = true)
	public int findCountryID(int branchID);

	@Query(value = "select id from im_branch where branch_code=:facility ", nativeQuery = true)
	public Integer getBranch(String facility);

	public List<Branch> findByCompanyIDAndCountryID(String companyID, String countryID);

	@Query(value = "select * from im_branch where companyID=:companyID and (:countryID is null or :countryID='' or countryID=:countryID) and (:clusterID is null or :clusterID='' or clusterid=:clusterID) order by name,id,countryID", nativeQuery = true)
	public List<Branch> findByCompanyIDOrderByName(Integer companyID, Integer countryID, Integer clusterID);

}