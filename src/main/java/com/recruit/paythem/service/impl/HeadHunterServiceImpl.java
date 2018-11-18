package com.recruit.paythem.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.recruit.paythem.domain.HeadHunter;
import com.recruit.paythem.dto.HeadHunterDto;
import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.ResponseMessage;
import com.recruit.paythem.exception.EntityNotFoundException;
import com.recruit.paythem.repository.HeadHunterRepository;
import com.recruit.paythem.service.HeadHunterService;

@Service
public class HeadHunterServiceImpl implements HeadHunterService {

	@Autowired
	private HeadHunterRepository headHunterRepository;

	@Override
	public ResponseDto getAllHeadHunters() throws Exception {
		List<HeadHunterDto> headHunterDtoList;
		List<HeadHunter> headHunterList = headHunterRepository.findAll();

		if (CollectionUtils.isEmpty(headHunterList)) {
			throw new EntityNotFoundException(ResponseMessage.NO_HEAD_HUNTERS.getMessage());

		} else {
			headHunterDtoList = new ArrayList<>();
			headHunterList.stream().forEach(headHunter -> {
				HeadHunterDto headHunterDto = new HeadHunterDto.Builder()
						.withId(headHunter.getId())
						.withName(headHunter.getName())
						.build();
				headHunterDtoList.add(headHunterDto);
			});
		}
		return new ResponseDto.Builder().withResponseObject(headHunterDtoList).build();

	}

}
