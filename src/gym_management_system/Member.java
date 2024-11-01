package gym_management_system;

public class Member implements Record {

    private String memberID;
    private String membershipType;
    private String status;
    private String email;
    private String phoneNumber;
    private String name;

    public Member(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        this.name = name;
        this.memberID = memberID;
        this.membershipType = membershipType;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String lineRepresentation() {
        String line = this.memberID + "," + this.name + "," + this.membershipType + "," + this.email + "," + this.phoneNumber + "," + this.status;
        return line;
    }

    @Override
    public String getSearchKey() {
        return memberID;
    }

}
