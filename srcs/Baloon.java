public class Baloon extends Aircraft {
	public Baloon(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
		type = "Balloon";
	}

	public void updateConditions()
	{
		int nLong, nLat, nHeight;
		nLong = coordinates.getLongitude();
		nLat = coordinates.getLatitude();
		nHeight = coordinates.getHeight();

		switch (weatherTower.getWeather(coordinates)) {
			case "SUN":
				nLong += 2;
				nHeight += 4;
				coordinates = new Coordinates(nLong, nLat, Math.min(nHeight, 100));
				logUpdate("What a nice day to fly High");
				break;
			case "RAIN":
				nHeight -= 5;
				coordinates = new Coordinates(nLong, nLat, Math.min(nHeight, 100));
				logUpdate("Goig down due to rain");
				break;
			case "FOG":
				nHeight -= 3;
				coordinates = new Coordinates(nLong, nLat, Math.min(nHeight, 100));
				logUpdate("Going down due to fog");
				break;
			case "SNOW":
				nHeight -= 15;
				coordinates = new Coordinates(nLong, nLat, Math.min(nHeight, 100));
				logUpdate("Going down quickly due to snow");
				break;
		
			default:
				break;
		};
		if (nHeight <= 0) { weatherTower.unregister(this); logUpdate("Landing"); }
	}
}
