package com.min.naementor.spring.model.capcha;

import java.io.InputStream;
import java.net.HttpURLConnection;

public interface Capcha_IService {
	

	
	/**
	 * attach에 따라 key나 사용자의 입력값과의 비교결과를 반환함
	 * 0 입력시 이미지 key 반환
	 * 1&key = 받아온 key 값 & value = 사용자가 입력한 값 => 비교
	 * @param apiURL 뒤에 붙일값
	 * @return JSON 형태의 결과 값
	 */
	public String get(String attach);
	
	/**
	 * 네이버와 통신을 해 결과 값을 받아옴
	 * @param 완성된 apiUrl
	 * @return 서버 통신 결과
	 */
	public HttpURLConnection connect(String apiUrl);
	
	/**
	 * connect 실행을 통한 서버 통신 결과를 바탕으로 key 혹은 입력비교 결과를 가져옴
	 * @param body
	 * @return JSON 형태의 결과 값
	 */
	public String readBody(InputStream body);
	
	
	
}
