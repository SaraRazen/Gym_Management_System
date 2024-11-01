package gym_management_system;

import java.util.*;
import java.io.*;

public class ClassDatabase extends Database {

    public ClassDatabase(String filename) {
        super(filename);
        super.readFromFile();
    }

    @Override
    public Record createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new Class(parts[0].trim(), parts[1].trim(), parts[2].trim(), Integer.parseInt(parts[3].trim()), Integer.parseInt(parts[4].trim()));
    }

    public ArrayList<Class> returnAllRecords() {
        ArrayList<Class> classes = new ArrayList<>();
        ArrayList<Record> records = super.returnAllRecord();
        for (int i = 0; i < records.size(); i++) {
            Record record = records.get(i);

            classes.add((Class) record);

        }
        return classes;
    }

}
