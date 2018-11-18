package com.recruit.paythem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.ResponseMessage;
import com.recruit.paythem.exception.EntityNotFoundException;
import com.recruit.paythem.repository.RecruitmentRepository;
import com.recruit.paythem.service.RecruitmentService;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

	@Autowired
	private RecruitmentRepository recruitmentRepository;

	@Override
	public ResponseDto findRecruitmentDetails(int headHunterId, String group, int month) throws Exception {

		List<Map<String, Object>> recruitmentDetailList = recruitmentRepository.findRecruitmentDetails(headHunterId,
				group, month);
		if (CollectionUtils.isEmpty(recruitmentDetailList)) {
			throw new EntityNotFoundException(ResponseMessage.DATA_NOT_FOUND_FOR_GIVEN_PARAM.getMessage());

		}
		return new ResponseDto.Builder().withResponseObject(recruitmentDetailList).build();
	}

}
