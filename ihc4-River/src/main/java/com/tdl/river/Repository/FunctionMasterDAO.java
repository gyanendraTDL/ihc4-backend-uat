package com.tdl.river.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tdl.river.models.FunctionMaster;

public interface FunctionMasterDAO extends JpaRepository<FunctionMaster, Integer> {

	@Query(value="select * from im_function_master order by menu_seq,sequence",nativeQuery = true)
	List<FunctionMaster> getmenulist();

	 @Query(value="select id from im_function_master",nativeQuery = true)
	    public List<Integer> findByID(int ID);



}
