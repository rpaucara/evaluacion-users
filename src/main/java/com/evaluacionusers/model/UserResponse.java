package com.evaluacionusers.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {
	
	    @JsonProperty("data")
	    private List<String> data;

	    public List<String> getData() {
	        return data;
	    }

	    public void setData(List<String> data) {
	        this.data = data;
	    }
}
