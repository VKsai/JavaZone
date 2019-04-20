import java.util.ArrayList;
import java.util.List;

public class CompareTest {

    static class Student {
        public String name;
        public double cgpa;

        // A parameterized student constructor
        public Student(String name, double cgpa) {

            this.name = name;
            this.cgpa = cgpa;
        }

        public String getName() {
            return name;
        }

        @Override
        public int hashCode() {
            return (int)this.cgpa;
        }

        @Override
        public boolean equals(Object obj) {
            Student student = (Student) obj;
            return this.name == student.getName();
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Alexios", 4.0);
        Student student2 = new Student("Kassandra", 3.6);
        Student student3 = new Student("Sokratis", 3.6);
        Student student4 = new Student("Nikolas", 3.8);
        Student student5 = new Student("Cults", 2.0);
        Student student6 = new Student("Alexios", 4.0);;

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        students.stream().forEach(student -> System.out.println(student.getName()+" "+student.hashCode()));
    }
}
