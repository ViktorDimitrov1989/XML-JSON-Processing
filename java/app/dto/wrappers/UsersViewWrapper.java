package app.dto.wrappers;

import app.dto.viewModels.UserView;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class UsersViewWrapper implements Serializable {

    @XmlElement(name = "user")
    private List<UserView> users;
    @XmlAttribute
    private int count;

    public UsersViewWrapper() {
        users = new ArrayList<>();
    }

    public List<UserView> getUsers() {
        return users;
    }

    public void setUsers(List<UserView> users) {
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
