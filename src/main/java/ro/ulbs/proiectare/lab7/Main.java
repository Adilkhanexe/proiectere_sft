package main.java.ro.ulbs.proiectare.lab7;

import main.java.ro.ulbs.proiectare.lab7.def.Student;
import main.java.ro.ulbs.proiectare.lab7.forms.Circle;
import main.java.ro.ulbs.proiectare.lab7.forms.Form;
import main.java.ro.ulbs.proiectare.lab7.forms.Square;
import main.java.ro.ulbs.proiectare.lab7.forms.Triangle;
import main.java.ro.ulbs.proiectare.lab7.util.PasswordMaker;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");

        System.out.println("Area = " + tri.getArea() + " details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getInstanceCount());

        //7.6.2 Password maker singleton
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of times getInstance() has been called: " + PasswordMaker.getCallingCounts());

        //7.6.3 Immutability
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("Ivan", "Grupa 1"));
        studenti.add(new Student("Maria", "Grupa 1"));
        studenti.add(new Student("Ioan", "Grupa 1"));

        studenti = imparteInDouaFormatii(studenti, "TI 21_1", "TI 21_2");

        System.out.println("\n7.6.3 Students dupa split:");
        for (Student s : studenti) {
            System.out.println(s.getName() + " - " + s.getFormation());
        }
    }
    public static List<Student> imparteInDouaFormatii(List<Student> studenti, String f1, String f2) {
        List<Student> rezultate = new ArrayList<>();
        int limita = (studenti.size() + 1) / 2;

        for (int i = 0; i < studenti.size(); i++) {
            String nouaGrupa = (i < limita) ? f1 : f2;
            rezultate.add(Student.schimbaFormatia(studenti.get(i), nouaGrupa));
        }
        return rezultate;
    }
}