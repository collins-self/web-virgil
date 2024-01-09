package main.java.com.collinsself.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/execute")
public class ExecuteServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Execute the Java program (JAR file)
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "GetLine.jar");
            Process process = processBuilder.start();
            int exitCode = process.waitFor(); // Wait for the process to complete
            if (exitCode == 0) {
                response.getWriter().write("GetLine.jar executed successfully.");
            } else {
                response.getWriter().write("GetLine.jar execution failed.");
            }
        } catch (IOException | InterruptedException e) {
            response.getWriter().write("Error executing Java program: " + e.getMessage());
        }
    }
}
