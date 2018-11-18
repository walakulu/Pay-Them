package com.recruit.paythem.service;

import com.recruit.paythem.dto.ResponseDto;

public interface RecruitmentService {
	
	ResponseDto findRecruitmentDetails(int headHunterId, String group,int month) throws Exception;

}
