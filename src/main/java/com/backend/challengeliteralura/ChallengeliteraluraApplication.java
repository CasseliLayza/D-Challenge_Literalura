package com.backend.challengeliteralura;

import com.backend.challengeliteralura.principal.PrincipalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChallengeliteraluraApplication implements CommandLineRunner {
    @Autowired
    PrincipalService principalService;

    public static void main(String[] args) {
        SpringApplication.run(ChallengeliteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //PrincipalService principalService = new PrincipalService();
        principalService.muestraMenu();

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
