#!/bin/sh
# This file runs the jar file in the background and after a user logged out from the shell.
# A PID file will be created to determine if the program is already running.
SERVICE_NAME=TwitterDataMiner
PATH_TO_JAR=./data-science-scaling-octo-broccoli-1.0.0-jar-with-dependencies.jar

# PID_PATH_NAME=/tmp/twitter-data-miner-german-stop-words-pid
# PID_PATH_NAME=/tmp/twitter-data-miner-germany-geo-pid
# PID_PATH_NAME=/tmp/twitter-data-miner-berlin-geo-pid

# CONFIG_FILE=./config.german-stop-words.yml
# CONFIG_FILE=./config.germany-geo.yml
# CONFIG_FILE=./config.berlin-geo.yml
case $1 in
    start)
        echo "Starting $SERVICE_NAME ..."
        if [ ! -f $PID_PATH_NAME ]; then
            nohup java -jar $PATH_TO_JAR $CONFIG_FILE & echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is already running ..."
        fi
    ;;
    stop)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stoping ..."
            kill $PID;
            echo "$SERVICE_NAME stopped ..."
            rm $PID_PATH_NAME
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
    status)
        if [ -f $PID_PATH_NAME ]; then
          PID=$(cat $PID_PATH_NAME);

          if ps -p $PID > /dev/null; then
            echo "$SERVICE_NAME is running with PID $PID."
          else
            echo "$SERVICE_NAME is not running but PID file $PID_PATH_NAME exists."
          fi
        else
          echo "$SERVICE_NAME is not running."
        fi
    ;;
    restart)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stopping ...";
            kill $PID;
            echo "$SERVICE_NAME stopped ...";
            rm $PID_PATH_NAME
            echo "$SERVICE_NAME starting ..."
            nohup java -jar $PATH_TO_JAR /tmp 2>> /dev/null >> /dev/null &
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
esac
