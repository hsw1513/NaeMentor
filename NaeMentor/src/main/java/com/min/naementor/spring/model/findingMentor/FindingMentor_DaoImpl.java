package com.min.naementor.spring.model.findingMentor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.MatchingDto;
import com.min.naementor.dtos.NaememberDto;
@Repository
public class FindingMentor_DaoImpl implements FindingMentor_IDao{
	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.min.naementor.findingmentor.";
	
	@Override
	public FindingMentorDto detailContent(Map<String, String> map) {
		return session.selectOne(NS+"detailContent", map);
	}

	@Override
	public boolean applyMentor(Map<String, String> map) {
		return session.update(NS+"applyMentor", map)>0?true:false;
	}

	@Override
	public boolean applyMentorChk(Map<String, String> map) {
		int i = Integer.parseInt(session.selectOne(NS+"applyMentorChk", map));
		return i==0?true:false;
	}

	@Override
	public boolean reportCntUpdate(Map<String, String> map) {
		return session.update(NS+"reportCntUpdate", map)>0?true:false;
	}

	@Override
	public boolean reportUserUpdate(Map<String, String> map) {
		return session.update(NS+"reportUserUpdate", map)>0?true:false;
	}

	@Override
	public boolean reportContentChk(Map<String, String> map) {
		String val = session.selectOne(NS+"reportContentChk", map);
		return val.equals("0");
	}

	@Override
	public boolean insertContent(FindingMentorDto dto) {
		boolean isc = true;
		// 유효성 검사
		String level = dto.getMenteelevel();
		if(level.equals("L") || level.equals("M") || level.equals("H")) {}else {isc = false;}
		System.out.println("----1-----"+ isc);
		String howto = dto.getHowto();
		if(howto.equals("Y") || howto.equals("N")) {}else {isc = false;}
		System.out.println("----2-----"+ isc);
		String loc = dto.getLocation();
		if(loc.length() > 1 && loc.length() <20) {
			if(loc.indexOf("<script>") != -1) {
				loc = loc.replaceAll("<script>", "&lt;script>");
				loc = loc.replaceAll("</script>", "&lt;/script>");
				dto.setLocation(loc);
			}
		}else { isc = false; }
		System.out.println("----3-----"+ isc);
		String special = dto.getSpecialfield();
		if(special.equals("엑셀") || special.equals("파워포인트") || special.equals("워드,한글(문서)") ||
				special.equals("웹개발") || special.equals("앱개발") || special.equals("워드프레스") ||
				special.equals("C++") || special.equals("C언어") || special.equals("Java") ||
				special.equals("C#") || special.equals("ASP") || special.equals("Delphi") ||
				special.equals("ASP.NET") || special.equals("Javascript") || special.equals("HTML.CSS") ||
				special.equals("XML") || special.equals("Python") || special.equals("기타프로그래밍") 
				) {}else {isc = false;}
		System.out.println("----4-----"+ isc);
		String t = dto.getTarget();
		if(t.equals("실무") || t.equals("취업")||t.equals("자격증") 
				|| t.equals("취미")||t.equals("교육")) {}else {isc = false;}
		System.out.println("----5-----"+ isc);
		String title = dto.getTitle();
		if(title.length() > 2 && title.length() <20) {
			if(title.indexOf("<script>") != -1) {
				title = title.replaceAll("<script>", "&lt;script>");
				title = title.replaceAll("</script>", "&lt;/script>");
				dto.setTitle(title);}
		}else { isc = false; }
		System.out.println("----6-----"+ isc);
		String c = dto.getContent();
		if(c.indexOf("<script>") != -1) {
			c = c.replaceAll("<script>", "&lt;script>");
			c = c.replaceAll("</script>", "&lt;/script>");
			dto.setContent(c);}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String date = dto.getMentoringdate().substring(0, 8);
		Date date1 = new Date();
		Date cDate = null;
		try {
			cDate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(cDate.compareTo(date1) == -1) {
			System.out.println(date1);
			System.out.println(cDate);
			isc = false;}
		System.out.println("----7-----"+ isc);
		if(isc) {
			return session.insert(NS+"insertContent", dto)>0?true:false;
		}else {
			return false;
		}
	}

	@Override
	public FindingMentorDto modifyContentSelect(Map<String, String> map) {
		return session.selectOne(NS+"modifyContentSelect", map);
	}

	@Override
	public boolean modifyContent(FindingMentorDto dto) {
		return session.update(NS+"modifyContent", dto)>0?true:false;
	}

	@Override
	public boolean deleteContent(Map<String, String> map) {
		return session.update(NS+"deleteContent", map)>0?true:false;
	}

	@Override
	public boolean multidelContent(Map<String, String[]> map) {
		return session.update(NS+"multidelContent", map)>0?true:false;
	}

	@Override
	public boolean matching(MatchingDto dto) {
		return session.insert(NS+"matching", dto)>0?true:false;
	}

	@Override
	public List<FindingMentorDto> selectAll() {
		return session.selectList(NS+"selectAll");
	}

	@Override
	public List<NaememberDto> chkUser(Map<String, String[]> map) {
		return session.selectList(NS+"chkUser", map);
	}

	@Override
	public boolean updateMatching(String boardseq) {
		return session.update(NS+"updateMatching", boardseq)>0?true:false;
	}

	@Override
	public List<FindingMentorDto> chkMatching(Map<String,String> map) {
		return session.selectList(NS+"chkMatching", map);
	}

	@Override
	public List<FindingMentorDto> chkComplete(Map<String,String> map) {
		return session.selectList(NS+"chkComplete", map);
	}

	@Override
	public boolean updateComplete(String boardseq) {
		return session.update(NS+"updateComplete", boardseq)>0?true:false;
	}

	@Override
	public boolean updateNoMatching(String boardseq) {
		return session.update(NS+"updateNoMatching", boardseq)>0?true:false;
	}

}
