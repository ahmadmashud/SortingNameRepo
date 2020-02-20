package com.kst.sorting.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kst.sorting.model.ModelName;
import com.kst.sorting.service.SortingService;
import com.kst.sorting.service.SortingServiceImpl;

public class TestNameSorting {
	
	SortingService sortingService;
	List<ModelName> listData = new ArrayList<ModelName>();
	ModelName nama1 = new ModelName();
	ModelName nama2 = new ModelName();
	ModelName nama3 = new ModelName();
	ModelName nama4 = new ModelName();
	
	@Before
	public void setUp() throws Exception {
		sortingService = new SortingServiceImpl();
		nama1.setFirstName("mashud");
		nama1.setLastName("xhaka");
		
		nama2.setFirstName("adi");
		nama2.setLastName("amir");

		nama3.setFirstName("ramgga");
		nama3.setLastName("baro");

		nama4.setFirstName("budi");
		nama4.setLastName("amir");
		
		listData.add(nama1);
		listData.add(nama2);
		listData.add(nama3);
		listData.add(nama4);

		System.out.println("before sorting : ");
		for (ModelName modelName : listData) {
			System.out.println(modelName.getFirstName()+" "+modelName.getLastName());
		}
	}

	@Test
	public void testSorting(){
		sortingService.sortingFunctionNameAsc(listData);
	}
	
	@After
	public void showData() throws Exception {
		System.out.println();
		System.out.println("after sorting : ");
		for (ModelName modelName : listData) {
			System.out.println(modelName.getFirstName()+" "+modelName.getLastName());
		}
	}
}
