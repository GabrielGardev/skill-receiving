package softuni.jsonexer.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.jsonexer.domain.dto.*;
import softuni.jsonexer.domain.entity.Product;
import softuni.jsonexer.domain.entity.User;
import softuni.jsonexer.repository.UserRepository;
import softuni.jsonexer.service.UserService;
import softuni.jsonexer.util.ValidatorUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ValidatorUtil validatorUtil, ModelMapper modelMapper, UserRepository userRepository) {
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        for (UserSeedDto userSeedDto : userSeedDtos) {
            if (!validatorUtil.isValid(userSeedDto)){
                this.validatorUtil.violations(userSeedDto)
                        .forEach(v -> System.out.println(v.getMessage()));
                continue;
            }

            User user = this.modelMapper.map(userSeedDto, User.class);

            this.userRepository.saveAndFlush(user);
        }
    }

    @Override
    public List<UserSoldProductWithBuyerDto> getUsersWithAtLeastOneSuccessfullySoldProduct() {

        List<User> users = this.userRepository.getAllWithAtLeastOneSoldProductWithABuyer();

        List<UserSoldProductWithBuyerDto> result = new ArrayList<>();

        for (User user : users) {

            UserSoldProductWithBuyerDto dto = this.modelMapper.map(user, UserSoldProductWithBuyerDto.class);

            List<Product> soldProducts = user.getSold()
                    .stream()
                    .filter(x -> x.getBuyer() != null)
                    .collect(Collectors.toList());

            ProductSoldDto[] soldProductDtos = this.modelMapper.map(soldProducts, ProductSoldDto[].class);

            dto.setSoldProducts(soldProductDtos);

            result.add(dto);

        }

        return result;
    }

    @Override
    public UsersAndProductsDto getUsersAndSoldProducts() {

        List<User> users = this.userRepository.getAllWithAtLeastOneSoldProduct();

        UsersAndProductsDto dto = new UsersAndProductsDto();

        dto.setUsersCount(users.size());

        UserSoldProductDto[] dtos = this.modelMapper.map(users, UserSoldProductDto[].class);

        for (int i = 0; i < dtos.length; i++) {

            UserSoldProductDto userSoldProductDto = dtos[i];

            User user = users.get(i);

            ProductsSoldDto productsSoldDto = new ProductsSoldDto();
            productsSoldDto.setCount(user.getSold().size());

            ProductSoldWithOrWithoutBuyer[] soldWithOrWithoutBuyers =
                    this.modelMapper.map(user.getSold(), ProductSoldWithOrWithoutBuyer[].class);
            productsSoldDto.setProducts(soldWithOrWithoutBuyers);

            userSoldProductDto.setSoldProducts(productsSoldDto);

        }

        dto.setUsers(dtos);

        return dto;
    }

}
