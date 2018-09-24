package com.masago.common;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class CmnLogger {

	/* リクエストが多重の場合、ログレベルを操作する */
	private Integer requestAllowanceCnt = 1;
	
	private static String FQCN = CmnLogger.class.getName();
	private static Logger logger = Logger.getLogger(CmnLogger.class);
	
    public void error(Object message) {
        logger.log(FQCN, Level.ERROR, message, null);
    }
    
    public void error(Object message, HttpSession session) {
    	error(message, null, session);
    }

    public void error(Object message, Throwable t) {
        logger.log(FQCN, Level.ERROR, message, t);
    }

    public void error(Object message, Throwable t, HttpSession session) {
    	if((Integer)session.getAttribute("requestCnt") > requestAllowanceCnt){
    		// リクエストが多重の場合はWARNで出力する
    		logger.log(FQCN, Level.WARN, message, t);
    	}else{
    		// リクエストがシングルの場合は通常通りERRORで出力する
    		logger.log(FQCN, Level.ERROR, message, t);
    	}
    }

    public void warn(Object message, Throwable t) {
        logger.log(FQCN, Level.WARN, message, t);
    }
    
    public void warn(Object message) {
        logger.log(FQCN, Level.WARN, message, null);
    }

    public void info(Object message) {
        logger.log(FQCN, Level.INFO, message, null);
    }

    public void debug(Object message) {
        logger.log(FQCN, Level.DEBUG, message, null);
    }

    public void debug(Object message, Throwable t) {
        logger.log(FQCN, Level.DEBUG, message, null);
    }
}
