package com.min.naementor.spring.comm;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class SplitUserComm {

	public String[] splitId(String userList) {
		String[] aa = null;
//		String bb = "0,,1,,2,,3,";
		aa = userList.split(",");
//		aa = bb.split(",");
//		System.out.println(Arrays.toString(aa));
//		for (int i = 0; i < aa.length; i++) {
//			System.out.println(aa[i]);
//		}
		return aa;
	}
//	public static void main(String[] args) {
//		splitId("aaa");
//	}
}
