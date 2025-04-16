#!/bin/bash

# This is a sample shell script that can be used to deploy the web app into a local tomcat server. This
# file is added only for convenience and should be maintained in different repository.

# Define paths
TOMCAT_WEBAPPS="/c/Program Files/Apache Software Foundation/Tomcat 9.0/webapps"
WAR_SOURCE="/c/Users/hsemi/SamithaFiles/Repositories/WeatherInfo/WeatherInfoService/target/WeatherInfoService.war"
WAR_DEST="$TOMCAT_WEBAPPS/WeatherInfoService.war"
APP_FOLDER="$TOMCAT_WEBAPPS/WeatherInfoService"

# Delete existing WAR file if it exists
if [ -f "$WAR_DEST" ]; then
    echo "Deleting WAR file: $WAR_DEST"
    rm -f "$WAR_DEST"
else
    echo "WAR file not found: $WAR_DEST"
fi

# Delete existing exploded folder if it exists
if [ -d "$APP_FOLDER" ]; then
    echo "Deleting folder: $APP_FOLDER"
    rm -rf "$APP_FOLDER"
else
    echo "Folder not found: $APP_FOLDER"
fi



# Copy new WAR file
if [ -f "$WAR_SOURCE" ]; then
    echo "Copying WAR from $WAR_SOURCE to $TOMCAT_WEBAPPS"
    cp "$WAR_SOURCE" "$TOMCAT_WEBAPPS"
    echo "Deployment successful."
else
    echo "WAR source file not found: $WAR_SOURCE"
    exit 1
fi
