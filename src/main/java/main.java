import user.UserEntity;
import user.UserRepository;

public class main {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
//        ReviewEntity newReview = new ReviewEntity();
//        UserEntity newUser = new UserEntity(
//                "Artur",
//                "Krivooov",
//                "Artur@krivooov.com",
//                "arturk",
//                "+3725436432",
//                "password",
//                Date.valueOf("1986-05-06"),
//                "Tallinn, street"
//        );
//
//        userRepository.createUser(newUser);
        UserEntity oldUser = userRepository.getUser(1);
        System.out.println(oldUser.getFirstName());
    }
}
