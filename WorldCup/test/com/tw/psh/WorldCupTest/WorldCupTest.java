package com.tw.psh.WorldCupTest;

import com.tw.phs.WorldCup.DateClass;
import com.tw.phs.WorldCup.Venue;
import org.junit.Test;
import com.tw.phs.WorldCup.WorldCup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class WorldCupTest {
	@Test
	public void CheckForMoreThanThreeMatchedPerDay() throws ParseException {
		WorldCup icc=new WorldCup();
		icc.Proceed();
		ArrayList<DateClass> calender=icc.getAllDates();
		for (DateClass day: calender
			 ) {
			 assertTrue(day.getNofMatches()<3);
		}
	}

	@Test
	public void CheckForContineousMatchesOnTheSameVenue() throws ParseException {
		WorldCup icc=new WorldCup();
		icc.Proceed();
		boolean b=false;
		HashMap<String,Venue> venues=icc.getVenueObjectMap();
		for(Map.Entry<String,Venue> entry:venues.entrySet()){
			ArrayList<Date> fixtures=entry.getValue().getFixtures();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date StartDate = formatter.parse("2014-12-30");
			Calendar lastdate=Calendar.getInstance();
			lastdate.setTime(StartDate);
			for (Date fix :fixtures
				 ) {
				Calendar date = Calendar.getInstance();
				date.setTime(fix);
				lastdate.add(Calendar.DATE, 1);
				System.out.print(lastdate.get(Calendar.DAY_OF_YEAR)+" "+date.get(Calendar.DAY_OF_YEAR));
				b = lastdate.get(Calendar.YEAR) == date.get(Calendar.YEAR) &&
						lastdate.get(Calendar.DAY_OF_YEAR) == date.get(Calendar.DAY_OF_YEAR);
				assertFalse(b);
			}

		}
	}

	@Test
	public void CheckForNoGapForFourDays() throws ParseException {
		WorldCup icc=new WorldCup();
		icc.Proceed();
		int nullCount=0;
		ArrayList<DateClass> calender=icc.getAllDates();
		for (DateClass day: calender
				) {
			if(day.getPlayed()==false){
				nullCount+=1;
			}else {
				nullCount=0;
			}
			assertTrue(nullCount<4);
		}
	}

}
