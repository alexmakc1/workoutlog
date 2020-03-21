
public class WeakDecorator extends ArmourSpecs{
	int boost = 5;
	public WeakDecorator(Armour type) {
		super(type);
		System.out.println(" and it is weak");
	}
	
	@Override
	public void wear() {
		
		
	}

	
}
