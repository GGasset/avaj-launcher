public class WeatherProvider {
	private String[] weather;
	public int seed;

	private WeatherProvider()
	{

	}

	String getCurrentWeather(Coordinates p_coordinates)
	{
		int weather = seed * p_coordinates.getLongitude() + p_coordinates.getLatitude();
		weather = weather % 4;

		switch (weather) {
			case 0:
				return "SUN";
			case 1:
				return "RAIN";
			case 2:
				return "FOG";
			case 3:
				return "SNOW";
		
			default:
				return "SUN";
		}
	}
}
