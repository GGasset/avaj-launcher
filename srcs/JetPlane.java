public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_oordinate)
	{
		super(p_id, p_name, p_oordinate);
		type = "JetPlane";
	}

	public void updateConditions()
	{
		int nLong, nLat, nHeight;
		nLong = coordinates.getLongitude();
		nLat = coordinates.getLatitude();
		nHeight = coordinates.getHeight();

		switch (weatherTower.getWeather(coordinates)) {
			case "SUN":
				nLat += 10;
				nHeight += 2;
				coordinates = new Coordinates(nLong, nLat, Math.min(nHeight, 100));
				logUpdate("No clouds in sight. Climbing");
				break;
			case "RAIN":
				nLat += 5;
				coordinates = new Coordinates(nLong, nLat, Math.min(nHeight, 100));
				logUpdate("I could just go over the rain..");
				break;
			case "FOG":
				nLat += 1;
				coordinates = new Coordinates(nLong, nLat, Math.min(nHeight, 100));
				logUpdate("Going inside the fog. I could fly over it..");
				break;
			case "SNOW":
				nHeight -= 7;
				coordinates = new Coordinates(nLong, nLat, Math.min(nHeight, 100));
				logUpdate("In the snow! Instead of flying over the snow I have to descend!");
				break;
			default:
				break;
		};
		if (nHeight <= 0) { weatherTower.unregister(this); logUpdate("Landing"); }
	}
}
