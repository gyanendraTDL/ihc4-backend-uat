package com.tdl.river.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tdl.river.models.Type;

public interface TypeDAO extends CrudRepository<Type, Integer> {
	public List<Type> findAll();

	public List<Type> findByCompanyid(int companyID);

	public List<Type> findByCompanyidOrderById(int companyID);

	@Query(value = "select * from im_type t where t.companyid=:companyID order by t.id desc", nativeQuery = true)
	public List<String[]> getByCompanyid(int companyID);

	public Optional<Type> findByTypeid(String id);

}
