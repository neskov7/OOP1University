package university;

public class University {
	private String name;
	private Rector rector;
	private Studente[] students;
	private final int ID_BASE=1000; //numero base da cui partono le matricole
	private final int MAX_students=1000; // numero students massimo
	private int numstudents=-1; //numero studentui effettivi
	private final int IDSUBJECT_BASE=10; //id minimo per le materie
	private Subject[] subjects;
	private final int MAX_SUBJECTS=50; //numero materie massimo
	private int numSubjects=-1; //numero materie effettivo
	
	public University(String name){
		this.name=name;
		students= new Studente[MAX_students];
		subjects= new Subject[MAX_SUBJECTS];
	}
	
	public String getName(){
		
		return name;
	}
	
	public void setRector(String first, String last){
		rector=new Rector(first,last);
	}
	
	public String getRector(){
		
		return rector.getName()+" " + rector.getSurname();
	}
	
	public int enroll(String first, String last){
		students[++numstudents]= new Studente(first,last,ID_BASE+numstudents);		
		return (numstudents+ID_BASE);
	}
	
	public String student(int id){
		id-=ID_BASE;
		return students[id].getID()+" "+students[id].getName()+" "+students[id].getSurname();
	}
	
	public int activate(String title, String teacher){
		subjects[++numSubjects]= new Subject(title, teacher, numSubjects+IDSUBJECT_BASE);
		return numSubjects+IDSUBJECT_BASE;
	}
	
	public String course(int code){
		code-=IDSUBJECT_BASE;
		return subjects[code].getID()+" " + subjects[code].getTitle()+" " + subjects[code].getTeacher();
	}
	
	public void register(int studentsID, int courseCode){
		studentsID-=ID_BASE; courseCode-=IDSUBJECT_BASE;
		try{
			students[studentsID].tryAddingCourses();
			subjects[courseCode].subscription(studentsID);
			students[studentsID].subcription(courseCode);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("activate failed");
			}
	}
	
	public String listAttendees(int courseCode){
		StringBuilder sb= new StringBuilder();
		int[] students = this.subjects[courseCode].getStudents();
		for(int i=0; i<students.length;i++){
			
		}
		return null;
//		return subjects[courseCode-IDSUBJECT_BASE].getStudents();
	}

	public String studyPlan(int studentsD){
		//TODO: to be implemented
		return null;
	}
}
