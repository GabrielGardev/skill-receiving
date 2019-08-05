package softuni.jsonexer.service;

import softuni.jsonexer.domain.dto.UserSeedDto;
import softuni.jsonexer.domain.dto.UserSoldProductWithBuyerDto;
import softuni.jsonexer.domain.dto.UsersAndProductsDto;

import java.util.List;

public interface UserService {

    void seedUsers(UserSeedDto[] userSeedDtos);

    List<UserSoldProductWithBuyerDto> getUsersWithAtLeastOneSuccessfullySoldProduct();

    UsersAndProductsDto getUsersAndSoldProducts();

}
