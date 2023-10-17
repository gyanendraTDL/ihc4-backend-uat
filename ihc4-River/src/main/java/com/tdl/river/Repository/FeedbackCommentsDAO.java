package com.tdl.river.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tdl.river.models.FeedbackComments;


public interface FeedbackCommentsDAO extends JpaRepository<FeedbackComments, Integer> {

	FeedbackComments findByFeedbackID(int id);

	@Query(value="select comment:colVal FROM ifb_feedback_comments  where feedbackid=:id",nativeQuery = true)
	String prepareCmts(int colVal, String id);

}
