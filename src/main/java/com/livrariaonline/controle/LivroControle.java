/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livrariaonline.controle;

import com.livrariaonline.entidades.Livro;
import com.livrariaonline.repositorio.LivroRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alexander.Silva
 */
@Controller
@RequestMapping("/livros")
public class LivroControle {
    
    @Autowired
    private LivroRepositorio repositorio;

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getLivros() {

        ModelAndView model = new ModelAndView("ListaLivros");

        List<Livro> livros = repositorio.listaLivros();
        model.addObject("livros", livros);

        return model;

    }
}
