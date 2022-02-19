package EatGood.service;

import EatGood.model.Status;
import EatGood.model.User;
import EatGood.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private final UserRepo userRepo;
    private RestTemplate restTemplate = null;

    public UserService(UserRepo userRepo, RestTemplate restTemplate) {
        this.userRepo = userRepo;
        this.restTemplate = restTemplate;
    }

    //Method to check login credentials
        public String LoginUser(String username, String password){
            String result = "FAILURE";

            log.info("User is: " + username);
            log.info("Password is: " + password);
            List<User> users = userRepo.findAll();
            log.info(userRepo.findAll().toString());


            for (User other : users) {
                if (other.getUsername().equals(username) && other.getPassword().equals(password)) {
                    log.info("********** USER FOUND ************");
                    result = "SUCCESS";
                }
            }
            return result;
        }

    //Method for creating user
        public String CreateUser(User userCreate){
            List<User> users = userRepo.findAll();
            log.info("NEW USER: " + userCreate.toString());

            for(User user : users){
                if(user.getUsername().equals(userCreate.getUsername()) || (user.getEmail().equals(userCreate.getEmail()))){
                    return "User Already Exists";
                }
            }
            userRepo.save(userCreate);
            return "SUCCESS";
        }

//    //Method for getting logged-in user
        public User getUserInfo(String Username, String Password) {
            List<User> users = userRepo.findAll();

            User LoggedInUser = null;
            for (User user : users) {
                if (user.getUsername().equals(Username) && user.getPassword().equals(Password)) {
                    LoggedInUser = user;
                    log.info(LoggedInUser.toString());
                }
            }
            return LoggedInUser;
        }

        //Method to updating user information
        public String updateUserInfo(long id, String name, String surname, String email, String username, String password){
            StringBuffer retBuf = new StringBuffer();

            List<User> users = userRepo.findById(id);

            if(users != null){
                for(User user : users){
                    user.setName(name);
                    user.setSurname(surname);
                    user.setEmail(email);
                    user.setUsername(username);
                    user.setPassword(password);
                    userRepo.save(user);
                }
            }
            retBuf.append("User data updated successfully");
            return  retBuf.toString();
        }
}
