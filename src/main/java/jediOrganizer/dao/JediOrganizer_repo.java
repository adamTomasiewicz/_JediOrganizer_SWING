package jediOrganizer.dao;

import jediOrganizer.model.Jedi;
import jediOrganizer.model.ZakonJedi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JediOrganizer_repo {
    public static Connection connection;


    public static void connectDB() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jediOrganizer",
                    "postgres","postgres1");
            System.out.println("DB jediOrganizer connected");
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
    }
    public static void disconectDB() {
//        try {preparedStatement.close();
//        } catch (SQLException e) { e.printStackTrace();}
//        try {statement.close();
//        } catch (SQLException e) {e.printStackTrace(); }
        try { connection.close();
        } catch (SQLException e) { e.printStackTrace();}
    }

    public static void addZakonJediToDB (ZakonJedi zakonJedi) {
        connectDB();
        try {
            String sql = "INSERT INTO ZakonJedi (IDZakon, name)" +
                    " VALUES (?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setInt(1, zakonJedi.getIDZakon());
            preparedStatement.setString(2, zakonJedi.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconectDB();
    }
    public static void addJediToDB(Jedi jedi) {
        connectDB();
        try {
            String sql = "INSERT INTO Jedi (IDJedi, name, color, power, side, zakonID)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, jedi.getIDJedi());
            preparedStatement.setString(2, jedi.getName());
            preparedStatement.setString(3, jedi.getColor());
            preparedStatement.setInt(4, jedi.getPower());
            preparedStatement.setString(5, jedi.getSide());
            preparedStatement.setInt(6, jedi.getZakonID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconectDB();
    }


    public static List<ZakonJedi> getListOfZakonJediFromDB() {
        connectDB();
        List<ZakonJedi> resultDB_zakonJediList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ZakonJedi";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet queryResultSet = preparedStatement.executeQuery();

            while (queryResultSet.next()) {
                int idZakon = queryResultSet.getInt("IDZakon");
                String name = queryResultSet.getString("name");

                ZakonJedi zakonJedi = new ZakonJedi();

                zakonJedi.setIDZakon(idZakon);
                zakonJedi.setName(name);
                resultDB_zakonJediList.add(zakonJedi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconectDB();
        return resultDB_zakonJediList;
    }
    public static List<Jedi> getListOfJediFromDB() {
        connectDB();
        List<Jedi> resultDB_jediList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Jedi";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet queryResultSet = preparedStatement.executeQuery();
            while (queryResultSet.next()) {
                int idJedi = queryResultSet.getInt("IDJedi");
                String name = queryResultSet.getString("name");
                String color = queryResultSet.getString("color");
                int power = queryResultSet.getInt("power");
                String side = queryResultSet.getString("side");
                int zakonID = queryResultSet.getInt("zakonID");
                Jedi jedi = new Jedi();
                jedi.setIDJedi(idJedi);jedi.setName(name);jedi.setColor(color);
                jedi.setPower(power); jedi.setSide(side);jedi.setZakonID(zakonID);
                resultDB_jediList.add(jedi);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconectDB();
        return resultDB_jediList;
    }

    public static void isTablesInDBCreated () {
        connectDB();
        try {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSetZakonJedi = databaseMetaData.getTables(null, null, "zakonjedi", null);
        ResultSet resultSetJedi = databaseMetaData.getTables(null, null, "jedi", null);
        disconectDB();
        if (resultSetZakonJedi.next()&resultSetJedi.next()) {
                System.out.println("Tables: ZakonJedi, Jedi already created");
            }
            else {
                createAllTablesInDB();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void createAllTablesInDB (){
        connectDB();
        try {
            Statement statement=connection.createStatement();
            statement.execute("CREATE TABLE ZakonJedi(IDZakon int PRIMARY KEY, Name varchar(50));");
            statement.execute("create table Jedi(IDJedi int, name varchar(50), color varchar(50), " +
                    "power int, side varchar(15), ZakonID int, " +
                    "PRIMARY KEY(IDJedi), FOREIGN KEY(ZakonID) REFERENCES ZakonJedi(IDZakon));");
            System.out.println("Created tables: ZakonJedi, Jedi");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconectDB();
    }
    public static void dropAllTablesFromDB (){
        connectDB();
        try {
            Statement statement=connection.createStatement();
            statement.execute("drop table Jedi;");
            statement.execute("drop table ZakonJedi;");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconectDB();
    }

}
