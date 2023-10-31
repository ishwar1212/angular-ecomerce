package com.demo.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Model.User;
import com.demo.Repository.UserRepository;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    public User getUserById(Long id) {
//        User existingUser = userRepository.findById(id).orElse(null);
//      if(existingUser != null) {
//    	  existingUser.getFirstName();
//          existingUser.getLastName();
//          existingUser.getEmail();
//          existingUser.getBirthdate();
//          existingUser.getGender();
//      }
//        
//        
//        return userRepository.findById(id).orElse(null);
//    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setFirstName(updatedUser.getFirstName());
            // ... update other user attributes
            return userRepository.save(existingUser);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            userRepository.delete(existingUser);
            return true;
        }
        return false;
    }

	public User getUserByUserName(String userName) {
		User isExist = userRepository.getUserByUserName(userName);
		
		if(isExist != null) {
			isExist.getFirstName();
			isExist.getLastName();
			isExist.getEmail();
			isExist.getBirthdate();
			isExist.getBirthdate();
			isExist.getAddress();
		}
		
		return userRepository.getUserByUserName(userName);
	}
}

