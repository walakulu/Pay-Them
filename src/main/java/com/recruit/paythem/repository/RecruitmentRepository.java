package com.recruit.paythem.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.recruit.paythem.domain.Recruitment;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {
	@Query(value = "SELECT r.ID AS recruitmentId,c.TYPE as type,r.GROUP as isGroup ,r.RECRUITMENT_DATE as recruitmentDate\r\n" + 
			"FROM RECRUITMENT r \r\n" + 
			"INNER JOIN HEAD_HUNTER h \r\n" + 
			"ON r.HEAD_HUNTER_ID=h.ID\r\n" + 
			"INNER JOIN CATAGORY c\r\n" + 
			"ON r.CATAGORY_ID=c.ID \r\n" + 
			"WHERE h.ID= ?1 AND r.GROUP=?2 AND MONTH(r.RECRUITMENT_DATE)=?3", nativeQuery = true)

	List<Map<String, Object>> findRecruitmentDetails(int headHunterId, String group,int month);
	
	
	//List<Map<String, Object>> findRecruitmnetByHeadHunterIdAndGroupAndRecruitmentDate(int headHunterId, String group,int month);
	

}
