package com.ast;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Test;

public class DemoVisitorTest {

	@Test
	public void test1() {
		String path = "E:\\java\\git\\sshe\\src\\main\\java\\com\\ast\\DemoVisitor.java";
        CompilationUnit comp = JdtAstUtil.getCompilationUnit(path);  
          
        DemoVisitor visitor = new DemoVisitor();  
        comp.accept(visitor);  
    }
}
