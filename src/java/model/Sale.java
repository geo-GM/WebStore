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
public class Sale {
    
    private int sale_id;
    private int s_customer_id;
    private int s_product_id;
    private String sold;
    
    public int getSale_id(){
    return sale_id;
    }
    
    public int getS_customer_id(){
    return s_customer_id;
    }
    
    public int getS_product_id(){
    return s_product_id;
    }
    
    public String getSold(){
    return sold;
    }
    
    public void setSale_id(int sale_id){
    this.sale_id=sale_id;
    }
    
    public void setS_customer_id(int s_customer_id){
    this.s_customer_id= s_customer_id;
    }
    
    public void setS_product_id(int s_product_id){
    this.s_product_id=s_product_id;
    }
    
    public void setSold(String sold){
    this.sold=sold;
    }
    
    public static String allSale() throws ClassNotFoundException, SQLException {
    StringBuilder all_sale = new StringBuilder();
    Class.forName("com.mysql.jdbc.Driver");
    
    try(java.sql.Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC&useSSL=false", "root", " ");){
    Statement st = conn.createStatement();
    st.executeQuery("select sale_id, customer_id, product_id, sold from sale");
    ResultSet rs = st.getResultSet();
    while (rs.next()){
    all_sale.append("Sale ID: "+ rs.getString("sale_id"));
    all_sale.append("\n");
    all_sale.append("Customer ID: "+ rs.getString("customer_id"));
    all_sale.append("\n");
    all_sale.append("Product ID: "+ rs.getString("product_id"));
    all_sale.append("\n");
    all_sale.append("Sold: "+ rs.getString("sold"));
    all_sale.append("\n");
    all_sale.append("\n");
    }
    } catch (SQLException ex){
    all_sale.append(ex.getMessage());
    }
    return all_sale.toString();
    }
    
    public void soldProduct() throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");
    try(java.sql.Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC&useSSL=false", "root", " ");){

    if (s_customer_id != 0 && s_product_id != 0) {
                Statement st = conn.createStatement();
                st.execute("insert into sale(customer_id, product_id, sold) values ('" + s_customer_id + "','" + s_product_id + "','" + sold + "')");
                st.execute("update customer set product_id = '"+s_product_id+"', sell = '"+sold+"'  where customer_id = '"+s_customer_id+"'");
                st.execute("update products set customer_id = '"+s_customer_id+"',sell = '"+sold+"' where product_id = '"+s_product_id+"'");
            }   
        }catch (SQLException ex){
    System.out.println("Error in database connection: \n" + ex.getMessage());
    }
    }
}
