/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class Product {

    private int product_id;
    private String p_name;
    private String description;
    private double price;
    private int quantity;

    public int getProduct_id() {
        return product_id;
    }

    public String getP_name() {
        return p_name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static String allProducts() throws ClassNotFoundException, SQLException {
        StringBuilder all_products = new StringBuilder();
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC&useSSL=false", "root", " ");) {
            Statement st = conn.createStatement();
            st.executeQuery("select product_id, p_name, description, price, customer_id, sell from products");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                all_products.append("ID: " + rs.getString("product_id"));
                all_products.append("\n");
                all_products.append("Product: " + rs.getString("p_name"));
                all_products.append("\n");
                all_products.append("Description: " + rs.getString("description"));
                all_products.append("\n");
                all_products.append("Price: " + rs.getString("price"));
                all_products.append("\n");

                if (rs.getString("customer_id") != null && rs.getString("sell") != null) {
                    all_products.append("Customer ID: " + rs.getString("customer_id"));
                    all_products.append("\n");
                    all_products.append("Status: " + rs.getString("sell"));
                }
                all_products.append("\n\n");
            }
        } catch (SQLException ex) {
            all_products.append(ex.getMessage());
        }
        return all_products.toString();
    }

    public void insertProducts() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC&useSSL=false", "root", " ");) {
            if (p_name != null && !(p_name.isEmpty()) && description != null && !(description.isEmpty()) && price != 0) {
                Statement st = conn.createStatement();
                st.execute("insert into products (p_name,description, price) values ('" + p_name + "','" + description + "','"+ price+ "')");
            }
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }

    public void deleteProducts() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC&useSSL=false", "root", " ");) {
            if (product_id != 0 || p_name != null || !(p_name.isEmpty()) || description != null || !(description.isEmpty()) || price != 0) {
                Statement st = conn.createStatement();

                st.execute("delete from products where products.product_id = '" + product_id + "'");
                st.execute("delete from sale where sale.product_id = '" + product_id + "'");
                st.execute("update customer set product_id = '" + 0 + "',sell = '" + null + "'");

            }
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }

    public void updateProducts() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC&useSSL=false", "root", " ");) {
            if (product_id != 0 && p_name != null && !(p_name.isEmpty()) && price != 0 && description != null && !(description.isEmpty())) {
                Statement st = conn.createStatement();
                st.execute("update products set p_name= '" + p_name + "', price= '" + price + "', description ='" + description + "' where product_id = '" + product_id + "'");
            } else if (product_id != 0 && p_name != null && !(p_name.isEmpty())) {
                Statement st = conn.createStatement();
                st.execute("update products set p_name = '" + p_name + "' where product_id = '" + product_id + "'");
            } else if (product_id != 0 && description != null && !(description.isEmpty())) {
                Statement st = conn.createStatement();
                st.execute("update products set description = '" + description + "'where product_id = '" + product_id + "'");
            } else if (product_id != 0 && price != 0) {
                Statement st = conn.createStatement();
                st.execute("update products set price= '" + price + "' where product_id = '" + product_id + "'");
            } else if (product_id != 0 && price != 0 && description != null && !(description.isEmpty())) {
                Statement st = conn.createStatement();
                st.execute("update products set price= '" + price + "', description ='" + description + "' where product_id = '" + product_id + "'");}
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }

    }
}
