package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.exception.PasswordNotMatchException;
import com.cg.exception.UserNotFoundException;
import com.cg.repository.IUserRepository;

	@Service
	public class IUserServiceImpl implements IUserService {

		@Autowired
		private IUserRepository uDao;
		
		
		@Override
		public boolean signIn(User user) throws UserNotFoundException {
			Boolean status= false;
//			Optional<User> resultUser= userRepository.findById(user.getUserId());
			Optional<User> resultBroker= Optional.of(uDao.findByEmail(user.getEmail()));
			if (resultBroker.isPresent()) {
				if((resultBroker.get().getPassword().equals(user.getPassword()))) 
				{
					status=true;

			} 
				else 
				
				throw new UserNotFoundException("User Not Found");
			}
			return status;
		}
		
		

		@Override
		public boolean  signOut(User user) throws UserNotFoundException {
			Boolean status=false;
			Optional<User> resultBroker=uDao.findById(user.getUserId());

			if (resultBroker.isEmpty()) {
				throw new UserNotFoundException("User Not Found");
			}
			else if(resultBroker.get().getPassword().equals(user.getPassword())) {
				 status = true;
			}
			return status;
		}
		



		@Override
		public List<User> getAllUsers() {
			// TODO Auto-generated method stub
			return uDao.findAll();
		}



		@Override
		public User getUserById(int userId) {
			// TODO Auto-generated method stub
			return uDao.findById(userId).get();
		}



		@Override
		public User getUserByEmail(String email) {
			// TODO Auto-generated method stub
			return uDao.findByEmail(email);
		}
		@Override
		public User changePassword(int userid, User user) throws UserNotFoundException, PasswordNotMatchException {

			Optional<User> resultUser=uDao.findById(user.getUserId());
			if(resultUser.isPresent()) {
					resultUser.get().setPassword(user.getPassword());
					return uDao.save(resultUser.get());
				
			}
			else
			{
				throw new UserNotFoundException("User Not Found");
			}	

	}
}
