
interface Generator {

	int generateId();
}
interface GenetatorHumans extends Generator {

	String generateName();

	String generateSecondName();

	String generateSurname();

	String generateAdress();
}
interface GeneratorStudents extends GenetatorHumans {

	String generatePhoneNumber();

	String generateDateOfBirth();

	String generateInstitute();

	String generateDepartments();

	int generateCourse();
}
interface GeneratorCustomers extends GenetatorHumans {

	String generateCreditCardNum();

	String generateBancAccountNum();
}

interface GeneratorPatients extends GenetatorHumans {

	String generateMedicalCardNum();

	String generatePhoneNumber();

	String generateDiagnosis();
}

interface GneratorAbiturient extends GenetatorHumans {

	String generateMarks();

	String generatePhoneNumber();

}

interface GeneratorBooks extends Generator {
	
	String generateName();
	
	String generateAutor();
	
	String generatePublishing();
	
	int generatePublishingYear();
	
	int generateNumOfPages();
	
	int generatePrice();
	
	String generateTypeOfBinding();
	
}

interface GeneratorGems extends Generator {
	
	int generateWeight();
	
}
	class StudentGenerator implements GeneratorStudents {
		private String[] mansFirstName = {"Александр", "Максим", "Иван", "Артём", "Никита", "Дмитрий", "Егор", "Даниил",
				"Михаил", "Андрей", "Алексей", "Илья", "Кирилл", "Сергей", "Владислав", "Роман", "Владимир", "Тимофей",
				"Матвей", "Георгий", "Николай", "Павел", "Арсений", "Денис", "Степан", "Фёдор", "Данила", "Антон",
				"Константин", "Глеб", "Ярослав", "Григорий", "Игорь", "Евгений", "Тимур", "Руслан", "Пётр", "Олег",
				"Вадим", "Василий", "Вячеслав", "Виктор", "Юрий", "Артемий", "Леонид", "Давид", "Марк", "Лев", "Семён",
				"Артур"};
		private String[] surname = {"Иванов", "Васильев", "Петров",
				"Смирнов", "Михайлов", "Фёдоров", "Соколов", "Яковлев", "Попов", "Андреев", "Алексеев", "Александров",
				"Лебедев", "Григорьев", "Степанов", "Семёнов", "Павлов", "Богданов", "Николаев", "Дмитриев", "Егоров",
				"Волков", "Кузнецов", "Никитин", "Соловьёв", "Тимофеев", "Орлов", "Афанасьев", "Филиппов", "Сергеев",
				"Захаров", "Матвеев", "Виноградов", "Кузьмин", "Максимов", "Козлов", "Ильин", "Герасимов", "Марков",
				"Новиков", "Морозов"};
		private String[] secondName = {"Александрович", "Адамович", ",Анатольевич", "Аркадьевич", "Алексеевич",
				"Андреевич", "Артемович", "Альбертович", "Антонович", "Богданович", "Богуславович", "Борисович",
				"Вадимович", "Васильевич", "Владимирович", "Валентинович", "Вениаминович", "Вячеславович", "Валерьевич",
				"Викторович", "Геннадиевич", "Георгиевич", "Геннадьевич", "Григорьевич", "Давидович", "Денисович",
				"Данилович", "Дмитриевич", "Евгеньевич", "Егорович", "Ефимович", "Иванович", "Ильич", "Игоревич",
				"Иосифович", "Кириллович", "Константинович", "Леонидович", "Львович", "Макарович", "Максович",
				"Миронович", "Максимович", "Матвеевич", "Михайлович", "Натанович", "Наумович", "Николаевич", "Олегович",
				"Оскарович", "Павлович", "Петрович", "Платонович", "Робертович", "Ростиславович", "Рудольфович",
				"Романович", "Рубенович", "Русланович", "Святославович", "Сергеевич", "Степанович", "Семенович",
				"Станиславович", "Тарасович", "Тимофеевич", "Тимурович", "Федорович", "Феликсович", "Филиппович",
				"Харитонович", "Эдуардович", "Эмануилович", "Эльдарович", "Юрьевич", "Юхимович", "Яковлевич",
				"Ярославович"};
		private String[] mounth = {"Января", "Февраля", "Марта", "Мая", "Апреля", "Июня", "Июля", "Августа", "Сентября",
				"Октября", "Ноября", "Декабря"};
		private int code[] = {39, 50, 63, 66, 67, 68, 91, 92, 93, 94, 95, 96, 97, 98, 99};
		private String[] streets = {"Академика Курчатова", "Академика Павлова", "Академика Панкратовой",
				"Академика Филатова", "Албанская", "Александра Матросова", "Балашева", "Балковский", "Балтская дорога",
				"Балышевa", "Баранова", "Бассейная", "Глухая", "Гогелевская", "Гоголя", "Головковская", "Гончарова",
				"Днепропетровская", "Днестровская", "Добролюбова", "Довженко", "Доковая", "Долгая", "Долинская",
				"Донецкая"};
		private String[] institutes = {"Институт информационно-диагностических систем",
				"Аэрокосмический институт", "Институт аэрокосмических систем управления",
				"Институт экологической безопасности", "Институт экономики и менеджмента",
				"Юридический институт", "Институт доуниверситетской подготовки",
				"Гуманитарный Институт", "Институт ICAO", "Институт заочного и дистанционного обучения",
				"Институт новейших технологий", "Институт последипломного обучения",
				"Институт землеустройства и информационных технологий", "Институт международных отношений",
				"Житомирский военный институт им.С.П.Королева", "Институт аэронавигации", "Институт аэропортов"};
		private String[] departments = {"Факультет летательных аппаратов", "Факультет лингвистики",
				"Факультет психологии и социологии", "Факультет авиационных транспортных технологий",
				"Факультет экономики и предпринимательства", "Факультет менеджмента и логистики",
				"Факультет электроники", "Факультет аэрокосмических систем управления",
				"Факультет информационных технологий", "Факультет телекоммуникаций и защиты информации",
				"Факультет компьютерных наук", "Факультет компьютерных систем",
				"Факультет международных экономических отношений", "Факультет международной информации и права",
				"Факультет аэропортов", "Факультет архитектуры и дизайна", "Факультет экологической безопасности"};

		public String generateName() {
			String name = mansFirstName[(int) (Math.random() * mansFirstName.length)];
			return name;
		}

		public String generateSecondName() {
			String name = secondName[(int) (Math.random() * secondName.length)];
			return name;
		}

		public String generateSurname() {
			String name = surname[(int) (Math.random() * surname.length)];
			return name;
		}

		public String generateDateOfBirth() {
			String day;
			String mounths;
			int m = (int) (Math.random() * 11) + 1;
			if (m < 10) {
				mounths = "0" + String.valueOf(m);
			} else {
				mounths = String.valueOf(m);
			}
			int d;

			if (m == 2) {
				d = (int) (Math.random() * 28) + 1;
			} else {
				d = (int) (Math.random() * 30) + 1;
			}
			if (d < 10) {
				day = "0" + String.valueOf(d);
			} else {
				day = String.valueOf(d);
			}
			int y = (int) (Math.random() * 10) + 1988;
			String year = String.valueOf(y);
			String date = day + "." + mounths + "." + year;
			return date;
		}

		public String generatePhoneNumber() {
			String code = String.valueOf(this.code[(int) (Math.random() * this.code.length)]);
			String num = String.valueOf((int) (Math.random() * 9000000) + 1000000);
			String phoneNumber = "0" + code + " " + num;
			return phoneNumber;
		}

		public String generateAdress() {
			int apartment = (int) (Math.random() * 98) + 1;
			int streetNum = (int) (Math.random() * 38) + 1;
			String street = "Ул. " + streets[(int) (Math.random() * streets.length)] + " " + streetNum + " Кв. " + apartment;
			return street;
		}

		public String generateInstitute() {
			String institute = institutes[(int) (Math.random() * institutes.length)];
			return institute;
		}

		public String generateDepartments() {
			String department = departments[(int) (Math.random() * departments.length)];
			return department;
		}

		public int generateCourse() {
			int course = (int) (Math.random() * 6) + 1;
			return course;
		}

		public int generateId() {
			int id = (int) (Math.random() * 90000000) + 10000000;
			return id;
		}
	}

	class BookGernerator extends StudentGenerator implements GeneratorBooks {
		private String[] books = {"Властелин колец", "Гордость и предубеждение", "Тёмные начала",
			"Автостопом по галактике", "Гарри Поттер и Кубок огня", "Убить пересмешника", "Винни Пух", "1984",
			"Лев, колдунья и платяной шкаф", "Джейн Эйр", "Уловка-22", "Грозовой перевал", "Пение птиц", "Ребекка",
			"Над пропастью во ржи", "Ветер в ивах", "Большие надежды", "Маленькие женщины»",
			"Мандолина капитана Корелли", "Война и мир", "Унесённые ветром", "Гарри Поттер и философский камень",
			"Гарри Поттер и Тайная комната", "Гарри Поттер и узник Азкабана", "Поющие в терновнике",
			"Тэсс из рода д’Эрбервиллей", "Миддлмарч", "Гроздья гнева", "Алиса в Стране чудес", "Дневник Трейси Бикер"};
		private String[] publishings = {"Аванта +", "Азбука", "АКВИЛЕГИЯ-М", "Арка", "АСТ", "АСТ-ПРЕСС", "Белый Город",
				"Время"};
		private String[] typesOfBindings = {"цельнокартонный обрезной", "цельнокартонный с кантом",
		"цельнотканевый мягкий обрезной", "цельнобумажный жесткий с кантом",
		"составной с тканевым корешком и со сторонками, крытыми обложечной бумагой", "цельнотканевый мягкий с кантом",
		"цельнотканевый жесткий с кантом",
		"составной с кантом, со сторонками, крытыми одним видом ткани, и с корешком из др. вида ткани",
		"пластмассовый жёсткий из двух слоёв эластичного пластика, между которыми проложены картонные сторонки",
		"пластмассовый мягкий из одного слоя эластичного пластика"};
		private String[] autors = {"Дж. Р. Р. Толкин", "Джордж Р. Р. Мартин", "Патрик Ротфусс",
				"Аркадий и Борис Стругацкие", "Дэн Симмонс", "Жюль Верн", "Анджей Сапковский", "Брендон Сандерсон",
				"Владислав Крапивин", "Павел Бажов", "Лазарь Лагин", "Фрэнк Герберт", "Джо Аберкромби", "Джон Уиндэм",
				"Станислав Лем", "Нил Стивенсон", "Герберт Уэллс", "Рэй Брэдбери", "Дж. К. Ролинг", "Роджер Желязны",
				"Генри Каттнер", "Гай Гэвриел Кей", "Роберт Хайнлайн", "Кир Булычев", "Владимир Обручев", "Мэри Стюарт",
				"Орсон Скотт Кард", "Джонатан Страуд", "Клиффорд Саймак"};
		@Override
		public String generateAutor() {
			String autor = autors[(int)(Math.random()*autors.length)];
			return autor;
		}

		@Override
		public String generateName() {
			String name = books[(int)(Math.random()*books.length)];
			return name;
		}

		@Override
		public int generateNumOfPages() {
			int pages = (int)(Math.random()*500)+100;
			return pages;
		}

		@Override
		public int generatePrice() {
			int price = (int)(Math.random()*900)+100;
			return price;
		}

		@Override
		public String generatePublishing() {
			String publishing = publishings[(int)(Math.random()*publishings.length)];
			return publishing;
		}

		@Override
		public int generatePublishingYear() {
			int publishingYear = (int)(Math.random()*100)+1900;
			return publishingYear;
		}

		@Override
		public String generateTypeOfBinding() {
			String typeOfBinding = typesOfBindings[(int)(Math.random()*typesOfBindings.length)];
			return typeOfBinding;
		}
	}

