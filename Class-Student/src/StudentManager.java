import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManager {

	static StudentManager studentManager;
	private Map<String, Student> students = new HashMap<String, Student>();

	public void addStudent(Student student) throws Exception {
		if (students.containsKey(student.getRollNumber())) {
			throw new Exception(" Student " + student.getRollNumber() + " is already present");
		}
		students.put(student.getRollNumber(), student);
	}

	public static StudentManager getInstance() {
		if (studentManager == null) {
			studentManager = new StudentManager();
		}
		return studentManager;
	}

	public boolean isStudentRegistered(String rollNumber) {
		return students.containsKey(rollNumber);

	}

	public Student getStudent(String rollNumber) {
		return students.get(rollNumber);
	}

	public List<Student> getAllStudent() {
		List<Student> allStudent = new ArrayList<Student>();
		allStudent.addAll(students.values());
		return allStudent;

	}
}
