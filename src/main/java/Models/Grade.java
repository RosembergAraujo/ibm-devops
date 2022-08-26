package Models;

public class Grade {
    private String subject;
    private float value;

    public Grade(String subject, float value) {
        this.subject = subject;
        this.value = value;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        var gradeStatus = "";

        if (this.value < 5) gradeStatus = "Reprovado";
        else if (this.value < 7) gradeStatus = "Recuperação";
        else gradeStatus = "Aprovado";

        return "Nota: { Materia: \"" + this.subject + "\", Nota: \"" + this.value + "\", Situação: \""+gradeStatus+"\" }";
    }


}
