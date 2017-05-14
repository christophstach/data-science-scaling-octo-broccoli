#!/bin/sh
# This file runs the jar file in the background and after a user logged out from the shell.
# A PID file will be created to determine if the program is already running.
SERVICE_NAME=TwitterClientService
PATH_TO_JAR=/home/christoph/Projects/data-science-scaling-octo-broccoli/target/data-science-scaling-octo-broccoli-1.0-SNAPSHOT-jar-with-dependencies.jar
PID_PATH_NAME=/tmp/twitter-client-service-pid
case $1 in
    start)
        echo "Starting $SERVICE_NAME ..."
        if [ ! -f $PID_PATH_NAME ]; then
            nohup java -jar $PATH_TO_JAR /tmp 2>> /dev/null >> /dev/null &
                        echo $! > $PID_PATH_NAME
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
