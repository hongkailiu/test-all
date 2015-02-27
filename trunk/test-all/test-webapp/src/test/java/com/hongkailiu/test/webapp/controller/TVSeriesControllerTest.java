package com.hongkailiu.test.webapp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hongkailiu.test.app.util.MathUtil;
import com.hongkailiu.test.webapp.proxy.DataProxy;
import com.hongkailiu.test.webapp.response.json.TVSeriesJsonResult;

/**
 * ref.
 * http://www.luckyryan.com/2013/08/24/unit-test-controllers-spring-mvc-test/
 * @author Liu
 *
 */
public class TVSeriesControllerTest {
	
	private static final Logger logger = Logger.getLogger(TVSeriesControllerTest.class);
	
	@Mock
	private DataProxy dataProxy;
	
	@InjectMocks
	//@Mock
    private TVSeriesController tvSeriesController;
	
	private MockMvc mockMvc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 // Process mock annotations
        MockitoAnnotations.initMocks(this);
 
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(tvSeriesController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllTVSeries() throws Exception {
		 when(dataProxy.getAllTVSeries()).thenReturn(getAllTVSeries());
		 
		//fail("Not yet implemented");
		MvcResult result = this.mockMvc.perform(get("/tvseries/all")
				.contentType(MediaType.APPLICATION_JSON)
	            //.param("email", "mvcemail@test.com")
	            //.param("firstName", "mvcfirst")
	            //.param("lastName", "mvclastname")
				)
				.andDo(print())
	            .andExpect(status().isOk())
	            .andReturn();
	            //.andExpect(forwardedUrl(IndexController.PAGE_INDEX))
	            //.andExpect(model().attributeExists("page_error"));
		logger.debug("result: "+ new String(result.getResponse().getContentAsByteArray()));
	}
	
	private List<TVSeriesJsonResult> getAllTVSeries() {
		List<TVSeriesJsonResult> list = new ArrayList<TVSeriesJsonResult>();
		TVSeriesJsonResult tvSeries = new TVSeriesJsonResult();
		tvSeries.setId(0);
		tvSeries.setName("game of thrones");
		tvSeries.setSeasonOnAir(3);
		tvSeries.setEpisodeOnAir(12);
		tvSeries.setEpisodeWatched(MathUtil.random(6));
		tvSeries.setSeasonWatched(3);
		tvSeries.setImageUrl("http://192.168.0.59:8080/test-webapp/i/got-" + MathUtil.random(2) + ".jpg" );
		list.add(tvSeries);
		tvSeries = new TVSeriesJsonResult();
		tvSeries.setId(1);
		tvSeries.setName("friends");
		tvSeries.setSeasonOnAir(10);
		tvSeries.setEpisodeOnAir(20);
		tvSeries.setEpisodeWatched(MathUtil.random(12));
		tvSeries.setSeasonWatched(6);
		tvSeries.setImageUrl("http://192.168.0.59:8080/test-webapp/i/friends-" + MathUtil.random(2) + ".jpg" );
		list.add(tvSeries);
		return list;
	}

}
