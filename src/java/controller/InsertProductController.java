/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import model.Product;
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
public class InsertProductController {
    
    @RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
    public String newForm(Model model) throws ClassNotFoundException, SQLException {
        model.addAttribute("add", new Product());
        model.addAttribute("newProducts", Product.allProducts());

        return "insertProduct";
    }

    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public String insertProduct(@ModelAttribute("add") Product product, ModelMap model) throws ClassNotFoundException, SQLException {

        product.insertProducts();
        model.addAttribute("add", new Product());
        model.addAttribute("newProducts", Product.allProducts());

        return "insertProduct";
    }
    
}
