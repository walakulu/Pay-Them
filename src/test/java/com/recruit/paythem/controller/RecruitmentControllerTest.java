package com.recruit.paythem.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.ResponseMessage;
import com.recruit.paythem.service.RecruitmentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RecruitmentController.class, secure = false)
public class RecruitmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RecruitmentService recruitmentService;
		
	@Test
	public void findRecruitmentDetails() throws Exception {

		Map<String, Object> dataContent = new HashMap<String, Object>();
		List<Map<String, Object>> recruitmentDetailList = new ArrayList<Map<String, Object>>();
		dataContent = new HashMap<String, Object>();
		dataContent.put("type", "Mason");
		dataContent.put("isGroup", "Y");
		dataContent.put("recruitmentId", 6);
		dataContent.put("recruitmentDate", "2018-06-01T18:30:00.000+0000");

		recruitmentDetailList = new ArrayList<Map<String, Object>>();
		recruitmentDetailList.add(dataContent);

		ResponseDto responseDto = new ResponseDto.Builder()
					.withMessageCode(ResponseMessage.SUCCESS.getCode())
					.withMessage(ResponseMessage.SUCCESS.getMessage())
					.withResponseObject(recruitmentDetailList)
					.build();
			
		Mockito.when(recruitmentService.findRecruitmentDetails(1, "Y", 6)).thenReturn(responseDto);
		
		mockMvc.perform(get("/recruitment/head-hunter/1/group/Y/month/6").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.messageCode", is("S500"))).andExpect(jsonPath("$.message", is("Success")))
				.andExpect(jsonPath("$.response[0].isGroup", is("Y")))
				.andExpect(jsonPath("$.response[0].recruitmentDate", is("2018-06-01T18:30:00.000+0000")))
				.andExpect(jsonPath("$.response[0].type", is("Mason")))
				.andExpect(jsonPath("$.response[0].recruitmentId", is(6)));
		
		}


}
