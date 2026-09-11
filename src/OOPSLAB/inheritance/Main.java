package OOPSLAB.inheritance;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Simple Inheritance");
        Manager m = new Manager();
        m.work();
        m.manage();

        System.out.println();
        System.out.println("Multilevel Inheritance");
        TeamLead t = new TeamLead();
        t.work();
        t.manage();
        t.lead();

        System.out.println();
        System.out.println("Hierarchical inheritance ");
        Developer d = new Developer();
        d.work();
        d.code();
    }
}