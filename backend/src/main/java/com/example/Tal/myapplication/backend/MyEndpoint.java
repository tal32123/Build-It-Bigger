/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Tal.myapplication.backend;

import com.example.JokeifyMe;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Tal.example.com",
                ownerName = "backend.myapplication.Tal.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    JokeifyMe jokeifyMe = new JokeifyMe();
    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    @ApiMethod(name = "getJoke")
    public MyBean getJoke(){
        MyBean joke = new MyBean();
        joke.setData(jokeifyMe.getJoke());

        return joke;
    }
}
