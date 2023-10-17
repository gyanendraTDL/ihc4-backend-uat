package com.tdl.river.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tdl.river.models.TicketHistory;

@Repository
public interface TicketHistoryDAO extends JpaRepository<TicketHistory, Integer>{


	@Query(value="select DATE_FORMAT(update_date, '%d-%m-%Y %H:%i:%s'),(select u.username from itx_users u where u.id=update_by) as updatedBy,(select name from im_ticket_status ts where ts.id=status),ccm_note,ccm1_note,ccm2_note,followup_note,om_qm_note,gm_note,(select u.username from itx_users u where u.id=escalationid) as escalationid,closure_comments,closure_file,if(closed_internally=1,'Closed Internally','') as closedInternally,preventive  from itx_ticket_status_logs where ticketid=:id order by update_date desc",nativeQuery = true)
	List<String[]> ticketHistory(Integer id);

	@Query(value="select DATE_FORMAT(update_date, '%d-%m-%Y %H:%i:%s'),(select u.username from itx_users u where u.id=update_by) as updatedBy,(select name from im_ticket_status ts where ts.id=status),ccm_note,ccm1_note,ccm2_note,followup_note,om_qm_note,gm_note,(select u.username from itx_users u where u.id=escalationid) as escalationid,closure_comments,closure_file,if(closed_internally=1,'Closed Internally','') as closedInternally,preventive,(select p.name as priority_name from im_priority p where p.id=t.priority), (select c.name as category_name from im_category c where c.id=t.category), (select sc.name as subcategory_name from im_category sc where sc.id=t.sub_category) from itx_ticket_status_logs t where ticketid=:id order by update_date desc",nativeQuery = true)
	List<String[]> ticketHistoryMph(Integer id);

}
