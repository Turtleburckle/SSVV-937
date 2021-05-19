package Domain;

public class Nota implements HasId<Integer> {

    //private Pair<String,Integer> idNota;
    private Integer temaLabId;
    private String studentId;
    private int deliveredWeek;
    private int deadline;
    private String feedback;
    private double valoare;

    public Nota(Integer temaLabId, String studentId, int deliveredWeek, int deadline, String feedback, double valoare) {
        this.temaLabId = temaLabId;
        this.studentId = studentId;
        this.deliveredWeek = deliveredWeek;
        this.deadline = deadline;
        this.feedback = feedback;
        this.valoare = valoare;
    }

    @Override
    public Integer getId() {
        return 0;
    }

    @Override
    public void setId(Integer id) {

    }

    public Integer getTemaLabId() {
        return temaLabId;
    }

    public void setTemaLabId(Integer temaLabId) {
        this.temaLabId = temaLabId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getDeliveredWeek() {
        return deliveredWeek;
    }

    public void setDeliveredWeek(int deliveredWeek) {
        this.deliveredWeek = deliveredWeek;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    @Override
    public String toString(){
        return this.studentId+"#"+this.temaLabId+"#"+this.valoare+"#"+this.feedback;
    }
}
