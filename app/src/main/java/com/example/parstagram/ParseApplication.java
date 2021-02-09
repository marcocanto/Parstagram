package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register the parse model
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("VSAdxYX6vOkRHMV3PSlbpEoL1WxslzLaFRmIH2PH")
                .clientKey("UvEP72D8GxiS4SVsVk2qcwmM1PkprsI0DW8DHr6x")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
