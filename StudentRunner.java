
import java.util.ArrayList;
import java.util.StringTokenizer;


//Класс для осуществления операций с ArrayList и объектами Student
class Gen extends StudentGenerator {
	//Метод для генерации заданного количества студентов
	public void greateDataBase(ArrayList<Student> dataBase,int num) {

		for (int i=0; i < num; i++) {
			Student obj1 = new Student();
			obj1.setId(generateId());
			obj1.setName(generateName());
			obj1.setSecondName(generateSecondName());
			obj1.setSurname(generateSurname());
			obj1.setDateOfBirth(generateDateOfBirth());
			obj1.setPhone(generatePhoneNumber());
			obj1.setAdress(generateAdress());
			obj1.setInstitute(generateInstitute());
			obj1.setDepartment(generateDepartments());
			obj1.setCourse(generateCourse());
			dataBase.add(i, obj1);
		}
	}
	//Метод для генерации заданного количества студентов,
	//но с заданными пользователем полями "институт",
	//"факультет", и "курс"

	public void greateDataBase(ArrayList<Student> dataBase, int num, Classmates obj) {

		for (int i=0; i < num; i++) {
			Student obj1 = new Student();
			obj1.setId(generateId());
			obj1.setName(generateName());
			obj1.setSecondName(generateSecondName());
			obj1.setSurname(generateSurname());
			obj1.setDateOfBirth(generateDateOfBirth());
			obj1.setPhone(generatePhoneNumber());
			obj1.setAdress(generateAdress());
			obj1.setInstitute(obj.getInstitute());
			obj1.setDepartment(obj.getDepartment());
			obj1.setCourse(obj.getCourse());
			dataBase.add(i, obj1);

		}
	}
	
 	
//Класс для поиска одногрупников среди студентов
	}
	
class Classmates {
	private String institute;
	private String department;
	private int course;

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public String getInstitute() {
		return institute;
	}

	public String getDepartment() {
		return department;
	}

