import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KlassManager {
	private static KlassManager klassManager;
	private Map<String, Klass> klasses = new HashMap<String, Klass>();

	void addKlass(Klass klass) throws Exception {
		if (klasses.containsKey(klass.getKlassId())) {
			throw new Exception("Klass " + klass.getKlassId() + " already exists");
		}
		klasses.put(klass.getKlassId(), klass);
	}

	public static KlassManager getInstance() {
		if (klassManager == null) {
			klassManager = new KlassManager();
		}
		return klassManager;
	}

	public void registerStudentToKlass(Klass klass, String studentId) throws Exception {
		if (klasses.containsKey(klass.getKlassId())) {
			if (StudentManager.getInstance().isStudentRegistered(studentId)) {
				throw new Exception("Student " + studentId + " is already registerd");
			}
			klass.registerStudent(studentId);
		} else {
			throw new Exception("Klass " + klass.getKlassId() + " was not found");
		}
	}

	public void registerStudentToKlass(String klassId, String studentId) throws Exception {
		if (klasses.containsKey(klassId)) {
			if (StudentManager.getInstance().isStudentRegistered(studentId)) {
				throw new Exception("Student " + studentId + " is already registerd");
			}
			klasses.get(klassId).registerStudent(studentId);
		} else {
			throw new Exception("Klass " + klassId + " was not found");
		}
	}

	public void registerStudentToKlass(String klassId, List<String> students) throws Exception {
		if (klasses.containsKey(klassId)) {
			for (String student : students) {
				if (StudentManager.getInstance().isStudentRegistered(student)) {
					klasses.get(klassId).registerStudent(student);
					StudentManager.getInstance().getStudent(student).registerForKlass(klassId);
				}				
			}
		} else {
			throw new Exception("Klass " + klassId + " was not found");
		}
	}

	public List<String> getAllClasses() {
		List<String> allKlasses = new ArrayList<String>();
		allKlasses.addAll(klasses.keySet());
		return allKlasses;

	}
}
