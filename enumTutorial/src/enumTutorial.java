public class enumTutorial {
	public enum Planets{
		Earth(1,2), Jupiter(2,3),Mars(3,4);

		private int x,y;
		Planets(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String args[]){
		Planets myPlanet = Planets.Earth;
		System.out.println(myPlanet);
		System.out.println(myPlanet.name());
		System.out.println(myPlanet.ordinal());
		System.out.println(myPlanet.x);
		myPlanet = Planets.Jupiter;
		System.out.println(myPlanet);
		System.out.println(myPlanet.name());
		System.out.println(myPlanet.ordinal());
		System.out.println(myPlanet.y);
		myPlanet = Planets.Mars;
		System.out.println(myPlanet);
		System.out.println(myPlanet.name());
		System.out.println(myPlanet.ordinal());
		System.out.println(myPlanet.y);

	}
}
