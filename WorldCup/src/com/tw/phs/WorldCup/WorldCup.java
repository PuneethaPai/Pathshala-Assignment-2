package com.tw.phs.WorldCup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WorldCup {
	private static String[] teamsList ={"Australia","India","Pakistan","England","South Africa","New Zealand","Sri Lanka","West Indies"};
	static HashMap<String,Team> teamObjectMap =new HashMap<>();
	private static ArrayList<String> venues =new ArrayList<>();
	public static ArrayList<DateClass> allDates=new ArrayList<DateClass>();
	public static HashMap<String,Venue> venueObjectMap =new HashMap<>();
	private static ArrayList<String> combinationSet = new ArrayList<String>();
	public WorldCup(){
		setupTeams();
		getAllCombinatins();
		setupVenues();
		for(int i=0;i<8;i++){
			Collections.shuffle(combinationSet);
			Collections.shuffle(venues);
		}
	}
	public ArrayList<DateClass> getAllDates() {
		return allDates;
	}

	private void setupVenues() {
		venues.add("Perth");
		venues.add("Brisbane");
		venues.add("Adelaide");
		venueObjectMap.put("Perth",new Venue("Perth"));
		venueObjectMap.put("Brisbane",new Venue("Brisbane"));
		venueObjectMap.put("Adelaide",new Venue("Adelaide"));

	}

	public HashMap<String, Venue> getVenueObjectMap() {
		return venueObjectMap;
	}

	public void Proceed()throws ParseException {
		int count=0;
		int combiCount=0;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = formatter.parse("2015-1-1");
		Date endDate = formatter.parse("2015-2-23");
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
			if((count%2==0||count==51)&&combiCount< combinationSet.size()){
				allDates.add(new DateClass(true,new SimpleDateFormat("MM-dd-yyyy").format(date), combinationSet.get(combiCount), venues.get(count%3)));
				System.out.format("%s%30s%30s",new SimpleDateFormat("MM-dd-yyyy").format(date)+"\t", combinationSet.get(combiCount), venues.get(count%3)+"\n");
				venueObjectMap.get(venues.get(count%3)).AddFixture(date);

				combiCount+=1;
			}
			else {
				System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(date)+"\t");
				allDates.add(new DateClass(false));
			}
			count+=1;
		}
		FinalMatches(count);
	}

	private static void FinalMatches(int count) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date FinalstartDate = formatter.parse("2015-02-25");
		Date FinalendDate = formatter.parse("2015-03-02");
		Calendar start = Calendar.getInstance();
		start.setTime(FinalstartDate);
		Calendar end = Calendar.getInstance();
		end.setTime(FinalendDate);
		for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 2), date = start.getTime()) {
			System.out.format("%s%30s%30s",new SimpleDateFormat("MM-dd-yyyy").format(date)+"\t","Semi Final 1","at "+ venues.get(count%3)+"\n");
			allDates.add(new DateClass(true,new SimpleDateFormat("MM-dd-yyyy").format(date),"Semi Final", venues.get(count%3)));
			count+=1;
		}
	}

	private static void getAllCombinatins() {
		for (Map.Entry<String,Team> entry : teamObjectMap.entrySet())
			{
				HashMap<String,Boolean>PlayedSet=entry.getValue().getPlayed();
				for (Map.Entry<String,Boolean> entryto :PlayedSet.entrySet()){
					if(entryto.getValue()==false){
						entryto.setValue(true);
						HashMap<String,Boolean>OtherTeam= teamObjectMap.get(entryto.getKey()).getPlayed();
						OtherTeam.replace(entry.getKey(),false,true);
						combinationSet.add(entry.getKey()+" Vs "+entryto.getKey());
					}
				}

			}
	}
	public boolean CheckForContineousMatchesOnSmeVenue() throws ParseException {
		boolean b=false;
		HashMap<String,Venue> venues=venueObjectMap;
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
				if(b==true){
					return true;
				}
			}

		}
		return false;
	}

	public boolean NotMoreThanThreeMAtchesADay(){
		for (DateClass day: allDates
				) {
			if(day.getNofMatches()>3){
				return true;
			}
		}
		return false;
	}
	public boolean checkNotMoreThanFourIdleDays(){
		int nullcount=0;
		for(DateClass day:allDates){
			if(day.played==false){
				nullcount +=1;
			}else {
				nullcount=0;
			}
		}
		if(nullcount<4){
			return false;
		}else {
			return true;
		}
	}
	private static void setupTeams(){
		for(String t : teamsList){
			Team team= new Team(t);
			teamObjectMap.put(t,team);
		}
	}
}
