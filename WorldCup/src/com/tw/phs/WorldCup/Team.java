package com.tw.phs.WorldCup;

import java.util.HashMap;

class Team {
	private String name;

	public HashMap<String, Boolean> getPlayed() {
		return played;
	}

	private static String[] TeamsList={"Australia","India","Pakistan","England","South Africa","New Zealand","Sri Lanka","West Indies"};
	private HashMap<String,Boolean> played=new HashMap<String, Boolean>();

	public String getName() {
		return name;
	}

	Team(String name) {
		this.name = name;

		createPlayedRecord();
	}

	private void createPlayedRecord() {
			for(String te: TeamsList){
				if(te!=this.name){
					played.put(te,false);
				}

			}
	}
}
