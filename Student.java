/**
 * Created by Gwindblaid on 16.05.2016.
 */
//Стандартный класс Student
public class Student {
    private int id;
    private String name;
    private String secondName;
    private String surname;
    private String dateOfBirth;
    private String phone;
    private String adress;
    private String institute;
    private String department;
    private int course;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
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

    @Override
    public String toString() {
        return "Id "+id+"\n"+
                surname+" "+name+" "+secondName+"\n"+
                "Дата рождения: "+dateOfBirth+"\n"+
                "Телефон: "+phone+ "\n"+
                "Адрес: "+adress+"\n"+
                institute+"\n"+
                department+", "+course+" курс"+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (course != student.course) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (secondName != null ? !secondName.equals(student.secondName) : student.secondName != null) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(student.dateOfBirth) : student.dateOfBirth != null) return false;
        if (phone != null ? !phone.equals(student.phone) : student.phone != null) return false;
        if (adress != null ? !adress.equals(student.adress) : student.adress != null) return false;
        if (institute != null ? !institute.equals(student.institute) : student.institute != null) return false;
        return department != null ? department.equals(student.department) : student.department == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (institute != null ? institute.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + course;
        return result;
    }
}

