package listeners;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;
import java.util.List;

public class CustomReporter implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        // Implement custom report generation logic here
        for (ISuite suite : suites) {
            String suiteName = suite.getName();
            System.out.println("Suite Name: " + suiteName);
            // Get results, test cases, etc. from ISuite and XmlSuite objects and generate reports
            // You can generate reports in various formats such as HTML, JSON, PDF, etc.
            // Save the reports to the specified output directory
        }
    }
}

