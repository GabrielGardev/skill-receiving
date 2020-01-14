package com.softuni.exodia.web.controllers;

import com.softuni.exodia.domain.models.binding.DocumentScheduleBindingModel;
import com.softuni.exodia.domain.models.service.DocumentServiceModel;
import com.softuni.exodia.domain.models.view.DocumentDetailsViewModel;
import com.softuni.exodia.domain.models.view.DocumentPrintViewModel;
import com.softuni.exodia.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class DocumentController {

    private final DocumentService documentService;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentController(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/schedule")
    public ModelAndView schedule(ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") != null){
            modelAndView.setViewName("schedule");
        }else {
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }

    @PostMapping("/schedule")
    public ModelAndView scheduleConfirm(@ModelAttribute DocumentScheduleBindingModel bindingModel,
                                        ModelAndView modelAndView){
        DocumentServiceModel serviceModel = this.documentService
                .scheduleDocument(this.modelMapper.map(bindingModel, DocumentServiceModel.class));

        if (serviceModel == null){
            throw new IllegalArgumentException("Document creation failed!");
        }
        modelAndView.setViewName("redirect:/details/" + serviceModel.getId());

        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") String id, ModelAndView modelAndView,
                                HttpSession session){
        if (session.getAttribute("username") != null){
            DocumentServiceModel documentServiceModel = this.documentService.findDocumentById(id);

            if (documentServiceModel == null){
                throw new IllegalArgumentException("Document not found!");
            }

            modelAndView.setViewName("details");

            DocumentDetailsViewModel model = this.modelMapper.map(documentServiceModel, DocumentDetailsViewModel.class);
            modelAndView.addObject("model", model);
        }else {
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }

    @GetMapping("/print/{id}")
    public ModelAndView print(@PathVariable("id") String id, ModelAndView modelAndView,
                              HttpSession session){
        if (session.getAttribute("username") != null){
            DocumentServiceModel documentServiceModel = this.documentService.findDocumentById(id);

            if (documentServiceModel == null){
                throw new IllegalArgumentException("Document not found!");
            }

            modelAndView.setViewName("print");

            DocumentPrintViewModel model = this.modelMapper.map(documentServiceModel, DocumentPrintViewModel.class);
            modelAndView.addObject("model", model);
        }else {
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
    }
    @PostMapping("/print/{id}")
    public ModelAndView printConfirm(@PathVariable("id") String id, ModelAndView modelAndView){
        if (!this.documentService.printDocumentById(id)){
            throw new IllegalArgumentException("Something went wrong!");
        }

        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }
}
