package com.min.naementor.spring.comm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.min.naementor.dtos.AttachFileDto;

@Component
public class AttachFile_Module {
	
	
	private String memberseq;
	private String adminseq;
	private AttachFileDto dto;

	// 이미지 미리보기
	@SuppressWarnings("unchecked")
	public JSONObject ckImgUpload(MultipartFile upload, HttpServletRequest request, HttpServletResponse resp) {
		String url = request.getContextPath()+"/img/";
		String rootPath = request.getRealPath("/img");
		System.out.println(rootPath);
		File file = new File(rootPath);
		String fileName = "";
		if(!file.exists()) { file.mkdir();	}
		int uploaded = 0;
		
		fileName = upload.getOriginalFilename();
		System.out.println(fileName);
		File f = new File(rootPath, fileName);
		try {
			upload.transferTo(f);
			uploaded++;
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject();
			obj.put("uploaded", uploaded);
			obj.put("url", url+fileName);
			obj.put("fileName", fileName);
		return obj;	
	}

	public List<AttachFileDto> attachFile(List<MultipartFile> files, HttpServletRequest request, HttpServletResponse resp) {
		List<AttachFileDto> lists = new ArrayList<AttachFileDto>();
		String url = request.getContextPath()+"/files/";
		String filepath = request.getRealPath("/files");
		System.out.println(url);
		File file = new File(url);
		if(!file.exists()) { file.mkdir();	}
		// 파일 넣기
		for (MultipartFile multipartFile : files) {
		
		String userfile = multipartFile.getOriginalFilename();
		String searchfile = UUID.randomUUID().toString() + userfile;
		String filesize ="" ;
		dto = new AttachFileDto();
		File f = new File(url, searchfile);
		boolean isc = false;
		try {
			filesize = String.valueOf(multipartFile.getSize());
			multipartFile.transferTo(f);
			isc = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(isc) {
		dto.setFilepath(url);
		dto.setFilesize(filesize);
		dto.setSearchfile(searchfile);
		dto.setUserfile(userfile);
		if(memberseq != null) {
			dto.setMemberseq(memberseq);
		}
		if(adminseq != null) {
			dto.setAdminseq(adminseq);
		}
		System.out.println(dto);
		lists.add(dto);
		}
		}
		return lists;
	}
	
	// 파일 다운로드
	public String fileDown(HttpServletResponse response, AttachFileDto dto) {
		// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
		byte fileByte[];
		try {
			fileByte = org.apache.commons.io.FileUtils.readFileToByteArray(new File(dto.getFilepath()+dto.getSearchfile()));
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(dto.getUserfile(), "UTF-8")+"\";");
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 파일 다운로드
	public String fileDown2(HttpServletResponse response, AttachFileDto dto) {
		// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
		FileInputStream in = null;
		ServletOutputStream out = null;
		
		// 파일을 객체화
		File file = new File(dto.getFilepath()+dto.getSearchfile());
		// 파일의 크기를 나눠서 읽을 수 있는 byte 크기로 변환함
		byte[] b = new byte[(int)(file.length())];
		// 응답해줄 객체 생성 (response의 헤더 정보를 변경해야 파일 다운로드로 인식)
		response.reset();	// 브라우져로 응답할 때 설정들을 초기화
		response.setContentType("multipart/byteranges");
		// MIME 설정 : (속성)/(타입) : text/html => 텍스트를/html로 | application/msword => 프로그램/워드파일
		// 한글 이름 깨짐을 방지 : 인코딩 설정 // 파일의 인코딩을 텍스트로 읽을 수 있는 인코딩으로 변환
		String encoding;
		try {
			encoding = new String(dto.getUserfile().getBytes("utf-8"),"8859_1");
			response.setHeader("Content-Disposition","attachment; filename="+encoding);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		// 브라우져 처리 => 파일 버튼을 클릭 시 다운로드를  저장화면이 출력되도록 만들기 
		// 헤더의 content-disposition에 attachment의 이름으로, encoding 설정을 해준 파일 이름을 설정
		// ------------------------------설정 끝
		try {
		in = new FileInputStream(file); // 파일을 읽어옴
		out = response.getOutputStream(); // 파일을 전송할 객체
		
		int numread = 0;
		// byte객체를 0부터 끝까지 가져옴
		while((numread=in.read(b, 0, b.length))!=-1) {
			out.write(b, 0, numread);
		}
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		try {
			out.flush();
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		return null;
	}
	
	
	

	public String getMemberseq() {
		return memberseq;
	}

	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}

	public String getAdminseq() {
		return adminseq;
	}

	public void setAdminseq(String adminseq) {
		this.adminseq = adminseq;
	}
	
	public AttachFileDto getDto() {
		return dto;
	}

	
}
