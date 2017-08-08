package app.services.implementations;

import app.dto.bindingModels.UserDto;
import app.dto.viewModels.*;
import app.models.User;
import app.repositories.UserRepository;
import app.services.contracts.UserService;
import app.utils.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDto user) {
        User u = DtoMappingUtil.convert(user, User.class);

        this.userRepository.saveAndFlush(u);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> entities = this.userRepository.findAll();
        List<UserDto> res = DtoMappingUtil.convert(entities, UserDto.class);
        return res;
    }

    @Override
    public List<SuccessSeller> getAllSuccessSellers() {
        List<User> users = this.userRepository.findAllSuccessSellers();
        List<SuccessSeller> sellers = DtoMappingUtil.convert(users, SuccessSeller.class);
        return sellers;
    }

    @Override
    public UsersContainer findAllUsersFourthTask() {
        UsersContainer usersContainer = new UsersContainer();
        List<User> users = this.userRepository.findAllUserWithAtleastOneSoldProduct();
        List<FourthTaskUser> resUsers = DtoMappingUtil.convert(users, FourthTaskUser.class);

        for (int i = 0; i < users.size(); i++) {
            SoldProductsContainerView container = new SoldProductsContainerView();
            List<FourthTaskProductViewModel> convertedProducts =
                    DtoMappingUtil.convert(users.get(i).getSoldProducts(), FourthTaskProductViewModel.class);
            container.setProducts(convertedProducts);
            container.setCount(convertedProducts.size());

            resUsers.get(i).setProductContainer(container);

        }


        usersContainer.setUsers(resUsers);
        usersContainer.setUserCount(resUsers.size());

        return usersContainer;
    }


}
