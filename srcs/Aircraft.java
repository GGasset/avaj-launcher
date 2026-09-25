public abstract class Aircraft extends Flyable
{
	protected long id;
	protected String name;
	protected String type;
	protected Coordinates coordinates;
	
	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate)
	{
		id = p_id;
		name = p_name;
		coordinates = p_coordinate;
	}

	protected void logUpdate(String msg)
	{
		System.out.printf("%s#%s(%d): %s.\n", type, name, id, msg);
	}
}
