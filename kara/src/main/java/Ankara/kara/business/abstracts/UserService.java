package Ankara.kara.business.abstracts;

import Ankara.kara.core.entities.User;
import Ankara.kara.core.utilities.results.DataResult;
import Ankara.kara.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
    DataResult<User> findByEmail(String email);

}
