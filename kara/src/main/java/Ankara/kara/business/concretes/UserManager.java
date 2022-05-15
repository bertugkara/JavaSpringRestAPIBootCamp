package Ankara.kara.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ankara.kara.business.abstracts.UserService;
import Ankara.kara.core.dataAccess.UserDao;
import Ankara.kara.core.entities.User;
import Ankara.kara.core.utilities.results.DataResult;
import Ankara.kara.core.utilities.results.Result;
import Ankara.kara.core.utilities.results.SuccessDataResult;
import Ankara.kara.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{


	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User Added");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email)
				,"User Founded");
	}


	

}
