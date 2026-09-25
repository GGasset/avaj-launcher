public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
		type = "Helicopter";
	}

	public void updateConditions()
	{
		int nLong, nLat, nHeight;
		nLong = coordinates.getLongitude();
		nLat = coordinates.getLatitude();
		nHeight = coordinates.getHeight();

		switch (weatherTower.getWeather(coordinates)) {
			case "SUN":
				nLong += 10;
				nHeight += 2;
				coordinates = new Coordinates(nLong, nLat, Math.min(nHeight, 100));
				logUpdate("No clouds in view, nice weather.");
				break;
			case "RAIN":
				nLat += 5;
				coordinates = new Coordinates(nLong, nLat, nHeight);
				logUpdate("In the rain. Going North!");
				break;
			case "FOG":
				nLat += 1;
				coordinates = new Coordinates(nLong, nLat, nHeight);
				logUpdate("Too much Fog. Going North!");
				break;
			case "SNOW":
				nHeight -= 15;
				coordinates = new Coordinates(nLong, nLat, Math.min(nHeight, 100));
				logUpdate("Snow Storm approaching. Descending!");
				break;
		
			default:
				break;
		};
		if (nHeight <= 0) {  logUpdate("Landing"); weatherTower.unregister(this); }
	}
}
