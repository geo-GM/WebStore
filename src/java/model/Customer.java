package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @Gorana Matuh
 */
public class Customer {

    
    private int id;
    private String name;
    private int age;
    private String address;
    private String [] products;
    private int product_id;
    private String sell;
    
    public int getId(){
    return id;
    }
    
    public String getName(){
    return name;
    }
    
    public int getAge(){
    return age;
    }
    public String getAddress(){
    return address;
    }
    
    public String[] getProducts(){
    return products;
    }
    
    public int getProduct_id(){
    return product_id;
    }
    public String getSell(){
    return sell;
    }
    
    public void setId(int id){
    this.id=id;
    }
    
    public void setName(String name){
    this.name=name;
    }
    
    public void setAge(int age){
    this.age=age;
    }
    
    public void setAddress(String address){
    this.address=address;
    }
    
    public void setProducts(String[] products){
    this.products=products;
    }
    public void setProduct_id(int product_id){
    this.product_id=product_id;
    }
    public void setSell(String sell){
    this.sell=sell;
    }
    
    
        public static String allCustomers() throws ClassNotFoundException, SQLException {
    StringBuilder all_customers = new StringBuilder();
    Class.forName("com.mysql.jdbc.Driver");
    
    try(java.sql.Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC&useSSL=false", "root", "itAkademija!1");){
    Statement st = conn.createStatement();
    st.executeQuery("select customer_id, name, age, address, product_id, sell from customer");
    ResultSet rs = st.getResultSet();
    while (rs.next()){
    all_customers.append("ID: "+ rs.getString("customer_id"));
    all_customers.append("\n");
    all_customers.append("Name: "+ rs.getString("name"));
    all_customers.append("\n");
    all_customers.append("Age: "+ rs.getString("age"));
    all_customers.append("\n");
    all_customers.append("Address: "+ rs.getString("address"));
    all_customers.append("\n");
    
    if(rs.getString("product_id")!=null&& rs.getString("sell")!=null){
    all_customers.append("Product ID: "+ rs.getString("product_id"));
    all_customers.append("\n");
    all_customers.append("Status: "+ rs.getString("sell"));}
    all_customers.append("\n\n");
    }
    } catch (SQLException ex){
    all_customers.append(ex.getMessage());
    }
    return all_customers.toString();
    }
    
    public void insertCustomer() throws ClassNotFoundException{
    Class.forName("com.mysql.jdbc.Driver");
    
    try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC&useSSL=false", "root", "itAkademija!1");){
    if (name != null&& !(name.isEmpty()) ){
    Statement st = conn.createStatement();
    st.execute("insert into customer (name,age, address) values ('" + name + "','" + age + "','"+ address+ "')");
    } 
    } catch (SQLException ex){
    System.out.println("Error in database connection: \n" + ex.getMessage());
    }
    }
    
    public void delete() throws ClassNotFoundException{
    Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC&useSSL=false", "root", "itAkademija!1");) {
            if (id!=0) {
                Statement st = conn.createStatement();
               
                st.execute("delete from customer where customer_id = '" + id+"'");
                st.execute("delete from sale where sale.customer_id = '" + id+"'");
                st.execute("update products set customer_id = '"+0+"',sell = '"+null+"'");
                
            }
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }
    
    public void update() throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC&useSSL=false", "root", "itAkademija!1");) {
            if(id!=0 && name!= null && !(name.isEmpty())&& age!=0 && address!= null&& !(address.isEmpty())){
            Statement st = conn.createStatement();
            st.execute("update customer set name= '"+ name+ "', age= '" + age+ "', address ='"+ address + "' where customer_id = '"+ id+"'");
            }
            else if(id!=0 && name!= null && !(name.isEmpty())&& age!=0){
            Statement st = conn.createStatement();
            st.execute("update customer set name= '"+ name+ "', age= '" + age+ "'");
            }
            else if(id!=0 && age!=0 && address!= null&& !(address.isEmpty())){
            Statement st = conn.createStatement();
            st.execute("update customer set age= '" + age+ "', address ='"+ address + "' where customer_id = '"+ id+"'");
            }
            else if(id!=0 && name!= null && !(name.isEmpty())){
            Statement st = conn.createStatement();
            st.execute("update customer set name= '"+ name+ "'");
            }else if (id!=0&& age!=0){
            Statement st = conn.createStatement();
            st.execute("update customer set age = '"+ age +"' where customer_id = '"+ id+"'");
            }else if(id!=0&& address!= null && !(address.isEmpty())){
            Statement st = conn.createStatement();
            st.execute("update customer set address = '"+ address+ "'where customer_id = '"+ id+"'");
            }
        } catch(SQLException ex){
        System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    
    }
}
