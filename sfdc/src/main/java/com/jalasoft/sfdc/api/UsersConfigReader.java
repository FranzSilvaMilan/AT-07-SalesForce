package com.jalasoft.sfdc.config;

import com.jalasoft.sfdc.constants.SFDCEnums;
import com.jalasoft.sfdc.entities.User;
import com.jalasoft.utils.JsonReader;
import org.apache.log4j.Logger;

import static com.jalasoft.sfdc.constants.SFDCEnums.UserType.ADMIN_USER;

/**
 * user config reader class.
 *
 * @author Silvia Valencia
 * @since 6/14/2018
 */
public final class UsersConfigReader {
    private Logger log = Logger.getLogger(getClass());

    private static final String ALIAS = "alias";
    private static final String USER_NAME = "user name";
    private static final String USER_PASSWORD = "user password";
    private static final String USER_TOKEN = "user token";
    private static final String GRANT_TYPE = "grant type";
    private static final String CLIENT_ID = "client id";
    private static final String CLIENT_SECRET = "client secret";

    private JsonReader usersReader;

    private User user = new User();

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
        usersReader = new JsonReader(UsersConfigFileName);

        // Get User credentials

        // ToDo update the following 2 lines
        /* review how to read all the users from the SFDCUsers.json, and manage in a List or a Map or whenever
        you want to be able later to get the user according the alias
         */
        user.setUserName(usersReader.getKeyValue(ADMIN_USER.toString(), USER_NAME));
        user.setPassword(usersReader.getKeyValue(ADMIN_USER.toString(), USER_PASSWORD));
        user.setUserToken(usersReader.getKeyValue(ADMIN_USER.toString(), USER_TOKEN));
        user.setGrantType(usersReader.getKeyValue(ADMIN_USER.toString(), GRANT_TYPE));
        user.setClientId(usersReader.getKeyValue(ADMIN_USER.toString(), CLIENT_ID));
        user.setClientSecret(usersReader.getKeyValue(ADMIN_USER.toString(), CLIENT_SECRET));
    }

    public User getUserByAlias(String userAlias) {
        //ToDo select the specific user by alias
        return user;
    }
}
