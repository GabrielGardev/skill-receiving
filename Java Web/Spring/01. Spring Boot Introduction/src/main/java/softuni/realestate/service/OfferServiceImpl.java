package softuni.realestate.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.realestate.domain.entities.Offer;
import softuni.realestate.domain.models.binding.OfferFindBindingModel;
import softuni.realestate.domain.models.service.OfferServiceModel;
import softuni.realestate.repository.OfferRepository;

import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, Validator validator, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerOffer(OfferServiceModel offerServiceModel) {
        if (validator.validate(offerServiceModel).size() != 0){
            throw new IllegalArgumentException("Something went wrong!");
        }

        offerRepository.saveAndFlush(modelMapper.map(offerServiceModel, Offer.class));

    }

    @Override
    public List<OfferServiceModel> findAllOffers() {
        return offerRepository.findAll()
                .stream()
                .map(o -> modelMapper.map(o, OfferServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void findOffer(OfferFindBindingModel offerFindBindingModel) {
        if (validator.validate(offerFindBindingModel).size() != 0){
            throw new IllegalArgumentException("Something went wrong!");
        }

        OfferServiceModel offer = this.findAllOffers()
                .stream()
                .filter(o -> o.getApartmentType().toLowerCase()
                        .equals(offerFindBindingModel.getFamilyApartmentType().toLowerCase())
                && this.compareBudgetWithRent(offerFindBindingModel.getFamilyBudget(),
                        o.getApartmentRent(),
                        o.getAgencyCommission()) >= 0)
                .findFirst()
                .orElse(null);

        if (offer == null){
            throw new IllegalArgumentException("Something went wrong!");
        }
        Offer result = modelMapper.map(offer, Offer.class);
        this.offerRepository.delete(result);
    }

    private int compareBudgetWithRent(BigDecimal budget, BigDecimal rent, BigDecimal commissionPercent){
        BigDecimal commission = commissionPercent.divide(BigDecimal.valueOf(100)).multiply(rent);
        BigDecimal totalRent = rent.add(commission);
        return budget.compareTo(totalRent);
    }
}
