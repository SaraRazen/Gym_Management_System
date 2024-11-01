package gym_management_system;

public class Trainer implements Record {

    private String trainerId;
    private String speciality;
    private String email;
    private String phoneNumber;
    private String name;

    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        this.name = name;
        this.trainerId = trainerId;
        this.speciality = speciality;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String lineRepresentation() {
        String line = this.trainerId + "," + this.name + "," + this.email + "," + this.speciality + "," + this.phoneNumber;
        return line;
    }

    @Override
    public String getSearchKey() {
        return trainerId;

    }
}
