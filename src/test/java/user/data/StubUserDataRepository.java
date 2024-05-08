package user.data;

import com.iesam.digitallibrary.features.user.domain.User;
import com.iesam.digitallibrary.features.user.domain.UserRepository;

import java.util.ArrayList;

public class StubUserDataRepository implements UserRepository {
    @Override
    public void save(User user) {

    }

    @Override
    public void delete(String dni) {

    }

    @Override
    public void modify(String dni, User user) {

    }

    @Override
    public ArrayList<User> obtains() {
        return null;
    }

    @Override
    public User obtain(String dni) {
        return null;
    }
}
