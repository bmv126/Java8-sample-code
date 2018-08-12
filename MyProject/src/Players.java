import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Players {
	String name;
	String role;
	int age;
	double battingAvg;
	double bowlingAvg;
	int runs;
	
	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	private Players(String name, String role, int age, int runs, double battingAvg, double bowlingAvg) {
		super();
		this.name = name;
		this.role = role;
		this.age = age;
		this.runs = runs;
		this.battingAvg = battingAvg;
		this.bowlingAvg = bowlingAvg;
	}

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static String getPlayerName() {
		StringBuilder builder = new StringBuilder();
		int count=10;
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	public static Players generatePlayers() {
		List<String> playerRoles = Arrays.asList("batsman","bowler","wk");	
		String name = getPlayerName();
		String role = playerRoles.get(ThreadLocalRandom.current().nextInt(0,3)); 
		int age = ThreadLocalRandom.current().nextInt(20, 35);
		double battAvg = ThreadLocalRandom.current().nextDouble(20.00, 50.00);
		double bowlAvg = 0;		
		int runs = ThreadLocalRandom.current().nextInt(0, 15000);
		if(!role.equals("wk")){
			 bowlAvg = ThreadLocalRandom.current().nextDouble(15.00, 50.00);
		}
		return new Players(name,role,age,runs,battAvg,bowlAvg);
	}

	public boolean isWk() {
		return this.role.equals("wk");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(Float battingAvg) {
		this.battingAvg = battingAvg;
	}

	public Double getBowlingAvg() {
		return bowlingAvg;
	}

	public void setBowlingAvg(Float bowlingAvg) {
		this.bowlingAvg = bowlingAvg;
	}

	@Override
	public String toString() {
		return "Players [name=" + name + ", role=" + role + ", age=" + age + ", battingAvg=" + battingAvg
				+ ", bowlingAvg=" + bowlingAvg + ", runs=" + runs + "]";
	}

	

}