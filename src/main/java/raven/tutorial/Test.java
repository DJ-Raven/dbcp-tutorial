package raven.tutorial;

import raven.tutorial.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        try {
            DatabaseConnection.getInstance().connectToDatabase();
            //insert();
           // update();
           // delete();
            select();
            System.out.println("Connection success ...");
        } catch (SQLException e) {
    e.printStackTrace();
        }
    }

    private static void insert() throws SQLException {
        String name = "foods";
        double sellPrice = 3;
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("insert into product (ProductName, SellPrice) values (?,?)");
            p.setString(1, name);
            p.setDouble(2, sellPrice);
            p.execute();
        } finally {
            // close
            DatabaseConnection.getInstance().close(p, con);
        }
    }

    private static void update() throws SQLException {
        int id = 2;
        String name = "food updated";
        double sellPrice = 20.5;
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("update product set ProductName=?, SellPrice=?, UpdatedDate=now() where ProductID=? limit 1");
            p.setString(1, name);
            p.setDouble(2, sellPrice);
            p.setInt(3, id);
            p.execute();
        } finally {
            // close
            DatabaseConnection.getInstance().close(p, con);
        }
    }

    private static void delete() throws SQLException {
        int id = 1;
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("update product set DeletedDate=now() where ProductID=? limit 1");
            p.setInt(1, id);
            p.execute();
        } finally {
            // close
            DatabaseConnection.getInstance().close(p, con);
        }
    }

    private static void select() throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r=null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select ProductID, ProductName, QtyStock, SellPrice from product where DeletedDate is null");
            r=p.executeQuery();
            while(r.next()){
                int productID=r.getInt("ProductID");
                String productName=r.getString("ProductName");
                int qtyStock=r.getInt("QtyStock");
                double sellPrice=r.getDouble("SellPrice");

                System.out.println(productID+"\t"+productName+"\t"+qtyStock+"\t"+sellPrice);
            }
        } finally {
            // close
            DatabaseConnection.getInstance().close(r,p, con);
        }
    }
}
