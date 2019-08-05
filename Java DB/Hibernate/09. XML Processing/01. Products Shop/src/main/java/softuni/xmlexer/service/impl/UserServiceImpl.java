package softuni.xmlexer.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.xmlexer.domain.dto.*;
import softuni.xmlexer.domain.entity.Product;
import softuni.xmlexer.domain.entity.User;
import softuni.xmlexer.repository.UserRepository;
import softuni.xmlexer.service.UserService;
import softuni.xmlexer.util.ValidatorUtil;

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
    public void seedUsers(UserRootDto userRootDtos) {
        List<UserSeedDto> users = userRootDtos.getUsers();

        for (UserSeedDto userSeedDto : users) {
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
    public UserSoldProductsWithBuyerRootDto getUsersWithAtLeastOneSuccessfullySoldProduct() {

        List<User> inputUsers = this.userRepository.getAllWithAtLeastOneSoldProductWithABuyer();

        List<UserSoldProductWithBuyerDto> result = new ArrayList<>();

        for (User user : inputUsers) {

            UserSoldProductWithBuyerDto dto = this.modelMapper.map(user, UserSoldProductWithBuyerDto.class);

            List<Product> soldProducts = user.getSold()
                    .stream()
                    .filter(x -> x.getBuyer() != null)
                    .collect(Collectors.toList());

            ProductSoldDto[] soldDtos = this.modelMapper.map(soldProducts, ProductSoldDto[].class);
            ProductSoldRootDto soldRootDto = new ProductSoldRootDto();
            soldRootDto.setProducts(soldDtos);

            dto.setSoldProducts(soldRootDto);

            result.add(dto);
        }
        UserSoldProductsWithBuyerRootDto users = new UserSoldProductsWithBuyerRootDto();
        users.setUsers(result);

        return users;
    }

    @Override
    public UsersAndProductsRootDto getUsersAndSoldProducts() {

        List<User> users = this.userRepository.getAllWithAtLeastOneSoldProduct();

        UsersAndProductsRootDto dto = new UsersAndProductsRootDto();

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

        dto.setUsers(List.of(dtos));

        return dto;
    }

}
