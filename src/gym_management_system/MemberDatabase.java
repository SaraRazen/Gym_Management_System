package gym_management_system;

import java.util.ArrayList;

public class MemberDatabase extends Database {

    public MemberDatabase(String filename) {
        super(filename);
        super.readFromFile();
    }

    @Override
    public Record createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new Member(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim(), parts[5].trim());
    }

    public ArrayList<Member> returnAllRecords() {
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Record> records = super.returnAllRecord();
        for (int i = 0; i < records.size(); i++) {
            Record record = records.get(i);
            members.add((Member) record);

        }
        return members;
    }

}
