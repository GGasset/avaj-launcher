public class WeatherProvider {
	private static WeatherProvider inst = null;

	private String[] weather;
	public int seed;

	private WeatherProvider()
	{
		seed = 0;
	}

	String getCurrentWeather(Coordinates p_coordinates)
	{
		int weather = seed * p_coordinates.getLongitude() + p_coordinates.getLatitude();
		if (p_coordinates.getHeight() > weather % 40 + 60 && weather % 8 >= 4) return "SUN";

		switch (weather % 4) {
			default:
			case 0:
				return "SUN";
			case 1:
				return "RAIN";
			case 2:
				return "FOG";
			case 3:
				return "SNOW";
		
		}
	}

	public  static WeatherProvider getInstance() {  if (inst == null) inst = new WeatherProvider();  return inst; }
}
