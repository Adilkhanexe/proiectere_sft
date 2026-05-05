package main.java.ro.ulbs.proiectare.lab7.util;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;
    private String name;

    private static PasswordMaker instance;

    private static int callingCount = 0;

    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
        instance = new PasswordMaker("DefaultName");
    }

    private PasswordMaker(String name) {
        this.name = name;
    }

    public static PasswordMaker getInstance() {
        callingCount++;
        return instance;
    }
    public static int getCallingCounts() {
        return callingCount;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = "" + name.length() + r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }
}