	public int getCourse() {
		return course;
	}
}
	 class OperationOnObjects {

		//Метод выводит в консоль список студентов заданного факультета
		public static void departmentList(String department, ArrayList<Student> dataBase) {
			System.out.println(department);
			int num = 0;

			for (int i=0; i < dataBase.size()-1; i++) {
				if (dataBase.get(i).getDepartment().equals(department)) {
					System.out.println(dataBase.get(i).getName()+" "+
									   dataBase.get(i).getSurname());
					num++;
				}
			}
			if (num == 0) {
				System.out.println("Данного факультета не существует");
			}
		}
		//Метод выводит в консоль список студентов для каждого факультета
		public static void allDepartmentList(ArrayList<Student> dataBase) {
			//Для упрощения задачи сортируем массив по значению "факультет"
			sort(dataBase, "факультет");
			showData(dataBase);

			String department = dataBase.get(0).getDepartment();
			System.out.println(department);
			for (int i=0; i < dataBase.size(); ) {
				System.out.println(dataBase.get(i).getName()+" "+
								   dataBase.get(i).getSurname());
				i++;
				if (i == dataBase.size()) {
					break;
				}
				if (!dataBase.get(i).getDepartment().equals(department)) {
					department = dataBase.get(i).getDepartment();
					System.out.println(department);
				}
			}
		}
		//Метод выводит в консоль список студентов для каждого курса
		public static void allCourseList(ArrayList<Student> dataBase) {
			//Для упрощения задачи сортируем массив по значению "курс"
			sort(dataBase, "курс");

			int course = dataBase.get(0).getCourse();
			System.out.println("Студенты "+course+"го "+"курса");
			for (int i=0; i < dataBase.size(); ) {
				System.out.println(dataBase.get(i).getName()+" "+
								   dataBase.get(i).getSurname());
				i++;
				if (i == dataBase.size()) {
					break;
				}
				if (course != dataBase.get(i).getCourse()) {
					course = dataBase.get(i).getCourse();
					System.out.println("Студенты "+course+"го "+"курса");
				}
			}
		}
		//Метод для сортировки массива по различным критериям(например "курс")
		public static void sort (ArrayList<Student> dataBase, String criterion) {
			if (criterion.equalsIgnoreCase("факультет")) {
				for (int i=0; i < dataBase.size(); i++) {
					for (int j=0; j < dataBase.size(); j++) {
						char[] a = dataBase.get(i).getDepartment().toCharArray();
						char[] b = dataBase.get(j).getDepartment().toCharArray();
						boolean next = true;
						int l = 0;
						do {
							if (a[l] == b[l]) {
								l++;
							}
							if (a[l] < b[l]) {
								Student obj = dataBase.get(i);
								dataBase.set(i, dataBase.get(j));
								dataBase.set(j, obj);
								next = false;
							}
							if (a[l] > b[l]) {
								next = false;
							}
							if (l == a.length-1) {
								next = false;
							}
						} while(next);
					}
				}
			}

			if (criterion.equalsIgnoreCase("курс")) {
				for (int i=0; i < dataBase.size(); i++) {
					for (int j=0; j < dataBase.size(); j++) {
						if (dataBase.get(i).getCourse() < 
							dataBase.get(j).getCourse()) {
							Student obj = dataBase.get(i);
							dataBase.set(i, dataBase.get(j));
							dataBase.set(j, obj);
						}
					}
				}
			}
		}
		//Метод для вывода в консоль списка студентов родившихся после заданного года
		public static void dateOfBirthList(ArrayList<Student> dataBase, int year) {
			System.out.println("Студенты родившиеся после "+year+" года");
			for (int i=0; i < dataBase.size(); i++) {
				int date = getIntDateOfBirth(dataBase.get(i).getDateOfBirth(), "год");
				if (date > year) {
					System.out.println(dataBase.get(i).getName()+" "+
									   dataBase.get(i).getSurname());
				}
			}
		}
		//Метод для вывода в консоль списка студентов одной учебной группы
		//в качестве аргумента передаем Classmatter obj который содержит поля
		//для поиска студентов по одному институту, факультету и группе
		public static void groupList(ArrayList<Student> dataBase, Classmates obj) {
			System.out.println("Список учебной группы");
			for (int i=0; i < dataBase.size(); i++) {
				if (dataBase.get(i).getDepartment().equalsIgnoreCase(obj.getDepartment()) &&
					dataBase.get(i).getInstitute().equalsIgnoreCase(obj.getInstitute()) &&
					dataBase.get(i).getCourse() == obj.getCourse()) {
					System.out.println(dataBase.get(i).getName()+" "+
									   dataBase.get(i).getSurname());
				}
			}
		}
		//Метод выводит в консоль список студентов со всеми данными
		public static void showData(ArrayList<Student> dataBase) {
			for (int i=0; i<dataBase.size(); i++) {
				Student obj1 = new Student();
				obj1 = dataBase.get(i);
				System.out.println(obj1.toString());
			}
		}
		//Метод для получения целочисленного значения года рождения
		public static int getIntDateOfBirth(String dateOfBirth, String criterion) {
			int date = 0;
			StringTokenizer getDate = new StringTokenizer(dateOfBirth, ".");
			String[] d = new String[getDate.countTokens()];
			for (int i=0; i < d.length; i++) {
				d[i] = getDate.nextToken();
			}

			if (criterion.equalsIgnoreCase("день")) {
				date = Integer.parseInt(d[0]);
			}

			if (criterion.equalsIgnoreCase("месяц")) {
				date = Integer.parseInt(d[1]);
			}

			if (criterion.equalsIgnoreCase("год")) {
				date = Integer.parseInt(d[2]);
			}
			return date;
		}
	}

	public class StudentRunner {
		
	public static void main(String[] args) {
		
		Gen obj = new Gen();
		//Создаем массив
		ArrayList<Student> dataBase = new ArrayList<>();

		//Вносим в массив 10 случайных студентов
		obj.greateDataBase(dataBase,10);
		//obj.showData(dataBase);
		//Отображаем список студентов заданного факультета
		OperationOnObjects.departmentList("Факультет летательных аппаратов",dataBase);
		//Отображаем список студентов для каждого факультета
		OperationOnObjects.allDepartmentList(dataBase);
		//Отображаем список студентов для каждого курса
		OperationOnObjects.allCourseList(dataBase);
		//Отображаем список студентов родившихся после заданного года
		OperationOnObjects.dateOfBirthList(dataBase, 1992);

		//Создаем класс для введению или поиска одногрупников в массив
		Classmates classmates = new Classmates();
		classmates.setDepartment("Факультет летательных аппаратов");
		classmates.setInstitute("Институт информационно-диагностических систем");
		classmates.setCourse(1);
		//Добавляем в массив еще 10 студентов одногрупликов
		obj.greateDataBase(dataBase,10,classmates);
		OperationOnObjects.sort(dataBase, "факультет");
		OperationOnObjects.showData(dataBase);
		//Выводим список учебной группы
		OperationOnObjects.groupList(dataBase, classmates);
	}
}
