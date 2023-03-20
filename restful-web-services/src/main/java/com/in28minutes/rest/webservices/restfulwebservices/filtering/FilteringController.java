package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1", "value1", "value1");
		
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

		
		
//		Geriya qaytarmaq istediyimiz filterler
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
//		Geriya qaytarilacaq Json ucun filterin elave olunmasi
		mappingJacksonValue.setFilters(filters );
		
		
		
		
		return mappingJacksonValue;
	}

//	@GetMapping("/filtering-list")
//	public List<SomeBean> filteringList() {
//		return Arrays.asList(new SomeBean("value1", "value1", "value1"), new SomeBean("value4", "value5", "value6"));
//	}

	@GetMapping("/filtering-list") //field2, field3
	public MappingJacksonValue filteringList() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2", "value3"),
				new SomeBean("value4","value5", "value6"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		mappingJacksonValue.setFilters(filters );
		
		
		return mappingJacksonValue;
	}
	
	
	
}
