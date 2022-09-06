package com.evaluacionusers.busines.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacionusers.busines.UserService;
import com.evaluacionusers.config.Properties;
import com.evaluacionusers.model.BackResponse;
import com.evaluacionusers.model.Data;
import com.evaluacionusers.model.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class UserServicesImpl implements UserService{
	
	@Autowired
	private Properties properties;
	
	@Override
	public Object postUser() {
		
		UserResponse response = new UserResponse();
		BackResponse responseBack = new BackResponse();

		try {
			StringBuilder str = new StringBuilder();
			str.append(properties.getUrl());

			System.out.println("user.getUrl :" + str.toString());

			URL url = new URL(str.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json; charset=utf-8");
			conn.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			conn.setDoOutput(true);
			StringBuffer sb = new StringBuffer();

			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

				try (BufferedReader reader = new BufferedReader(
						new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
					String line;

					while ((line = reader.readLine()) != null) {
						sb.append(line);
					}
					System.out.println("user.backresponse :" + sb.toString());
					ObjectMapper mapper = new ObjectMapper();
					responseBack = mapper.readValue(sb.toString(), BackResponse.class);

				}
			}
			List<String> datalist = new ArrayList<String>();
			for (Data d : responseBack.getData()) {
				String data = "";
				data = d.getId() + "|" + d.getLast_name() + "|" + d.getEmail();
				datalist.add(data);
			}

			response.setData(datalist);

		} catch (Exception e) {
			System.out.println("users.error :" + e);
		}
		return response;
	}

}
