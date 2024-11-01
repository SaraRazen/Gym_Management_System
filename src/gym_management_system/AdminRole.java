package gym_management_system;

import java.util.ArrayList;

public class AdminRole {

    private TrainerDatabase database;

    public AdminRole() {
        this.database = new TrainerDatabase("Trainers.txt");
    }

    public void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        Trainer newTrainer = new Trainer(trainerId, name, email, specialty, phoneNumber);

        database.insertRecord(newTrainer);
    }

    public ArrayList<Trainer> getListOfTrainers() {
        ArrayList<Trainer> trainers = database.returnAllRecords();
        return trainers;
    }

    public void removeTrainer(String key) {
        database.deleteRecord(key);
    }

    public void logout() {
        database.saveToFile();
        return;

    }
}
