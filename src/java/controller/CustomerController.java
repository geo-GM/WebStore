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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Gorana
 */
@Controller
public class CustomerController {
    
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String newF(Model model) throws ClassNotFoundException, SQLException {
        model.addAttribute("newCustomers", Customer.allCustomers());

        return "customer";
    }
 
}
