package gym_management_system;

public class Class implements Record {

    private String classID;
    private String trainerID;
    private String ClassName;
    private int duration;
    private int availableSeats;

    public Class(String classID, String ClassName, String trainerID, int duration, int availableSeats) {
        this.ClassName = ClassName;
        this.classID = classID;
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    protected void setAvailableSeats(int availableSeats) {

        this.availableSeats = availableSeats;

    }

    @Override
    public String lineRepresentation() {
        String line = this.classID + "," + this.ClassName + "," + this.trainerID + "," + this.duration + "," + this.availableSeats;
        return line;
    }

    @Override
    public String getSearchKey() {
        return classID;
    }

}
