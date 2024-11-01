package gym_management_system;

import java.util.*;

public class TrainerDatabase extends Database {

    public TrainerDatabase(String filename) {
        super(filename);
        super.readFromFile();
    }

    @Override
    public Record createRecordFrom(String line) {
        String[] parts = line.split(",");

        return new Trainer(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim());
    }

    public ArrayList<Trainer> returnAllRecords() {
        ArrayList<Trainer> trainers = new ArrayList<>();
        ArrayList<Record> records = super.returnAllRecord();
        for (Record record : records) {

            trainers.add((Trainer) record);

        }
        return trainers;
    }

}
