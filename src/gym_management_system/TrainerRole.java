package gym_management_system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class TrainerRole {

    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    public TrainerRole() {
        this.memberDatabase = new MemberDatabase("Members.txt");
        this.classDatabase = new ClassDatabase("Classes.txt");
        this.registrationDatabase = new MemberClassRegistrationDatabase("Registrations.txt");
    }

    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        Member m = new Member(memberID, name, membershipType, email, phoneNumber, status);
        memberDatabase.insertRecord(m);
    }

    public ArrayList<Member> getListOfMembers() {
        return memberDatabase.returnAllRecords();
    }

    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class c = new Class(classID, className, trainerID, duration, maxParticipants);
        classDatabase.insertRecord(c);
    }

    public ArrayList<Class> getListOfClasses() {
        return classDatabase.returnAllRecords();
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        Class target = (Class) classDatabase.getRecord(classID);
        if (target == null) {
            return false;
        }
        if (registrationDatabase.contains(memberID + "-" + classID)) {
            return false;
        }
        if (target.getAvailableSeats() > 0 && memberDatabase.contains(memberID) && classDatabase.contains(classID)) {
            MemberClassRegistration registration = new MemberClassRegistration(memberID, classID, registrationDate, "active");
            registrationDatabase.insertRecord(registration);
            target.setAvailableSeats(target.getAvailableSeats() - 1);
            return true;
        }
        return false;
    }

    public boolean cancelRegistration(String memberID, String classID) {
        ArrayList<MemberClassRegistration> members = registrationDatabase.returnAllRecords();
        for (MemberClassRegistration reg : members) {
            if (reg.getMemberID().equals(memberID) && reg.getClassID().equals(classID)) {
                long daysBetween = ChronoUnit.DAYS.between(reg.getRegistrationDate(), LocalDate.now());
                if (daysBetween <= 3) {
                    reg.setStatus("canceled");
                    Class target = (Class) classDatabase.getRecord(classID);
                    if (target != null) {
                        target.setAvailableSeats(target.getAvailableSeats() + 1);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<MemberClassRegistration> getListOfRegistrations() {
        return registrationDatabase.returnAllRecords();
    }

    public void logout() {
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
        return;

    }
}
