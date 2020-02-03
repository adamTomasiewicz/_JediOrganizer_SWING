package jediOrganizer.model;

import java.util.LinkedList;
import java.util.List;

public class Jedi {
    private static List<Jedi> listOfJedi = new LinkedList<>();
    private static int IDcounter = 1;
    private int IDJedi;
    private String name;
    private String color;
    private int power;
    private String side;
    private int ZakonID;

    public Jedi() {
    }
    public Jedi(int IDJedi, String name, String color, int power) {
        this.IDJedi = IDJedi;
        this.name = name;
        this.color = color;
        this.power = power;
        this.ZakonID = 0;
    }

    public static List<Jedi> getListOfJedi() {
        return listOfJedi;
    }

    public static void setListOfJedi(List<Jedi> listOfJedi) {
        Jedi.listOfJedi = listOfJedi;
    }

    public static int getIDcounter() {
        return IDcounter;
    }

    public static void setIDcounter(int IDcounter) {
        Jedi.IDcounter = IDcounter;
    }

    public int getIDJedi() {
        return IDJedi;
    }

    public void setIDJedi(int IDJedi) {
        this.IDJedi = IDJedi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getSide() {
        return side;
    }
    public void setSide(String side) {
        this.side = side;
    }

    public int getZakonID() {
        return ZakonID;
    }

    public void setZakonID(int zakonID) {
        ZakonID = zakonID;
    }

    @Override
    public String toString() {
        return "Jedi{" +
                "IDJedi=" + IDJedi +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", power=" + power +
                ", side='" + side + '\'' +
                ", ZakonID=" + ZakonID +
                '}';
    }
}
