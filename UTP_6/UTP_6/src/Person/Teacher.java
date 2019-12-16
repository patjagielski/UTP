package Person;

import Collections.TeacherCollection;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class Teacher extends Person {
    private LocalDate _hireDate;
    protected Degree _degree;
    protected static TeacherCollection teacherTreeSet = new TeacherCollection();

    public Teacher() throws IOException {
        super();
        this._degree = get_degree();
        this._hireDate = get_hireDate();
        //System.out.println(this.toString());
        teacherTreeSet.TeacherCollection.add(this);

    }

    public static List<Teacher> teacherGenerate() {
        List<Teacher> teacherList = new ArrayList<Teacher>(teacherTreeSet.getTeacherCollection());
        //System.out.println(teacherTreeSet.getTeacherCollection().size());
        Collections.shuffle(teacherList);
        return teacherList.subList(0, 10);
    }

    public static Teacher genOneTeacher() {
        List<Teacher> teachers = new ArrayList<Teacher>(teacherTreeSet.getTeacherCollection());
        Collections.shuffle(teachers);
        return teachers.get(0);
    }

    public LocalDate get_hireDate() {
        LocalDate hiredate = LocalDate.ofEpochDay(get_DOB().getYear() + createHireDates());
        return hiredate;

    }

    public int createHireDates() {
        int hireDate;
        if (this.get_Age() >= 30 && this.get_Age() < 40) {
            if (this.get_Age() >= 30 && this.get_Age() <= 39) {
                return hireDate = this.get_Age() - 5;
            } else {
                return hireDate = this.get_Age() - 10;
            }
        } else if (this.get_Age() >= 40 && this.get_Age() < 50) {
            if (this.get_Age() >= 40 && this.get_Age() <= 49) {
                return hireDate = this.get_Age() - 15;
            } else {
                return hireDate = this.get_Age() - 20;
            }
        } else {
            return hireDate = this.get_Age() - 30;

        }
    }

    public Degree get_degree() {
        Random random = new Random();
        return Degree.values()[random.nextInt(Degree.values().length)];
    }

    @Override
    public String toString() {
        String s = "";
        try {
            s = "Teacher{" + "Name: " + get_firstName() +
                    ", Surname: " + get_surname() +
                    ", hireDate=" + _hireDate +
                    ", degree=" + _degree +
                    '}';
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(_hireDate, teacher._hireDate) &&
                _degree == teacher._degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _hireDate, _degree);
    }

    @Override
    public int compareTo(Person person) {
        return super.compareTo(person);
    }


}
