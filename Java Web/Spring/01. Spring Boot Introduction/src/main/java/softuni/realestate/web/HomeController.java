package softuni.realestate.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import softuni.realestate.domain.models.view.OfferViewModel;
import softuni.realestate.service.OfferService;
import softuni.realestate.utils.HtmlReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final OfferService offerService;
    private final HtmlReader htmlReader;
    private final ModelMapper modelMapper;

    public HomeController(OfferService offerService, HtmlReader htmlReader, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.htmlReader = htmlReader;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    @ResponseBody
    public String index() throws IOException {
        return this.prepareHtml();
    }


    private String prepareHtml() throws IOException {
        List<OfferViewModel> offers = offerService
                .findAllOffers()
                .stream()
                .map(o -> modelMapper.map(o, OfferViewModel.class))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        if (offers.size() == 0){
            sb.append("<div class=\"apartment\" style=\"border: red solid 1px\">")
                    .append("There aren't any offers!")
                    .append("</div>");

            return htmlReader
                    .readHtmlFile("C:\\Users\\Freeware Sys\\Projects\\Java Web - January 2019\\Spring\\01. Spring Boot Introduction\\src\\main\\resources\\static\\index.html")
                    .replace("{{offers}}", sb.toString().trim());
        }

        for (OfferViewModel offer : offers) {
            sb
                    .append("<div class=\"apartment\">")
                    .append("<p>Rent: ").append(offer.getApartmentRent()).append("</p>")
                    .append("<p>Type: ").append(offer.getApartmentType()).append("</p>")
                    .append("<p>Commission: ").append(offer.getAgencyCommission()).append("</p>")
                    .append("</div>");
        }

        return htmlReader
                .readHtmlFile("C:\\Users\\Freeware Sys\\Projects\\Java Web - January 2019\\Spring\\01. Spring Boot Introduction\\src\\main\\resources\\static\\index.html")
                .replace("{{offers}}", sb.toString().trim());
    }
}
