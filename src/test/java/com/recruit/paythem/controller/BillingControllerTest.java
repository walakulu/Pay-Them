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
import com.recruit.paythem.dto.BillInfoDto;
import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.ResponseMessage;
import com.recruit.paythem.service.BillingService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BillingController.class, secure = false)
public class BillingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BillingService billingService;
	
 
	BillInfoDto masonIndividual,masonGroup,carpenterIndividual,carpenterGroup;
	
	@Test
	public void getMonthlyBillInfo() throws Exception {
		
		List<BillInfoDto> billInfoList=new ArrayList<BillInfoDto>();
		masonIndividual=new BillInfoDto.Builder()
				.withBillCatagory("Mason")
				.withRecruitCount(2)
				.withTotal(400)
				.isGroup(false)
				.build();
		
		masonGroup=new BillInfoDto.Builder()
				.withBillCatagory("Carpenter")
				.withRecruitCount(1)
				.withTotal(250)
				.isGroup(false)
				.build();
		carpenterIndividual=new BillInfoDto.Builder()
				.withBillCatagory("Mason")
				.withRecruitCount(1)
				.withTotal(220)
				.isGroup(true)
				.build();
		carpenterGroup=new BillInfoDto.Builder()
				.withBillCatagory("Carpenter")
				.withRecruitCount(0)
				.withTotal(0)
				.isGroup(true)
				.build();
		
		billInfoList.add(masonIndividual);
		billInfoList.add(masonGroup);
		billInfoList.add(carpenterIndividual);
		billInfoList.add(carpenterGroup);
		
		ResponseDto responseDto = new ResponseDto.Builder()
				.withMessageCode(ResponseMessage.SUCCESS.getCode())
				.withMessage(ResponseMessage.SUCCESS.getMessage())
				.withResponseObject(billInfoList)
				.build();
		
		Mockito.when(billingService.getMonthlyBillInfo(1, 6)).thenReturn(responseDto);
		
		mockMvc.perform(get("/billing/head-hunter/1/month/6").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.messageCode", is("S500"))).andExpect(jsonPath("$.message", is("Success")))
				.andExpect(jsonPath("$.response[0].billCatagory", is("Mason")))
				.andExpect(jsonPath("$.response[0].recruitCount", is(2)))
				.andExpect(jsonPath("$.response[0].total", is(400.0)))
				.andExpect(jsonPath("$.response[0].group", is(false)))
				.andExpect(jsonPath("$.response[1].billCatagory", is("Carpenter")))
				.andExpect(jsonPath("$.response[1].recruitCount", is(1)))
				.andExpect(jsonPath("$.response[1].total", is(250.0)))
				.andExpect(jsonPath("$.response[1].group", is(false)))
				.andExpect(jsonPath("$.response[2].billCatagory", is("Mason")))
				.andExpect(jsonPath("$.response[2].recruitCount", is(1)))
				.andExpect(jsonPath("$.response[2].total", is(220.0)))
				.andExpect(jsonPath("$.response[2].group", is(true)))
				.andExpect(jsonPath("$.response[3].billCatagory", is("Carpenter")))
				.andExpect(jsonPath("$.response[3].recruitCount", is(0)))
				.andExpect(jsonPath("$.response[3].total", is(0.0)))
				.andExpect(jsonPath("$.response[3].group", is(true)));
		
		

	}
}
