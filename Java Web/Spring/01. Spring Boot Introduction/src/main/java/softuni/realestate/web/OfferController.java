package softuni.realestate.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.realestate.domain.models.binding.OfferFindBindingModel;
import softuni.realestate.domain.models.binding.OfferRegisterBindingModel;
import softuni.realestate.domain.models.service.OfferServiceModel;
import softuni.realestate.service.OfferService;

@Controller
public class OfferController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(){
        return "register.html";
    }

    @PostMapping("/register")
    public String registerConfirm(@ModelAttribute("model") OfferRegisterBindingModel model){
        try {
            offerService.registerOffer(modelMapper.map(model, OfferServiceModel.class));
        }catch (IllegalArgumentException e){
            e.printStackTrace();

            return "redirect:/register";
        }

        return "redirect:/";
    }

    @GetMapping("/find")
    public String find(){
        return "find.html";
    }

    @PostMapping("/find")
    public String findConfirm(@ModelAttribute("model") OfferFindBindingModel model){
        try {
            offerService.findOffer(model);
        }catch (IllegalArgumentException e){
            e.printStackTrace();

            return "redirect:/find";
        }

        return "redirect:/";
    }
}
