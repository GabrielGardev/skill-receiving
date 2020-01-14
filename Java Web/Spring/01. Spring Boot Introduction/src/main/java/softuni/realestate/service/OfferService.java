package softuni.realestate.service;

import softuni.realestate.domain.models.binding.OfferFindBindingModel;
import softuni.realestate.domain.models.service.OfferServiceModel;

import java.util.List;

public interface OfferService {

    void registerOffer(OfferServiceModel offerServiceModel);

    List<OfferServiceModel> findAllOffers();

    void findOffer(OfferFindBindingModel offerFindBindingModel);
}
