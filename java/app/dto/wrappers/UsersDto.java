package app.dto.wrappers;

import app.dto.add.UserAddDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersDto {
    @XmlElement(name = "user")
    private List<UserAddDto> users;

    public UsersDto() {
        this.users = new ArrayList<>();
    }

    public List<UserAddDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserAddDto> users) {
        this.users = users;
    }
}
