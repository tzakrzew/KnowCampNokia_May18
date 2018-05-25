package com.aasec.controllers;


import com.aasec.pojos.Fruit;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



@RestController
public class HelloController {


    static Random rgen = new Random(System.currentTimeMillis());
    @GetMapping ("/getfruits")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Fruit> getNames ()
    {
        List<Fruit> list = new ArrayList();
        list.add(new Fruit.FruitBuilder("Frank","Apple").sweetness(6).size(5).build());
        list.add(new Fruit.FruitBuilder("Lidia","Watermelon").sweetness(30).size(20).build());
        list.add(new Fruit.FruitBuilder("Owen","Carrot").sweetness(2).size(4).build());
        list.add(new Fruit.FruitBuilder("Roman","Bannana").sweetness(10).size(5).build());
        list.add(new Fruit.FruitBuilder("Dorothy","Limon").sweetness(0).size(2).build());
        return  list;
    }

}
