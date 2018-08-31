package com.example.AdminService;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)//lib which creates mock obj
	public class AdminControllerTest {
		
		private MockMvc mockMvc;//have predefined mtds to test
		
		@InjectMocks   // injecting here
		private AdminController AdminController;
		
		@Mock  //we are taking obj of it not injecting here.... but just using
		private AdminService AdminService;

		@Before
		public void setUp()
		{
			mockMvc = MockMvcBuilders.standaloneSetup(AdminController).build();
		}
		
		@Test
		public void testAdminService() throws Exception
		{
			//Mockito.when(AdminService.getByName(categoryName)) 
			//.thenReturn("Hello World");             //when this mtd is called then o/p will be ...
			
			mockMvc.perform(MockMvcRequestBuilders.get("/validateAdmin/{username}/{password}"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("admin"));//comparing here
		}
		
		@Test
		public void testGetHello() throws Exception
		{
		  mockMvc.perform(MockMvcRequestBuilders.get("/validateAdmin/{username}/{password}"))
		  .andExpect(MockMvcResultMatchers.status().isOk())
		  .andExpect(MockMvcResultMatchers.content().string("admin"));	
		}
		
		/*@Test
		public void testJsonGetUser() throws Exception
		{
			  mockMvc.perform(MockMvcRequestBuilders.get("/validateAdmin/{username}/{password}"))
			  .andExpect(MockMvcResultMatchers.status().isOk())
			  .andExpect(jsonPath("$.name", Matchers.is("John")))
			  .andExpect(jsonPath("$.title", Matchers.is("Mr")))
			  .andExpect(jsonPath("$.age", Matchers.is(22)))
			  .andExpect(jsonPath("$.*", Matchers.hasSize(3)));
			  
		}
		
		@Test
		public void testJsonPostUser() throws Exception
		{
			String jsonInput = "{\"name\":\"sam\",\"title\":\"Ms\",\"age\":30}";
			
			mockMvc.perform(MockMvcRequestBuilders.post("/post/user"))
			  .andExpect(MockMvcResultMatchers.status().isOk())
			  .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(MockMvcResultMatchers.content().json(jsonInput))
			  .andExpect(jsonPath("$.name", Matchers.is("sam")))
			  .andExpect(jsonPath("$.title", Matchers.is("Ms")))
			  .andExpect(jsonPath("$.age", Matchers.is(30)))
			  .andExpect(jsonPath("$.*", Matchers.hasSize(3)));
			
					}*/
	}


