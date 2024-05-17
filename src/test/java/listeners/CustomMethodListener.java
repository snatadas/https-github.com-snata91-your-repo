package listeners;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import java.util.List;

public class CustomMethodListener implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        // Implement logic to intercept and manipulate test methods
        // You can reorder, filter, or modify test methods as needed
        // Here's a simple example to print method names
        for (IMethodInstance method : methods) {
            System.out.println("Test Method: " + method.getMethod().getMethodName());
        }
        return methods;
    }
}

