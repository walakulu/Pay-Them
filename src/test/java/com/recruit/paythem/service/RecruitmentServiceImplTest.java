package com.recruit.paythem.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.repository.RecruitmentRepository;
import com.recruit.paythem.service.RecruitmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecruitmentServiceImplTest {
	
	@Autowired
	private RecruitmentService recruitmentService;
	
	@MockBean
	private RecruitmentRepository recruitmentRepository;
	
	@Test
	public void testFindRecruitmentDetails() throws Exception {
		Map<String, Object> dataContent= new HashMap<String, Object>();
		List<Map<String, Object>> recruitmentDetailList=new ArrayList<Map<String, Object>>();
    	dataContent.put("type", "Mason");
		dataContent.put("isGroup", "Y");
		dataContent.put("recruitmentId", 6);
		dataContent.put("recruitmentDate", "2018-06-01T18:30:00.000+0000");	
		recruitmentDetailList.add(dataContent);
		
		ResponseDto responseDto = new ResponseDto.Builder()
					.withResponseObject(recruitmentDetailList)
					.build();
		
		Mockito.when(recruitmentRepository.findRecruitmentDetails(1, "Y", 6)).thenReturn(recruitmentDetailList);
		assertThat(recruitmentService.findRecruitmentDetails(1, "Y", 6)).isEqualTo(responseDto);
	}




}
