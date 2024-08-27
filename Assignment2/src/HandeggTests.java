import hw2.Handegg;
public class HandeggTests {

	public static void main(String[] args) {
		
		Handegg game = new Handegg();
		
		game = new Handegg();
		
		System.out.println(game.whichDown());
		System.out.println("Expected 1");
		System.out.println(game.getYardsToFirstDown());
		System.out.println("Expected 10");
		game.run(-4);
		System.out.println(game.whichDown());
		System.out.println("Expected 2");
		System.out.println(game.getYardsToFirstDown());
		System.out.println("Expected 14");
		game.run(9);
		System.out.println(game.whichDown());
		System.out.println("Expected 3");
		System.out.println(game.getYardsToFirstDown());
		System.out.println("Expected 5");
		game.run(20);
		System.out.println(game.whichDown());
		System.out.println("Expected 1");
		System.out.println(game.getYardsToFirstDown());
		System.out.println("Expected 10");
		
	}

}
