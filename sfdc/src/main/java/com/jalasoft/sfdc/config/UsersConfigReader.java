package com.jalasoft.sfdc.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jalasoft.sfdc.entities.User;
import com.jalasoft.utils.JsonReader;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * user config reader class.
 *
 * @author Silvia Valencia
 * @since 6/14/2018
 */
public final class UsersConfigReader {
    private Logger log = Logger.getLogger(getClass());
    private ArrayList<String> listAlias;

    private static final String ALIAS = "alias";
    private static final String USER_NAME = "user name";
    private static final String USER_PASSWORD = "user password";
    private static final String USER_TOKEN = "user token";
    private static final String GRANT_TYPE = "grant type";
    private static final String CLIENT_ID = "client id";
    private static final String CLIENT_SECRET = "client secret";

    private JsonReader usersReader;

    private User user = new User();
    private static HashMap<String, User> mapUsers;

    private static UsersConfigReader instance;

    /**
     * Gets instance of UsersConfigReader.
     *
     * @return the current instance.
     */
    public static UsersConfigReader getInstance() {
        if (instance == null) {
            instance = new UsersConfigReader();
        }
        return instance;
    }

    /**
     * Reads values from json file.
     *
     * @param UsersConfigFileName - User file of configuration.
     */
    public void initialize(final String UsersConfigFileName) {
        log.info("UsersConfigReader initialize: Read the users settings from " + UsersConfigFileName);
        listAlias = new ArrayList<>();
        mapUsers = new HashMap<>();
        JsonParser parser = new JsonParser();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(UsersConfigFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonElement jsonElement = parser.parse(fileReader);
        String[] element = jsonElement.toString().replace("{", "").
                replace("}", "").split(",");
        for (String key : element) {

            if (key.contains(USER_NAME)) {
                String[] alias = key.split(":");
                listAlias.add(alias[0].substring(1, alias[0].length() - 1));
            }
        }
        usersReader = new JsonReader(UsersConfigFileName);
        // ToDo update the following 2 lines

        for (String keys : listAlias) {
            User userNew = new User();
            userNew.setUserName(usersReader.getKeyValue(keys, USER_NAME));
            userNew.setPassword(usersReader.getKeyValue(keys, USER_PASSWORD));
            userNew.setUserToken(usersReader.getKeyValue(keys, USER_TOKEN));
            userNew.setGrantType(usersReader.getKeyValue(keys, GRANT_TYPE));
            userNew.setClientId(usersReader.getKeyValue(keys, CLIENT_ID));
            userNew.setClientSecret(usersReader.getKeyValue(keys, CLIENT_SECRET));
            mapUsers.put(keys, userNew);
        }

        /* review how to read the all the users from the SFDCUsers.json, and manage in a List or a Map or whenever
        you want to be able later to get the user according the alias
         */
    }

    /**
     * Return the alias that has an user.
     *
     * @param userAlias is the alias of the user that his logged.
     * @return a user.
     */
    public User getUserByAlias(String userAlias) {
        //ToDo select the specific user by alias
        user = mapUsers.get(userAlias);
        return user;
    }
}
