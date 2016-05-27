package javasist;

import javax.tools.ToolProvider;

public class JavaCompiler {
	public static void main(String[] args) {
		javax.tools.JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int run = compiler.run(null, null, null, null);
	}
}	
