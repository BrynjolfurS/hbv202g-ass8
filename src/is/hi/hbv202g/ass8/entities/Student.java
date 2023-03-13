package is.hi.hbv202g.ass8.entities;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 *
 *
 ***********************************************************/

public class Student extends User{
    private boolean feePaid;
    private String name;

    public Student(String name, boolean feePaid) {
        super(name);
        this.feePaid = feePaid;
        this.name = name;
    }

    public boolean isFeePaid() {
        return feePaid;
    }

    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }
}
