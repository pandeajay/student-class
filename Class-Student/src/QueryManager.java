import java.util.ArrayList;
import java.util.List;

public class QueryManager {

	private static QueryManager queryManager;
	StudentManager studentManager = StudentManager.getInstance();
	KlassManager klassManager = KlassManager.getInstance();

	public static QueryManager getInstance() {
		if (queryManager == null) {
			queryManager = new QueryManager();
		}
		return queryManager;
	}

	public List<String> findCommonStudentToKlass(List<String> klasses) {
		List<String> commonStudent = new ArrayList<String>();
		List<Student> allStudents = studentManager.getAllStudent();
		for (Student student : allStudents) {
			if (student.isRegisteredForKlasses(klasses)) {
				commonStudent.add(student.getRollNumber());
			}
		}
		return findPairs(commonStudent);
	}

	public void findCommonStudentToAllPairsOfKlasses() {

		List<String> allKlasses = klassManager.getAllClasses();
		for (String klass1 : allKlasses) {
			
			for (String klass2 : allKlasses) {
				if(klass1.equals(klass2) ){
						continue;
				}
				if(allKlasses.indexOf(klass2) < allKlasses.indexOf(klass1)){
					//ensure that no pair repeats
					continue;
				}
				List<String> commonStudent = new ArrayList<String>();
				List<Student> allStudents = studentManager.getAllStudent();
				for (Student student : allStudents) {
					List<String> klassPairs = new ArrayList<String>();
					klassPairs.add(klass1);
					klassPairs.add(klass2);
					if (student.isRegisteredForKlasses(klassPairs)) {
						commonStudent.add(student.getRollNumber());
					}
				}
				
				//print the results for pair
				System.out.println(" For " + klass1 + "-"+ klass2 + " students pair is {"+ findPairs(commonStudent)+"}");
				System.out.println("");
				
			}
		}
	}

	private List<String> findPairs(List<String> collection) {
		List<String> pairs = new ArrayList<String>();
		for (String record1 : collection) {
			for (String record2 : collection) {
				if(record1.equals(record2)) {
					continue;
				}
				if(collection.indexOf(record2) < collection.indexOf(record1)){
					continue;
				}
				pairs.add("(" + record1 + "," + record2 + ")");
			}
		}
		return pairs;

	}
}
