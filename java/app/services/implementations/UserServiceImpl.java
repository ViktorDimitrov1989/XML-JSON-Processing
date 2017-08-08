package app.services.implementations;

import app.dto.add.UserAddDto;
import app.dto.bindingModels.UserDto;
import app.dto.viewModels.ProductDtoView;
import app.dto.viewModels.SellerView;
import app.dto.viewModels.SoldProductView;
import app.dto.viewModels.UserView;
import app.dto.wrappers.ProductsViewWrapper;
import app.dto.wrappers.SoldProductsView;
import app.dto.wrappers.SoldProductsViewWrapper;
import app.models.User;
import app.repositories.UserRepository;
import app.services.contracts.UserService;
import app.utils.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void saveUser(UserAddDto userDto) {
        this.userRepository.saveAndFlush(DtoMappingUtil.convert(userDto, User.class));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();

        return DtoMappingUtil.convert(users, UserDto.class);
    }

    @Override
    public List<SellerView> getSuccessfullySellers() {
        List<User> users = this.userRepository.findAllUserWithAtleastOneSoldProduct();

        List<SellerView> sellers = DtoMappingUtil.convert(users, SellerView.class);

        for (SellerView seller : sellers) {
            SoldProductsView prod = new SoldProductsView();
            List<SoldProductView> soldProducts = DtoMappingUtil.convert(seller.getSoldProducts(), SoldProductView.class);

            prod.setProducts(soldProducts);

            seller.setProd(prod);
        }

        String debug = "";

        return sellers;
    }

    @Override
    public List<UserView> findAllSuccessSellers() {
        List<User> users = this.userRepository.findAllSuccessSellers();

        List<UserView> res = DtoMappingUtil.convert(users, UserView.class);

        for (UserView user : res) {
            SoldProductsViewWrapper productWrapper = new SoldProductsViewWrapper();
            productWrapper.setProducts(DtoMappingUtil.convert(user.getSoldProducts(), ProductDtoView.class));
            productWrapper.setCount(user.getSoldProducts().size());
            user.setProductsViewWrapper(productWrapper);
        }

        return res;
    }
}
