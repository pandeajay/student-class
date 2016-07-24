import java.util.BitSet;
import java.util.List;

public class Student {

	private BitSet registredKlasses;
	private String rollNumber;

	public Student(String rollNumber) {
		registredKlasses = new BitSet();
		registredKlasses.clear();
		this.rollNumber = rollNumber;
	}

	public void registerForKlass(Klass klass) {
		registredKlasses.set(klass.getIndex() - 1);
	}
	public void registerForKlass(String klass) {
		registredKlasses.set(Integer.parseInt(klass.substring(1, klass.length())));
	}

	public boolean isRegisteredForKlasses(List<String> klassList) {
		boolean isRegistered = true;
		for (String klass : klassList) {
			if (!registredKlasses.get(Integer.parseInt(klass.substring(1, klass.length())))) {
				isRegistered = false;
				break;
			}
		}
		return isRegistered;
	}

	public String getRollNumber() {
		return rollNumber;
	}

}
