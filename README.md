# KnowCampNokia - May 2018 - Authentication and Authorization in Java Apps 

Materials from lecture about Authentication and Authorization in Java Apps using OpenID Connect and Keyclak.


## Content

SmallApp - Angular Frontend App 
CardService - Backend Service providing cards
FruitService - Backend Servince providing fruits

## Installation

1. Download and Install Keycloak
2. Add realm `mysecretcorpo` 
3. Add users
4. Add roles `cardcollector` and `fruitlover`
5. Assign role to users
6. Start CardService (see bellow how)
7. Start FuritService
8. Start SmallApp

Keycloak should be available under localhost:8443.
If not, change it in applicaiton.properties of applications and in initalizer of KeycloakService in SmallApp

## CardService

This is SpringBoot and Gradle app.
Go to main directory of app.
Add cert to local java truststore:
```
keytool -import -alias smallcorp -file src/main/resources/smallapp.cer -keystore $JAVA_HOME/jre/lib/security/cacerts
```
Add client to Keycloak:
* name: secretprovider
* Client Protocol: openid-connect
* Access Type: bearer-only

Start app:
./greadlew bootRun


## FruitService

This is SpringBoot and Gradle app.
Go to main directory of app.

Add client to Keycloak:
* name: fruitprovier
* Client Protocol: openid-connect
* Access Type: bearer-only

Start app:
./greadlew bootRun


## SmallApp

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.7.4.
Enter into src directory of SmallApp
Install dependencies:
```
npm install
```
Add client to Keycloak:
* name: account (existing one)
* Client Protocol: openid-connect
* Access Type: public
* Standard Flow: enabled
* Implicit Flow: enabled
* Valid redirects uri: http://localhost:4200/*
* Web origins: http://localhost:4200

then start server
```
ng serve
```

application should be available on http://localhost:4200

### Presentation from lecture

`Authentication and Authorization in Java Apps.pptx`


### Author

Tomasz Zakrzewski
