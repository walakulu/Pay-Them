package com.recruit.paythem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recruit.paythem.domain.PaymentDetail;

@Repository
public interface BillingRepository extends JpaRepository<PaymentDetail,Long> {
	
	@Query(value = "SELECT COUNT(*) \r\n" + 
			"FROM RECRUITMENT r \r\n" + 
			"INNER JOIN CATAGORY c \r\n" + 
			"ON r.CATAGORY_ID=c.ID \r\n" + 
			"LEFT JOIN RECRUITMENT_PAYMENT rp \r\n" + 
			"ON r.ID=rp.RECRUITMENT_ID\r\n" + 
			"WHERE r.HEAD_HUNTER_ID=?1 AND c.TYPE=?2 AND r.GROUP=?3 AND MONTH(r.RECRUITMENT_DATE)=?4 AND rp.RECRUITMENT_ID IS NULL", nativeQuery = true)

	Integer findBillingCountByHeadHunterIdTypeGroupAndMonth(int headHunterId,String employeeType,String isGroup,int month);

}
