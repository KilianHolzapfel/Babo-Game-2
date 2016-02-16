package logger;

public class ConsoleLogger implements LoggerIF {

	@Override
	public void d(Object clazz, String message) {
		d(clazz.getClass().getSimpleName(), message);
	}

	@Override
	public void t(Object clazz, String message) {
		t(clazz.getClass().getSimpleName(), message);
	}

	@Override
	public void i(Object clazz, String message) {
		i(clazz.getClass().getSimpleName(), message);
	}

	@Override
	public void w(Object clazz, String message) {
		w(clazz.getClass().getSimpleName(), message);
	}

	@Override
	public void e(Object clazz, String message) {
		e(clazz.getClass().getSimpleName(), message);
	}

	@Override
	public void f(Object clazz, String message) {
		f(clazz.getClass().getSimpleName(), message);
	}

	@Override
	public void d(String clazz, String message) {
		System.out.println("<D> " + clazz + ": " +  message);
	}

	@Override
	public void t(String clazz, String message) {
		System.out.println("<T> " + clazz + ": " +  message);
	}

	@Override
	public void i(String clazz, String message) {
		System.out.println("<I> " + clazz + ": " +  message);
	}

	@Override
	public void w(String clazz, String message) {
		System.err.println("<W> " + clazz + ": " +  message);
	}

	@Override
	public void e(String clazz, String message) {
		System.err.println("<E> " + clazz + ": " +  message);
	}

	@Override
	public void f(String clazz, String message) {
		System.err.println("<F> " + clazz + ": " +  message);
	}
}
