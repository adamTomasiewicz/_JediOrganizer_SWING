package jediOrganizer.model;

import java.util.LinkedList;
import java.util.List;

public class ZakonJedi {
    private static List<ZakonJedi> listOfZakony = new LinkedList<>();
    private static int IDcounter = 1;
    private int IDZakon;
    private String name;

    public ZakonJedi() {
    }
    public ZakonJedi(int IDZakon, String name) {
        this.IDZakon = IDZakon;
        this.name = name;
    }

    public static List<ZakonJedi> getListOfZakony() {
        return listOfZakony;
    }

    public static void setListOfZakony(List<ZakonJedi> listOfZakony) {
        ZakonJedi.listOfZakony = listOfZakony;
    }

    public static int getIDcounter() {
        return IDcounter;
    }

    public static void setIDcounter(int IDcounter) {
        ZakonJedi.IDcounter = IDcounter;
    }

    public int getIDZakon() {
        return IDZakon;
    }

    public void setIDZakon(int IDZakon) {
        this.IDZakon = IDZakon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ZakonJedi{" +
                "IDZakon=" + IDZakon +
                ", name='" + name + '\'' +
                '}';
    }
    //    public int getNumberOfJedis() {
//        return numberOfJedis;
//    }
//
//    public void setNumberOfJedis(int numberOfJedis) {
//        this.numberOfJedis = numberOfJedis;
//    }
}
