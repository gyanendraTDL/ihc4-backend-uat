package com.tdl.river.Repository;
import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tdl.river.models.TicketEscalation;

@Repository
public interface TicketEscalationDAO extends JpaRepository<TicketEscalation, Integer> {

	@Modifying
	@Transactional
	@Query(value="update itx_ticket_escalation set note=:depNote , modified_by=:updated_by , modified_date=:modifiedDate where companyid=:companyID and escalationid=:escalationid and ticketid=:id",nativeQuery = true)
	void updatedepNote(LocalDateTime modifiedDate, int updated_by, String depNote, int id, int escalationid, int companyID);

	@Query(value="select DATE_FORMAT(modified_date, '%Y-%m-%d %H:%i:%S'),(select u.username from itx_users u where u.id=te.modified_by),note from itx_ticket_escalation te where  ticketid=:id and companyid=:companyID and note is not null and note!=''",nativeQuery = true)
	List<String[]> followUp(Integer id, Integer companyID);

	@Modifying
	@Transactional
	@Query(value="update itx_ticket_escalation set note=:depNote , modified_by=:updated_by , modified_date=:modifiedDate where companyid=:companyID and escalationid=:updated_by and ticketid=:id",nativeQuery = true)
	void updatedepNoteTktRsn(LocalDateTime modifiedDate, int updated_by, String depNote, int id,  int companyID);

	@Query(value="select DATE_FORMAT(modified_date, '%Y-%m-%d %H:%i:%S'),(select u.username from itx_users u where u.id=te.modified_by),closure_comments from itx_ticket_escalation te where  ticketid=:id and companyid=:companyID and closure_comments is not null and closure_comments!=''",nativeQuery = true)
	List<String[]> closeUp(Integer id, Integer companyID);
	
	@Query(value="select id,file_path from itx_ticket_escalation te where  ticketid=:id and companyid=:companyID and file_path is not null and file_path!=''order by id desc limit 1",nativeQuery = true)
	List<String[]> FileDwn(Integer id, Integer companyID);
	
	@Modifying
	@Transactional
	@Query(value="update itx_ticket_escalation set closure_comments=:closureComments , modified_by=:updated_by , modified_date=:modifiedDate where companyid=:companyID and escalationid=:updated_by and ticketid=:id",nativeQuery = true)
	void updateclosureComments(LocalDateTime modifiedDate, int updated_by, String closureComments, int id,  int companyID);

	TicketEscalation findByCompanyIDAndTicketID(Integer companyID, Long ticketID);
	TicketEscalation findByCompanyIDAndEscalationIDAndTicketID(Integer companyID, Long updatedBy, Long ticketID);
	@Query(value="select * from itx_ticket_escalation te where companyid=:companyID and escalationid=:escalationid and ticketid=:id",nativeQuery = true)
	TicketEscalation getByCompanyIDAndEscalationIDAndTicketID(Integer companyID, Integer escalationid, Integer id);

	
	


}
