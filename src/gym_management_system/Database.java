package gym_management_system;

import java.io.*;
import java.util.*;

abstract public class Database {

    private ArrayList<Record> records;
    private String filename;

    public Database(String filename) {
        this.filename = filename;
        this.records = new ArrayList<>();
    }

    public void readFromFile() {
        try {
            File f = new File(filename);
            if (!f.exists()) { 
                f.createNewFile();
            }
            Scanner input = new Scanner(f);
            while (input.hasNextLine()) {
                String s = input.nextLine();
                insertRecord(createRecordFrom(s));

            }
        } catch (IOException e) {  
            System.out.println("Error opening or creating the file: " + filename);
        }
    }

    public boolean contains(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {

                return true;
            }
        }
        return false;

    }

    public Record getRecord(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                return records.get(i);
            }
        }
        return null;
    }

    public void insertRecord(Record record) {
        if (!contains(record.getSearchKey())) {
            records.add(record);

        }
    }

    public void deleteRecord(String key) {

        Record p = getRecord(key);
        if (p != null) {
            records.remove(p);

        }

    }

    public void saveToFile() {
        try {
            File f = new File(filename);
            PrintWriter pw = new PrintWriter(f);
            for (int i = 0; i < records.size(); i++) {
                pw.println(records.get(i).lineRepresentation());
            }

            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + filename);
        }
    }

    abstract protected Record createRecordFrom(String line);

    protected ArrayList<Record> returnAllRecord() {
        if (records.isEmpty()) {
            return null;
        }
        return records;
    }
}
