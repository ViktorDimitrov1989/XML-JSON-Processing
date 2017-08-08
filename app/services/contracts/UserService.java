package app.services.contracts;

import app.dto.bindingModels.UserDto;
import app.dto.viewModels.SuccessSeller;
import app.dto.viewModels.UsersContainer;

import java.util.List;

public interface UserService {
    void saveUser(UserDto user);

    List<UserDto> getAllUsers();

    List<SuccessSeller> getAllSuccessSellers();

    UsersContainer findAllUsersFourthTask();

}
