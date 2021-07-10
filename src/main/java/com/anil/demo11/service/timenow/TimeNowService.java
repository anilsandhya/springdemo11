package com.anil.demo11.service.timenow;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

@Service
public class TimeNowService implements ITimeNow {

	@Override
	public String getTime() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat now = new SimpleDateFormat("h:mm aa");
		System.out.println(now.format(date));
		String currenttime = now.format(date);
		return currenttime;
	}

}
