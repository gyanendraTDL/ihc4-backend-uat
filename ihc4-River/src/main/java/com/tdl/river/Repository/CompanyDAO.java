package com.tdl.river.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tdl.river.models.Company;

public interface CompanyDAO extends JpaRepository<Company, Integer> {

	@Query("select autoRouting from Company where id=:companyID")
	int autoRoutindIndicaator(Integer companyID);

	@Query(value="select * from im_company where id=:companyID",nativeQuery = true)
	Company getHisData(int companyID);

	@Query(value="select domain_name,smtp_port,smtp_email,smtp_password from im_company where id=:companyID",nativeQuery = true)
	List<String> domainData(int companyID);
	
	

}
