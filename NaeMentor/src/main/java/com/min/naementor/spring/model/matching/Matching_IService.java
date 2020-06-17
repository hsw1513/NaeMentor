package com.min.naementor.spring.model.matching;

import java.util.List;

import com.min.naementor.dtos.MatchingDto;

public interface Matching_IService {
	
	/**
	 * 매칭 정보 가져오기
	 * @param boardseq
	 * @return MatchingDto
	 */
	public MatchingDto chkMatching(String boardseq);
	/**
	 * 매칭 정보가 있는지 조회
	 * @param boardseq
	 * @return boolean(매칭 정보 없음)
	 */
	public boolean chkMatchingCount(String boardseq);
}
