package com.softuni.exodia.web.controllers;

import com.softuni.exodia.domain.models.service.DocumentServiceModel;
import com.softuni.exodia.domain.models.view.DocumentHomeViewModel;
import com.softuni.exodia.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final DocumentService documentService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") != null){
            modelAndView.setViewName("redirect:/home");
        }else {
            modelAndView.setViewName("index");
        }

        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") == null){
            modelAndView.setViewName("redirect:/login");
        }else {
            List<DocumentHomeViewModel> allDocuments =
                    this.documentService.findAllDocuments()
                    .stream()
                    .map(d -> this.modelMapper.map(d, DocumentHomeViewModel.class))
                    .collect(Collectors.toList());
            modelAndView.addObject("documents", allDocuments);
            modelAndView.setViewName("home");
        }

        return modelAndView;
    }
}
