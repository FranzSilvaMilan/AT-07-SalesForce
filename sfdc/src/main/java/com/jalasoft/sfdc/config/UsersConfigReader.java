package com.jalasoft.sfdc.config;

import com.jalasoft.sfdc.entities.User;
import com.jalasoft.utils.JsonReader;
import org.apache.log4j.Logger;

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
        listAlias.add("admin user");listAlias.add("other role user");  listAlias.add("erick");
        listAlias.add("danny"); listAlias.add("franz");
        usersReader = new JsonReader(UsersConfigFileName);

        // ToDo update the following 2 lines

        for(String keys: listAlias){
            User userNew = new User();
            userNew.setUserName(usersReader.getKeyValue (keys, USER_NAME));
            userNew.setPassword(usersReader.getKeyValue (keys, USER_PASSWORD));
            mapUsers.put(keys,userNew);
        }

        /* review how to read the all the users from the SFDCUsers.json, and manage in a List or a Map or whenever
        you want to be able later to get the user according the alias
         */
        //user.setUserName(usersReader.getKeyValue (ADMIN_USER.toString(), USER_NAME));
        //user.setPassword(usersReader.getKeyValue(ADMIN_USER.toString(), USER_PASSWORD));
    }

    public User getUserByAlias(String userAlias) {
        //ToDo select the specific user by alias
        user = mapUsers.get(userAlias);
        return user;
    }
}
