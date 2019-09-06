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
 * @author Gorana
 */
@Controller
public class DeleteCustomerController {
    
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
    public String newFoorm(Model model) throws ClassNotFoundException, SQLException {
        model.addAttribute("delete", new Customer());
        model.addAttribute("newCustomers", Customer.allCustomers());

        return "deleteCustomer";
    }

    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
    public String deleting (@ModelAttribute("delete")  Customer customer, ModelMap model) throws ClassNotFoundException, SQLException {


        customer.delete();
        model.addAttribute("delete", new Customer());
        model.addAttribute("newCustomers", Customer.allCustomers());

        return "deleteCustomer";

    }
    
}
