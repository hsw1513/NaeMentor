package com.min.naementor.spring.model.capcha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "gotKey")
public class CapchaGetKey implements Capcha_IService {
	
	private String clientId = "N9nXoUFXIe10HTnjzjXC"; //애플리케이션 클라이언트 아이디값";
    private String clientSecret = "JjAU7DDGV3"; //애플리케이션 클라이언트 시크릿값";
    private String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=";
    private Map<String, String> requestHeaders = new HashMap<String, String>();
	
    //캡차 이미지 Key를 받아오기
	@Override
	public String get(String attach) { 
		// 0이면 이미지 키 받아오기, 1이면 유저가 입력한 값과 비교하기
		HttpURLConnection con = connect(apiURL+attach);
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		// 키 받아오기
				try {
					for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
						con.setRequestProperty(header.getKey(), header.getValue());
					}
					int responseCode = con.getResponseCode();
					if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
						return readBody(con.getInputStream());
					} else { // 에러 발생
						return readBody(con.getErrorStream());
					}
				}catch (IOException e) {
					throw new RuntimeException("API 요청과 응답 실패", e);
				}finally {
					con.disconnect();
				}
	}

		//url 넘겨서 서버 연동 결과 받기
		@Override
		public HttpURLConnection connect(String apiUrl) {
			try {
				URL url = new URL(apiUrl);
				return (HttpURLConnection)url.openConnection();
			}catch (MalformedURLException e) {
				throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
			} catch (IOException e) {
				throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
			}
		}
		
		//결과 통해서 key 받아오기
		@Override
		public String readBody(InputStream body){
			InputStreamReader streamReader = new InputStreamReader(body);

			try (BufferedReader lineReader = new BufferedReader(streamReader)) {
				StringBuilder responseBody = new StringBuilder();

				String line;
				while ((line = lineReader.readLine()) != null) {
					responseBody.append(line);
				}
				return responseBody.toString();
			} catch (IOException e) {
				throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
			}
		}

}
