package com.company.demo;

import java.util.ArrayList;

public class GroomAndBride {

    ArrayList<Person> people = new ArrayList<>();

    public GroomAndBride() {
        people.add(new Person("Ajay", "M", "Babu", "Chitra"));
        people.add(new Person("Divya", "F", "Babu", "Chitra"));
        people.add(new Person("Chitra", "F", "Eashan", "Falguni"));
        people.add(new Person("Ganesh", "M", "Eashan", "Falguni"));
        people.add(new Person("Hema", "F", "Ganesh", "Indhu"));
        people.add(new Person("Jegan", "M", "Ganesh", "Indhu"));
        people.add(new Person("Babu", "M", "Kumar", "Lakshmi"));
        people.add(new Person("Meena", "F", "Kumar", "Lakshmi"));
        people.add(new Person("Nethaji", "M", "OmPrakash", "Meena"));
    }

    public String getFatherName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person.getFather();
            }
        }
        return "";
    }

    public String getMotherName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person.getMother();
            }
        }
        return "";
    }

    public ArrayList<Person> findSiblings(String name) {
        String fatherName = getFatherName(name);
        ArrayList<Person> children = getChildrenFatherName(fatherName);
        children.removeIf(person -> person.getName().equals(name));

        return children;
    }

    public ArrayList<Person> getChildrenFatherName(String name) {
        ArrayList<Person> children = new ArrayList<>();

        for (Person person : people) {
            if (person.getFather().equals(name)) {
                children.add(person);
            }
        }
        return children;
    }

    public ArrayList<Person> getChildrenByMotherName(String name) {
        ArrayList<Person> children = new ArrayList<>();

        for (Person person : people) {
            if (person.getMother().equals(name)) {
                children.add(person);
            }
        }
        return children;
    }

    // Father's Sister
    public ArrayList<Person> getAunties(String name) {
        String fatherName  = getFatherName(name);
        ArrayList<Person> aunties = findSiblings(fatherName);
        aunties.removeIf(person -> person.getGender().equals("M"));
        return aunties;
    }

    public void showAuntiesSon(String name) {
        ArrayList<Person> aunties = getAunties(name);
        ArrayList<Person> grooms = new ArrayList<>();
        for (Person aunty : aunties) {
            grooms = getChildrenByMotherName(aunty.getName());
            grooms.removeIf(person -> person.getGender().equals("F"));
            printArray(grooms);
        }

    }

    public void showAuntiesDaughter(String name) {
        ArrayList<Person> aunties = getAunties(name);
        ArrayList<Person> brides = new ArrayList<>();
        for (Person aunty : aunties) {
            brides = getChildrenByMotherName(aunty.getName());
            brides.removeIf(person -> person.getGender().equals("M"));
            printArray(brides);
        }
    }


    //Mother's Brother
    public ArrayList<Person> getUncles(String name) {
        String motherName  = getMotherName(name);
        ArrayList<Person> uncles = findSiblings(motherName);
        uncles.removeIf(person -> person.getGender().equals("F"));
        return uncles;
    }

    public void showUnclesSon(String name) {
        ArrayList<Person> uncles = getUncles(name);
        ArrayList<Person> grooms = new ArrayList<>();
        for (Person uncle : uncles) {
            grooms = getChildrenFatherName(uncle.getName());


            if (grooms.size() <= 0) {
                System.out.println(uncle.getName());
            } else {
                grooms.removeIf(person -> person.getGender().equals("F"));
                printArray(grooms);
            }
        }

    }

    public void showUnclesDaughter(String name) {
        ArrayList<Person> uncles = getUncles(name);
        ArrayList<Person> brides = new ArrayList<>();
        for (Person uncle : uncles) {
            brides = getChildrenFatherName(uncle.getName());
            brides.removeIf(person -> person.getGender().equals("M"));

            printArray(brides);
        }

    }

    public void showSisterDaughter(String name)
    {
        ArrayList<Person> siblings = findSiblings(name);
        siblings.removeIf(person -> person.getGender().equals("M"));

        for(Person person:siblings)
        {
            ArrayList<Person> brides = getChildrenFatherName(person.getName());
            brides.removeIf(x -> x.getGender().equals("M"));
            printArray(brides);
        }

    }

    private void printArray(ArrayList<Person> people) {
        for (Person person : people) {
            if(!isMarried(person.getName()))
            {
                System.out.println(person.getName());
            }
        }
    }

    private boolean isMarried(String name)
    {
        for (Person person :people) {
            if (person.getFather().equals(name) || person.getMother().equals(name))
            {
                return true;
            }
        }
        return false;
    }

}
