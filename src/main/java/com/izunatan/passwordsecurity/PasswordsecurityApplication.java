package com.izunatan.passwordsecurity;

import com.izunatan.passwordsecurity.model.User;
import com.izunatan.passwordsecurity.repository.UserRepository;
import com.izunatan.passwordsecurity.service.*;
import com.izunatan.passwordsecurity.view.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@SpringBootApplication
@Component
public class PasswordsecurityApplication {
    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(PasswordsecurityApplication.class, args);
        new App(ac.getBean(UserRepository.class)).start();
    }
}
