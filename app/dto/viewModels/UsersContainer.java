package app.dto.viewModels;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UsersContainer {
    @Expose
    private int userCount;
    @Expose
    private List<FourthTaskUser> users;

    public UsersContainer() {
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public List<FourthTaskUser> getUsers() {
        return users;
    }

    public void setUsers(List<FourthTaskUser> users) {
        this.users = users;
    }
}
