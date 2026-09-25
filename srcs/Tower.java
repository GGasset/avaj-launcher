import java.util.ArrayList;
import java.util.List;

public class Tower {
	private List<Flyable> observers;

	public Tower()
	{
		observers = new ArrayList<Flyable>();
	}

	protected void conditionChanged()
	{
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
	}

	public void register(Flyable p_flyable)
	{
		observers.add(p_flyable);

		System.out.printf("Tower says: ");
		((Aircraft)p_flyable).logUpdate("Registered to tower");
	}

	public void unregister(Flyable p_flyable)
	{
		observers.remove(p_flyable);

		
		System.out.printf("Tower says: ");
		((Aircraft)p_flyable).logUpdate("Unregistered from tower");
	}

	public int getRegisteredCount() { 
		return observers.size();
	};
}
