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
        return "Nota: { Materia: \"" + this.subject + "\", Nota: \"" + this.value + "\" }";
    }


}
