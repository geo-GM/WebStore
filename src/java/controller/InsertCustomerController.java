/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author User
 */
@Controller
public class InsertCustomerController {
    
    @RequestMapping(value = "/insertCustomer", method = RequestMethod.GET)
    public String newForm(Model model) throws ClassNotFoundException, SQLException {
        model.addAttribute("add", new Customer());
        model.addAttribute("newCustomers", Customer.allCustomers());

        return "insertCustomer";
    }
        @RequestMapping(value = "/insertCustomer", method = RequestMethod.POST)
    public String insertCustomer(@ModelAttribute("add") Customer customer, ModelMap model) throws ClassNotFoundException, SQLException, SQLException, SQLException, SQLException {
            
        customer.insertCustomer();
        model.addAttribute("add", new Customer());
        model.addAttribute("newCustomers", Customer.allCustomers());
       
        
        return "insertCustomer";

    }
    
}
