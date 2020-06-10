package com.example.lab3.data;

import com.example.lab3.data.model.LoggedInUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    Hashtable<String, String> DUMMY_CREDENTIALS = new Hashtable<String, String>() {{put("test","test");}};

    public Result<LoggedInUser> login(String username, String password) {

        try {
            if(DUMMY_CREDENTIALS.containsKey(username))
                if(DUMMY_CREDENTIALS.get(username).equals(password))
                {
                    LoggedInUser user =
                            new LoggedInUser(
                                    username, password
                            );
                    return new Result.Success<>(user);
                }

            return new Result.Error(new IOException("WrongCredentials"));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
