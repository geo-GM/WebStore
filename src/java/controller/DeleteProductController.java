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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author User
 */
@Controller
public class DeleteProductController {
    
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String newD(Model model) throws ClassNotFoundException, SQLException {
        model.addAttribute("delete", new Product());
        model.addAttribute("newProducts", Product.allProducts());

        return "deleteProduct";
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public String dele(@ModelAttribute("delete") Product product, BindingResult result, ModelMap model) throws ClassNotFoundException, SQLException {

        product.deleteProducts();
        model.addAttribute("delete", new Product());
        model.addAttribute("newProducts", Product.allProducts());

        return "deleteProduct";

    }
    
}
