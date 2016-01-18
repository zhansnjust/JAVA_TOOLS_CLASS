package dymaticProxy;

import java.lang.reflect.Method;

public interface Advice {
	void beforeMethod(Method m);
	void afterMethod(Method m);
}
