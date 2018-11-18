package com.recruit.paythem.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.recruit.paythem.dto.HeadHunterDto;
import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.ResponseMessage;
import com.recruit.paythem.service.HeadHunterService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HeadHunterController.class, secure = false)
public class HeadHunterControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private HeadHunterService headHunterService;

	@Test
	public void getAllHeadHunters() throws Exception {
		List<HeadHunterDto> headHunterDtoList=new ArrayList<HeadHunterDto>();
		
		HeadHunterDto headHunter1=new HeadHunterDto.Builder()
						.withId(1)
						.withName("Open Recruit")
						.build();
		
		HeadHunterDto headHunter2= new HeadHunterDto.Builder()
						.withId(2)
						.withName("Linux Recruit Pvt")
						.build();
		
		headHunterDtoList.add(headHunter1);
		headHunterDtoList.add(headHunter2);
		
		ResponseDto responseDto = new ResponseDto.Builder()
						.withMessageCode(ResponseMessage.SUCCESS.getCode())
						.withMessage(ResponseMessage.SUCCESS.getMessage())
						.withResponseObject(headHunterDtoList)
						.build();
		
		Mockito.when(headHunterService.getAllHeadHunters()).thenReturn(responseDto);
		
		mockMvc.perform(get("/head-hunters").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.messageCode", is("S500"))).andExpect(jsonPath("$.message", is("Success")))
				.andExpect(jsonPath("$.response[0].id", is(1)))
				.andExpect(jsonPath("$.response[0].name", is("Open Recruit")))
				.andExpect(jsonPath("$.response[1].id", is(2)))
				.andExpect(jsonPath("$.response[1].name", is("Linux Recruit Pvt")));
		
	}

}
