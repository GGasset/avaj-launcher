
public class WeatherTower extends Tower {
	public WeatherProvider provider;

	public String getWeather(Coordinates p_coordinates)
	{
		return provider.getCurrentWeather(p_coordinates);
	}

	public void changeWeather()
	{
		provider.seed++;
		conditionChanged();
	}
}
