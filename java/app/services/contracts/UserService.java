package app.services.contracts;

import app.dto.add.UserAddDto;
import app.dto.bindingModels.UserDto;
import app.dto.viewModels.SellerView;
import app.dto.viewModels.UserView;

import java.util.List;

public interface UserService {

    void saveUser(UserAddDto userDto);

    List<UserDto> getAllUsers();

    List<SellerView> getSuccessfullySellers();

    List<UserView> findAllSuccessSellers();

}
