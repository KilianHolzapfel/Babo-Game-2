package logger;

public interface LoggerIF {
	public void d(Object clazz, String message);
	public void t(Object clazz, String message);
	public void i(Object clazz, String message);
	public void w(Object clazz, String message);
	public void e(Object clazz, String message);
	public void f(Object clazz, String message);
	public void d(String clazz, String message);
	public void t(String clazz, String message);
	public void i(String clazz, String message);
	public void w(String clazz, String message);
	public void e(String clazz, String message);
	public void f(String clazz, String message);
}
