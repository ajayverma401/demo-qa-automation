package com.ajay.automation.utils;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ConfiReaderUtils {

	private static Map<String, Object> config;

	static {

		try(InputStream inputStream = ConfiReaderUtils.class.getClassLoader().getResourceAsStream("TestData/Config.yml")){
			if(inputStream == null) {
				throw new RuntimeException("config.yml file not found on it path");

			}
			Yaml yml = new Yaml();
			config = yml.load(inputStream);

		}

		catch(Exception e) {
			throw new RuntimeException("Failed to load config.yml due to:" + e.getMessage());

		}


	}

	public static String get(String key) {
		return config.get(key).toString();
	}


}
