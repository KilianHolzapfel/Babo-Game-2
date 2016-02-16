package logger;

public class Log{
	
	private static LoggerIF logger = null;
	
	static {
		setLoggerType(Logger.CONSOLE);
	}
	
	public static void setLoggerType(Logger loggerType){
		switch (loggerType){
		case CONSOLE:
			logger = new ConsoleLogger();
			break;
		}
	}

	public static void d(Object clazz, String message){
		if (logger != null)
			logger.d(clazz, message);
	}
	
	public static void t(Object clazz, String message){
		if (logger != null)
			logger.t(clazz, message);
	}
	
	public static void i(Object clazz, String message){
		if (logger != null)
			logger.i(clazz, message);
	}
	
	public static void w(Object clazz, String message){
		if (logger != null)
			logger.w(clazz, message);
	}
	
	public static void e(Object clazz, String message){
		if (logger != null)
			logger.e(clazz, message);
	}
	
	public static void f(Object clazz, String message){
		if (logger != null)
			logger.f(clazz, message);
	}
	
	public static void d(String string, String message){
		if (logger != null)
			logger.d(string, message);
	}
	
	public static void t(String string, String message){
		if (logger != null)
			logger.t(string, message);
	}
	
	public static void i(String string, String message){
		if (logger != null)
			logger.i(string, message);
	}
	
	public static void w(String string, String message){
		if (logger != null)
			logger.w(string, message);
	}
	
	public static void e(String string, String message){
		if (logger != null)
			logger.e(string, message);
	}
	
	public static void f(String string, String message){
		if (logger != null)
			logger.f(string, message);
	}
}
