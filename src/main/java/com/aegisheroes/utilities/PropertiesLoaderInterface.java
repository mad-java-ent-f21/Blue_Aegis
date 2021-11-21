package com.aegisheroes.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * This interface contains a default method that can be used anywhere a Properties
 * object is needed to be loaded.
 * @author RMichaelis
 *
 */

public interface PropertiesLoaderInterface {

    /**
     * This default method will load a properties file into a Properties instance
     * and return it.
     * @param propertiesFilePath a path to a file on the java classpath list
     * @return a populated Properties instance or an empty Properties instance if
     * the file path was not found.
     *
     * Note the "default" keyword
     */

    default Properties loadProperties(String propertiesFilePath){

        final Logger logger = LogManager.getLogger(this.getClass());

        Properties properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            logger.error("Database.loadProperties()...Cannot load the properties file", ioException);
            ioException.printStackTrace();
        } catch (Exception exception) {
            logger.error("Database.loadProperties()...", exception);
            exception.printStackTrace();
        }
        return properties;
    }
}
