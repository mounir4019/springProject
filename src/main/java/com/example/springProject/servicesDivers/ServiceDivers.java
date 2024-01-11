package com.example.springProject.servicesDivers;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;
@Service
public class ServiceDivers {
       public static String generateRandomCode(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomCode = new StringBuilder();

        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomCode.append(characters.charAt(randomIndex));
        }

        return randomCode.toString();
    }
}
