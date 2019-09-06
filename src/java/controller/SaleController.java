/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import model.Customer;
import model.Product;
import model.Sale;
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
public class SaleController {
    @RequestMapping(value = "/sale", method = RequestMethod.GET)
    public String newForm(Model model) throws ClassNotFoundException, SQLException {
        model.addAttribute("sale", new Sale());
        model.addAttribute("allSale", Sale.allSale());
        model.addAttribute("newCustomers", Customer.allCustomers());
        model.addAttribute("newProducts", Product.allProducts());

        return "sale";
    }
    
        @RequestMapping(value = "/sale", method = RequestMethod.POST)
    public String soldProducts(@ModelAttribute("sale") Sale sale, ModelMap model) throws ClassNotFoundException, SQLException {
            
        sale.soldProduct();
        model.addAttribute("sale", new Sale());
        model.addAttribute("allSale", Sale.allSale());
        model.addAttribute("newCustomers", Customer.allCustomers());
        model.addAttribute("newProducts", Product.allProducts());
       
        
        return "sale";
    }
    
}
