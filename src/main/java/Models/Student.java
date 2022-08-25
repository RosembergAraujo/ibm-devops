package Models;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String status;
    private String name;
    private List<Grade> grades;

    public Student() {
        this.grades = new ArrayList<Grade>();
    }

    public Student(String name) {
        this.grades = new ArrayList<Grade>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public void AddNewGrade(String subject, float grade){
        this.grades.add(new Grade(subject, grade));
    }

    @Override
    public String toString() {
        String result = "Aluno: {\n        Nome: \"" + this.name + "\",\n        Notas: [";
        if (this.grades.size() > 0){
            for (Grade grade : this.grades) {
                result += "\n            " + grade.toString();
            }
            result += "\n        ]\n}";
        }else {
            result += "]\n}";
        }
        return result;
    }


}
