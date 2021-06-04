package com.izunatan.passwordsecurity.view;

import com.izunatan.passwordsecurity.model.User;
import com.izunatan.passwordsecurity.repository.UserRepository;
import com.izunatan.passwordsecurity.service.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor()
public class App {
    private final UserRepository userRepository;

    public void start() {
        User u1 = new User("Izuna", "lala");
        User u2 = new User("Lysfilia", "lala");
        User u3 = new User("MoonMoon", "nuggies");
        User u4 = new User("Reevon", "paladin");
        User u5 = new User("Healiete", "lala");
        User u6 = new User("Jevil", "rejected");

        List<User> users = new ArrayList<>(List.of(u1,u2,u3,u4,u5,u6));

        users.forEach(user -> user.setPassword(transformPassword(user.getPassword())));

        users.forEach(user -> userRepository.save(user));

        System.out.println("-".repeat(60));
        userRepository.findAll().forEach(user -> System.out.println(user.getUsername() + " - " + user.getPassword()));
        System.out.println("-".repeat(60));

        login();
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;

        System.out.print("Please enter your username: ");
        username = scanner.nextLine();
        System.out.print("Please enter your password: ");
        password = scanner.nextLine();

        loginAction(username, password);
    }


    private void loginAction(String username, String password) {
        User user = userRepository.findById(username).get();

        String modifiedPassword = transformPassword(password);

        if (user.getPassword().equalsIgnoreCase(modifiedPassword)) {
            System.out.println("WELCOME " + user.getUsername());
        } else {
            System.out.println("INVALID CREDENTIALS");
        }
    }

    private String transformPassword(String pw){
        Encoding encoding = new Encoding();
        Encryption encryption = new Encryption();
        Hashing hashing = new Hashing();
        HashingWithSalt hashingWithSalt = new HashingWithSalt();
        HashingWithBcrypt hashingWithBcrypt = new HashingWithBcrypt();
        Obfuscation obfuscation = new Obfuscation();

        String modifiedPW = pw;

        modifiedPW = hashing.hashingSHA512(pw);

        return modifiedPW;
    }
}
