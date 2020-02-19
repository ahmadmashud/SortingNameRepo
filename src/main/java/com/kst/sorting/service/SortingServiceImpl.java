package com.kst.sorting.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kst.sorting.model.ModelName;

@Service
public class SortingServiceImpl implements SortingService {

	@Override
	public List<ModelName> sortingLastNameAsc(MultipartFile filePath) {
		BufferedReader br;
		List<ModelName> result = new ArrayList<>();
		String line;
		try {
			
			InputStream is = filePath.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
//			mapping from txt to modelName
			while ((line = br.readLine()) != null) {
				ModelName obj = new ModelName();
				String firstName = "";
				String lastName = "";
				String[] fullName = line.split(" ");
				if (fullName.length > 1) {
//					if fullName more than one word, exclude last name
					for (int i = 0; i < fullName.length - 1; i++) {
						firstName = firstName + fullName[i];
					}
					lastName = fullName[fullName.length - 1];
				} else {
					lastName = fullName[0];
				}
				obj.setFirstName(firstName);
				obj.setLastName(lastName);
				result.add(obj);
			}
//			sorting
			result = sortingFunctionNameAsc(result); 			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<ModelName> sortingFunctionNameAsc(List<ModelName> data) {
		// TODO Auto-generated method stub
		 data.sort((ModelName m1, ModelName m2) -> m1.getLastName().compareTo(m2.getLastName()));
		 return data;
	}

}
