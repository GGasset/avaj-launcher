import java.util.List;

public class Tower {
	private List<Flyable> observers;

	protected void conditionChanged()
	{
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
	}

	public void register(Flyable p_flyable)
	{
		observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable)
	{
		observers.remove(p_flyable);
	}

	public int getRegisteredCount() { 
		return observers.size();
	};
}
