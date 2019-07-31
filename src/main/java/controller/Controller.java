package controller;

import gui.FormEvent;
import model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    Database db = new Database();

    public List<Person> getPeople() {
        return db.getPeople();
    }

    public void addPerson(FormEvent e) {
        String name = e.getName();
        String occupation = e.getOccupation();
        int ageCatId = e.getAgeCategory();
        String empCat = e.getEmpCategory();
        boolean isUs = e.isUsCitizen();
        String taxId = e.getTaxId();
        String gender = e.getGender();

        AgeCategory ageCategory;
        switch (ageCatId) {
            case 0:
                ageCategory = AgeCategory.child;
                break;
            case 1:
                ageCategory = AgeCategory.adult;
                break;
            case 2:
                ageCategory = AgeCategory.senior;
                break;
            default:
                ageCategory = null;
                break;
        }

        EmploymentCategory empCategory;
        if(empCat.equals("employed")) {
            empCategory = EmploymentCategory.employed;
        } else if (empCat.equals("self-employed")) {
            empCategory = EmploymentCategory.selfEmployed;
        } else if (empCat.equals("unemployed")) {
            empCategory = EmploymentCategory.unemployed;
        } else {
            empCategory = EmploymentCategory.other;
            System.err.println(empCat);
        }

        Gender genderCat;

        if (gender.equals("male")) {
            genderCat = Gender.male;
        } else {
            genderCat = Gender.female;
        }

        Person person = new Person(name, occupation, ageCategory, empCategory, taxId, isUs, genderCat);
        db.addPerson(person);
    }

    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException, ClassNotFoundException {
        db.loadFromFile(file);
    }
}
