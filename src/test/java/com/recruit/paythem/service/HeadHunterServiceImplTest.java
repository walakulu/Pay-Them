package com.recruit.paythem.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.recruit.paythem.domain.HeadHunter;
import com.recruit.paythem.dto.HeadHunterDto;
import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.repository.HeadHunterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadHunterServiceImplTest {
	
	@Autowired
	private HeadHunterService headHunterService;
	
	@MockBean
	private HeadHunterRepository headHunterRepository;
	
	@Test
	public void testGetAllHeadHunters() throws Exception {
		List<HeadHunter> headHunterList=new ArrayList<>();
		List<HeadHunterDto> headHunterDtoList=new ArrayList<>();
		HeadHunter headHunter1=new HeadHunter();
		headHunter1.setId(1);
		headHunter1.setName("Open Recruit");
		HeadHunter headHunter2=new HeadHunter();
		headHunter2.setId(2);
		headHunter2.setName("Linux Recruit Pvt");
		headHunterList.add(headHunter1);
		headHunterList.add(headHunter2);
		headHunterList.stream().forEach(headHunter -> {
			HeadHunterDto headHunterDto = new HeadHunterDto.Builder()
					.withId(headHunter.getId())
					.withName(headHunter.getName())
					.build();
			headHunterDtoList.add(headHunterDto);
		});
		
		ResponseDto response=new ResponseDto.Builder().withResponseObject(headHunterDtoList).build();
		
		Mockito.when(headHunterRepository.findAll()).thenReturn(headHunterList);
		
		assertThat(headHunterService.getAllHeadHunters()).isEqualTo(response);
		
		
	}

}
