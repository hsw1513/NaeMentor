package com.min.naementor.spring.comm;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class ProfileImg {
	
	
//	private static String attach_path = "C:\\nobrand\\WorkSpace_Spring\\NaeMentor\\src\\main\\webapp\\resource\\profileImg"; 
	// 절대경로
	
	private static String attach_path = "C:\\nobrand\\WorkSpace_Spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\NaeMentor\\resource\\profileImg";
	 // 상대경로							
	
	// 상대경로 = WS에서 관리하는 폴더 혹은 파일 => 상황에 따라 변경됨
	// 절대경로는 refresh 되기 S전까지 올라가지 않음, 상대경로는 배포가 자동으로 됨
	
	public static String saveFile(MultipartFile file) { // 절대경로, 상대경로 둘 다 가능함 
		// => 절대경로로 파일을 올리면 F5를 누를때까지 서버에서 못읽음, 상대경로는 저장이 안됨
		// 저장하려면 상대경로 절대경로 둘 다 필요 -> 미리보기는 상대경로, 업로드 하면 절대경로 하면 해결 -> API 이용해도 해결 가능하다
		
		// UUID를 통해 OriginalFileName <-> StoreFileName(UUID) 생성해서 파일명이 같아도 저장되는 이름은 다르게 함
		
		String saveName = file.getOriginalFilename(); // 우리가 나중에 UUID로 만들 stored name
		
		File f = new File(attach_path, saveName);
		File newf = new File(attach_path);
		if(!newf.exists()) {
			newf.mkdirs();
		}
		
		try {
			file.transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return saveName;
	}
	
}
