package com.ticiano.customermanager.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProjectInfo {

	@Value("${project.version}")
	private String version;
	
	public String getSystemVersion() {
		return version;
	}
	
	
}
