package com.tw.phs.WorldCup;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by surajus on 9/11/16.
 */
public class Venue {
	ArrayList<Date> fixtures=new ArrayList<>();
	String VenueName;

	public Venue(String venueName) {
		VenueName = venueName;
	}

	public ArrayList<Date> getFixtures() {
		return fixtures;
	}
	public void AddFixture(Date date)
	{
		fixtures.add(date);
	}
}
