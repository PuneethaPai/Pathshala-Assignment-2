package com.tw.phs.WorldCup;

public class DateClass {
	String date;
	String venue;
	String match;
	Boolean played;
	Integer nofMatches=0;

	public DateClass(Boolean played,String date, String venue, String firstTeam) {
		this.date = date;
		this.played=played;
		this.venue = venue;
		match = firstTeam;
		nofMatches+=1;
	}

	public Integer getNofMatches() {
		return nofMatches;
	}

	public DateClass(Boolean played) {
		this.played = played;

	}

	public Boolean getPlayed() {
		return played;
	}

	public String getDate() {
		return date;
	}

	public String getVenue() {
		return venue;
	}

	public String getMatch() {
		return match;
	}
}
