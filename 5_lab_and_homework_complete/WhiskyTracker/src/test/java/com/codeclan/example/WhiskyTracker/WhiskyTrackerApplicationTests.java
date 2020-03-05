package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void canGetWhiskiesForParticularYear(){
		List<Whisky> found = whiskyRepository.findWhiskysByYear(2018);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetAllDistilleriesForTheRegionOfSpeyside(){
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Speyside");
		assertEquals(2, found.size());
	}

	@Test
	public void canGetAllWhiskiesFromParticularDistilleryWithSpecificAge(){
		List<Whisky> found = whiskyRepository.findWhiskyByDistilleryIdAndAge((long) 1, 15);
		assertEquals(1, found.size());
	}

}
