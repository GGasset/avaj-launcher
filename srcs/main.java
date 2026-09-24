import java.io.File;
import java.io.PrintStream;

class avaj
{
	private static Flyable parseLine(String line)
	{
		return null;
	}

	public static void main(String[] argv)
	{
		WeatherTower tower = new WeatherTower();
		tower.provider = WeatherProvider.getInstance();

		AircraftFactory aerospace_factory = AircraftFactory.getInstance();

		try {
			String[] file_lines = null;
			
		} catch (Exception e) {
			System.out.print("Unable to read input file.");
			return; 
		}

		try {
			File f = new File("simulation.txt");
			f.createNewFile();
			System.setOut(new PrintStream(f));
		} catch (Exception e) {
			System.out.print("Unable to create simulation.txt");
			return ;
		}

		while (tower.getRegisteredCount() > 0)
		{
			tower.changeWeather();
		}
	}
}
