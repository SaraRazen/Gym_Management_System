package gym_management_system;

import java.time.LocalDate;
import java.util.*;

public class MemberClassRegistrationDatabase extends Database {

    public MemberClassRegistrationDatabase(String filename) {
        super(filename);
        super.readFromFile();
    }

    @Override
    public Record createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new MemberClassRegistration(parts[0].trim(), parts[1].trim(), LocalDate.parse(parts[2].trim()), parts[3].trim());
    }

    public ArrayList< MemberClassRegistration> returnAllRecords() {
        ArrayList< MemberClassRegistration> member = new ArrayList<>();
        ArrayList<Record> records = super.returnAllRecord();
        for (int i = 0; i < records.size(); i++) {
            Record record = records.get(i);
            member.add((MemberClassRegistration) record);

        }

        return member;
    }

}
