package com.kst.sorting.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kst.sorting.model.ModelName;

public interface SortingService {
	List<ModelName> sortingLastNameAsc(MultipartFile filePath);
	
	List<ModelName> sortingFunctionNameAsc(List<ModelName> data);
}
