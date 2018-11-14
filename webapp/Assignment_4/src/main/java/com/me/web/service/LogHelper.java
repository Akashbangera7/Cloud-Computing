package com.me.web.service;

import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogHelper {
    static Logger logger = Logger.getLogger("MyLog");
    static FileHandler fh;

    @Value("${logging.file}")
    static String logLocation;

    public static void logInfoEntry(String msg) throws Exception{
        fh = new FileHandler(logLocation);
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);            // the following statement is used to log any messages
        logger.info(msg);
    }

    /*
    public static void logErrorEntry(String msg) throws Exception{
        fh = new FileHandler("/opt/tomcat/logs/csye6225.log");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);            // the following statement is used to log any messages
        logger.log(new Level(""),msg);
    }*/

}