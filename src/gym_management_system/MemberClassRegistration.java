package gym_management_system;

import java.time.LocalDate;

public class MemberClassRegistration implements Record {

    private String memberID;
    private String classID;
    private String status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID, LocalDate registrationDate, String status) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getClassID() {
        return classID;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String lineRepresentation() {
        String line = this.memberID + "," + this.classID + "," + this.registrationDate.toString() + "," + this.status;
        return line;
    }

    @Override
    public String getSearchKey() {
        return memberID + "-" + classID;
    }

}
