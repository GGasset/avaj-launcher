import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class avaj
{

	private static boolean isNumericalString(String s)
	{
		boolean output = true;
		for (int i = 0; i < s.length() && output; i++) {
			output = output && ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '\n');
			
		}
		return output;
	}

	private static Flyable parseLine(String line)
	{
		//System.out.println("bfrr");

		String[] lData = line.split(" ");

		//System.out.println("bfrr");


		if (lData.length != 5) return null;

		//System.out.println("bfr");
		if (!isNumericalString(lData[2]) || !isNumericalString(lData[3]) || !isNumericalString(lData[4])) return null;
		//System.out.println("aftr");


		AircraftFactory aerospaceFactory = AircraftFactory.getInstance();

		
		Flyable aircraft = aerospaceFactory.newAircraft(lData[0], lData[1], new Coordinates(Integer.parseInt(lData[2]), Integer.parseInt(lData[3]), Integer.parseInt(lData[4])));
		return aircraft;
	}

	public static void main(String[] argv)
	{
		if (argv.length != 1)
		{
			System.out.println("Usage: java program [aircrafts file]");
			return;
		}

		WeatherTower tower = new WeatherTower();
		tower.provider = WeatherProvider.getInstance();

		List<String> file_lines = null;

		try {
			file_lines = Files.readAllLines(Path.of(argv[0]));
		} catch (Exception e) {
			System.out.println("Unable to read input file.");
			return; 
		}

		PrintStream simulationStream = null;

		try {
			File f = new File("simulation.txt");
			f.createNewFile();
			simulationStream = new PrintStream(f);
		} catch (Exception e) {
			System.out.println("Unable to create simulation.txt");
			if (simulationStream != null) simulationStream.close();
			return ;
		}

		int nSimulations = 0;

		List<Flyable> aircrafts = new ArrayList<Flyable>();

		boolean isFirst = false;
		for (String line : file_lines)
		{
			System.setOut(System.out);
			if (isFirst == false)
			{
				if (!isNumericalString(line))
				{
					System.out.printf("Error parsing line \"%s\".\n", line);
					simulationStream.close();
					return;
				}
				nSimulations = Integer.parseInt(line);
				isFirst = true;
				continue;
			}

			Flyable f = parseLine(line);

			if (f == null) { System.out.printf("Error parsing line \"%s\".\n", line); simulationStream.close();; return; }

			aircrafts.add(f);
		}

		System.setOut(simulationStream);
		for (int i = 0; i < aircrafts.size(); i++)
			aircrafts.get(i).registerTower(tower);

		while (nSimulations > 0)
		{
			tower.changeWeather();

			nSimulations--;
		}
		simulationStream.flush();
		simulationStream.close();
	}
}
