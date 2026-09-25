public class AircraftFactory {
	private static AircraftFactory instance = null;

	private long id = 0;
	private AircraftFactory() {}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{
		switch (p_type) {
			case "Helicopter":
				return new Helicopter(id++, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(id++, p_name, p_coordinates);
			case "Balloon":
				return new Baloon(id++, p_name, p_coordinates);
		
			default:
				return null;
		}
	}

	public static AircraftFactory getInstance() { if (instance == null) instance = new AircraftFactory(); return instance;}
}
