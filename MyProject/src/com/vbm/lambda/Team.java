package com.vbm.lambda;
import java.util.List;
import java.util.stream.Stream;

class Team {

	List<Players> player;
	String name;
	int ranking;
	
	private Team(String name, int ranking) {
		this.name = name;
		this.ranking = ranking;
	}
	
	public static Team createTeam(String name, int ranking) {
		return new Team(name,ranking);
	}
	
	public void addPlayer(Players pl) {
		player.add(pl);
	}
	
	public void displayTeamPlayers() {
		System.out.println("team name "+name);
		player.stream()
			  .forEach(pl -> System.out.println(pl));
		System.out.println("=======================================");
	}
	
	@Override
	public String toString() {
		return "Team [player=" + player + ", name=" + name + ", ranking=" + ranking + "]";
	}
	
	public List<Players> getPlayer() {
		return player;
	}
	
	public void setPlayer(List<Players> players) {
		this.player = players;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getRanking() {
		return ranking;
	}
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public Stream<Players> getStream(){
		return getPlayer().stream();
	}
}
