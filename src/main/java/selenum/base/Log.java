package selenum.base;

import org.apache.logging.log4j.LogManager;


public class Log extends baseclass {

	public static org.apache.logging.log4j.Logger logger = LogManager.getLogger(Log.class.getName());

	public static void info(String message) {
		logger.info(message);
	}

	public static void warn(String message) {
		logger.warn(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void fatal(String message) {
		logger.fatal(message);
	}

}
