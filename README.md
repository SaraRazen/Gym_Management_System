# Gym Management System (Java)

A gym management system written in Java using object-oriented programming. It was developed as a collaborative project with [teammate's name](link to their GitHub) during my first/second year in CCE.

## Features
- Role-based access: **Admin** and **Trainer** roles
- Manage members and trainers (add, search, remove)
- Create and manage gym classes
- Register members into classes and track registrations
- Data handled through dedicated database classes

## OOP Concepts Used
- Classes and objects (`Member`, `Trainer`, `Class`, `Record`, ...)
- Encapsulation
- Separation of data and logic (`MemberDatabase`, `TrainerDatabase`, `ClassDatabase`, `MemberClassRegistrationDatabase`)
- Role-specific behavior (`AdminRole`, `TrainerRole`)

## Project Structure
| File | Purpose |
|---|---|
| `Gym_Management_System.java` | Main entry point |
| `AdminRole.java`, `TrainerRole.java` | Role functionality |
| `Member.java`, `Trainer.java`, `Class.java` | Core entities |
| `MemberClassRegistration.java` | Links members to classes |
| `*Database.java` | Storage and retrieval for each entity |
| `Record.java` | Shared record type |



## Note
Originally written as a university project and kept close to its original state.
