package com.tw.psh.WorldCupTest;

import com.tw.phs.WorldCup.Venue;
import com.tw.phs.WorldCup.WorldCup;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertFalse;


public class WorldCupTest {
	@Test
	public void CheckForMoreThanThreeMatchedPerDay() throws ParseException {
		WorldCup icc=new WorldCup();
		icc.Proceed();
		assertFalse(icc.NotMoreThanThreeMAtchesADay());
	}

	@Test
	public void CheckForContineousMatchesOnTheSameVenue() throws ParseException {
		WorldCup icc=new WorldCup();
		icc.Proceed();
		assertFalse(icc.CheckForContineousMatchesOnSmeVenue());
	}

	@Test
	public void CheckForNoGapForFourDays() throws ParseException {
		WorldCup icc=new WorldCup();
		icc.Proceed();
		assertFalse(icc.checkNotMoreThanFourIdleDays());
	}

}
