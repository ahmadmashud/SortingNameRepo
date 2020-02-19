package com.kst.sorting.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.kst.sorting.model.ModelName;
import com.kst.sorting.service.SortingService;

@Controller
public class controller {
	
	@Autowired
	SortingService sortingService;
	
	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		return "index";
	}

	@RequestMapping(value = "/proses", method = RequestMethod.POST, headers = "content-type=multipart/*")
	public @ResponseBody ResponseEntity<Object>  sort(@RequestParam("filePath") MultipartFile filePath) throws IOException {
			List<ModelName> result = new ArrayList<ModelName>();
		try {
			result = sortingService.sortingLastNameAsc(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
}
