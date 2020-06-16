package com.min.naementor.spring.comm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.min.naementor.dtos.ReviewDto;

@Component
public class FindingMentor_MakeArrayList {

	public List<String> convertReviewList(List<ReviewDto> lists) {
		List<String> list = new ArrayList<String>();
		String review = null;
		String content = null;
		String wirtedate = null;
		String memseq = null;
		list.add("<table class='table table-bordered'>");
		list.add("<thead><tr><th>후기내용</th><th>작성일</th><th>별점</th></tr></thead><tbody>");
	    
		for (ReviewDto dto : lists) {
			review = "<tr>";
			content = "<td>"+dto.getContent()+"</td>";
			wirtedate ="<td>"+ dto.getWritedate()+"</td>";
			if(dto.getMenteestar()!=null) {
				memseq = "<td>"+dto.getMenteestar()+"</td>";
			}else {
				memseq = "<td>"+dto.getMentorstar()+"</td>";
			}
			review = review +content +wirtedate+memseq+"</tr>";
			list.add(review);
		}
		list.add("</tbody></table>");
		return list;
	}
}
