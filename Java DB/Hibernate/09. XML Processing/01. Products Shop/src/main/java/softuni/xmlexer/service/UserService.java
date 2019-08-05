package softuni.xmlexer.service;

import softuni.xmlexer.domain.dto.UserRootDto;
import softuni.xmlexer.domain.dto.UserSoldProductsWithBuyerRootDto;
import softuni.xmlexer.domain.dto.UsersAndProductsRootDto;

public interface UserService {

    void seedUsers(UserRootDto userRootDtos);

    UserSoldProductsWithBuyerRootDto getUsersWithAtLeastOneSuccessfullySoldProduct();

    UsersAndProductsRootDto getUsersAndSoldProducts();

}
