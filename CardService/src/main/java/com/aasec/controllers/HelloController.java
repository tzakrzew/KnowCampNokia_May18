package com.aasec.controllers;


import com.aasec.pojos.Fruit;
import com.aasec.pojos.HeroCard;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.aasec.commons.SecAppConsts.CODE_VERSION;
import static com.aasec.commons.SecAppConsts.SECRET;


@RestController
public class HelloController {

    @Autowired
    private KeycloakRestTemplate template;

    static Random rgen = new Random(System.currentTimeMillis());
    @RequestMapping ("/hello")
    public String sayHello(@RequestParam(value="name") String name)
    {
        return "Hello " + name+ "\n Generation " + CODE_VERSION + " salute you! Jedi no: " + rgen.nextInt() + "\n";
    }

    @RequestMapping ("/tellmesecret")
    public String tellMeSecret ()
    {
        return SECRET;
    }

    @GetMapping ("/getherocards")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<HeroCard> getNames ()
    {
        List<HeroCard> list = new ArrayList();
        list.add(new HeroCard.HeroBuilder("Balin","Krasnolud").attack(35).defence(20).build());
        list.add(new HeroCard.HeroBuilder("Gandalf","Czarodziej").attack(40).defence(80).build());
        list.add(new HeroCard.HeroBuilder("Nawałka na Euro","Magik").attack(10).defence(140).build());
        return  list;
    }

    @GetMapping ("/magicfruits")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Fruit> getFruits()
    {
        ResponseEntity<Fruit[]> response = template.getForEntity("https://localhost:9071/getfruits", Fruit[].class);
        return Arrays.asList(response.getBody());
    }

}
