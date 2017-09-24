/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livrariaonline.controle;

import com.livrariaonline.repositorio.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alexander.Silva
 */
@Controller
public class LoginControle {
    
    @Autowired
    private LivroRepositorio repositorio;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginControle(){
        
        ModelAndView model = new ModelAndView("Login");
        return model;
    }
}
