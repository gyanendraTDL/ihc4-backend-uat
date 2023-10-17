package com.tdl.river.Repository;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tdl.river.models.Feedback;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer>{
	
	@Query(value = "select id from ifb_feedback where created_date=:created_date  and channelID=:channelID and feedback=:feedback and rating=:rating and ref_no=:refNo and name=:name and type=:type and companyID=:companyID and contact_no=:contactNo limit 1", nativeQuery = true)
	Integer checkDuplicate(LocalDateTime created_date, int channelID, int feedback, int rating, String name,
			String refNo, String type, int companyID,String contactNo);
	
	@Query(value = "select created_date as diff from ifb_feedback where  channelID=:channelID and feedback=:feedback and rating=:rating and ref_no=:refNo and name=:name and type=:type and companyID=:companyID and contact_no=:contactNo order by id desc limit 1", nativeQuery = true)
	LocalDateTime checkDifference( int channelID, int feedback, int rating, String name,
			String refNo, String type,int companyID,String contactNo);
	
	@Modifying
	@Transactional
	@Query(value = "update ifb_feedback set psi=:psi,psi_rating=:psiRating where id=:feedbackID", nativeQuery = true)
	void updateFbpsi( int feedbackID, int psi, String psiRating);

}
