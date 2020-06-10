package com.min.naementor.spring.model.matching;

import java.util.List;

import com.min.naementor.dtos.MatchingDto;

public interface Matching_IDao {
	/**
	 * 매칭 정보 가져오기
	 * @param boardseq
	 * @return MatchingDto
	 */
	public MatchingDto chkMatching(String boardseq);
}