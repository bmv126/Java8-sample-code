import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyClass {
	public static void main(String[] args) {		
		Team australia = Team.createTeam("australia", 1);
		Team india = Team.createTeam("india", 4);
		Team pakistan = Team.createTeam("pakistan", 6);
		Team england = Team.createTeam("england", 5);
		Team newzealand = Team.createTeam("newzealand", 3);
		Team southafrica = Team.createTeam("southafrica", 2);

		List<Players> australiaPlayer = new ArrayList();
		List<Players> indiaPlayer = new ArrayList();
		List<Players> pakistanPlayer = new ArrayList();
		List<Players> englandPlayer = new ArrayList();
		List<Players> newzealandPlayer = new ArrayList();
		List<Players> southAfricaPlayer = new ArrayList();

		for (int i = 0; i < 25; i++) {
			australiaPlayer.add(Players.generatePlayers());
			indiaPlayer.add(Players.generatePlayers());
			pakistanPlayer.add(Players.generatePlayers());
			englandPlayer.add(Players.generatePlayers());
			newzealandPlayer.add(Players.generatePlayers());
			southAfricaPlayer.add(Players.generatePlayers());
		}

		australia.setPlayer(australiaPlayer);
		india.setPlayer(indiaPlayer);
		pakistan.setPlayer(pakistanPlayer);
		england.setPlayer(englandPlayer);
		newzealand.setPlayer(newzealandPlayer);
		southafrica.setPlayer(southAfricaPlayer);

		australia.displayTeamPlayers();
		india.displayTeamPlayers();
		pakistan.displayTeamPlayers();
		england.displayTeamPlayers();
		newzealand.displayTeamPlayers();
		southafrica.displayTeamPlayers();

		// Find all players in india, who are specialists in wicketKeeping
		india.getPlayer().stream().filter(pl -> pl.getRole().equals("wk")).forEach(pl -> System.out.println(pl.name));

		// Find count of players in australia, who have runs > 7000
		System.out.println(australia.getPlayer().stream().filter(pl -> pl.getRuns() > 7000).count());

		// Find all players in pakistan, whose name starts with M
		pakistan.getPlayer().stream().filter(pl -> pl.getName().startsWith("M")).forEach(pl -> System.out.println(pl.name));

		// Find if any player in newzealand has name starting with A
		System.out.println(newzealand.getPlayer().stream().anyMatch(pl ->pl.getName().startsWith("A")));

		// Using Collectors.toList
		List<Players> engPlayerFiltered = england.getPlayer().stream().filter(pl -> pl.getRuns() > 14000)
				.collect(Collectors.toList());
		engPlayerFiltered.stream().forEach(System.out::println);

		// Same query using Collectors.toCollection
		List<Players> engPlayerFiltered1 = england.getPlayer().stream().filter(pl -> pl.getRuns() > 14000)
				.collect(Collectors.toCollection(ArrayList::new));
		engPlayerFiltered1.stream().forEach(System.out::println);

		// Trying to create a hashMap
		england.getPlayer().stream().map(pl -> new HashMap<String, Integer>() {
			{
				put(pl.getName(), new Integer(pl.getRuns()));
			}
		}).forEach(System.out::println);

		// Using flatMap to get list of players in India and Australia
		Stream.of(india.getPlayer(), australia.getPlayer()).flatMap(pl -> pl.stream()).collect(Collectors.toList())
				.forEach(System.out::println);

		// Find the player with minimum run using min and minBy
		System.out.println("\npakistan player with minimum runs");
		System.out.println(pakistan.getPlayer().stream().min(Comparator.comparing(Players::getRuns)).get());
		System.out.println(pakistan.getPlayer().stream()
				.collect(Collectors.minBy(Comparator.comparing(Players::getRuns))).get());

		// Total runs of the entire NewZealand Squad using sum and reduce
		int sumOfRuns = newzealand.getPlayer().stream().map(Players::getRuns).reduce(0, (sum, ele) -> sum + ele);
		System.out.println("sum by reduce " + sumOfRuns);
		System.out.println("sum by sum() "+newzealand.getStream()
				  .mapToInt(pl -> pl.getRuns())
				  .sum());
		
		// PartitionBy 
		System.out.println(pakistan.getStream().collect(Collectors.partitioningBy(Players::isWk)));

		// Using GroupingBy
		System.out.println(
				pakistan.getStream().collect(Collectors.groupingBy(Players::getRole, Collectors.counting())));

		// Mapping role to player names
		System.out.println(pakistan.getStream().collect(Collectors.groupingBy(Players::getRole,
				Collectors.mapping(Players::getName, Collectors.toList()))));	
		
		//Find bowler in SouthAfrica with batting avg greater than 30.00
		southafrica.getStream()
		           .filter(pl -> (pl.getRole().equals("bowler") && pl.getBattingAvg() > 30.00))
		           .forEach(pl -> System.out.println("name is "+pl.getName()));
	}
}
