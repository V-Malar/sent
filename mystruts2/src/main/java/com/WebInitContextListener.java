package com;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class WebInitContextListener
 *
 */
@WebListener
public class WebInitContextListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public WebInitContextListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context destroyed...");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		try {
			System.out.println("context initialized....");
			ServletContext application = sce.getServletContext();
			String path = application.getRealPath("/WEB-INF/lib/config.properties");
			Properties prop = new Properties();
			prop.load(new FileInputStream(path));
			// application.setInitParameter("prop", prop);
			application.setAttribute("prop", prop);
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/vastpro";
			String username = "root";
			String password = "Gs#ry!@99";
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vastpro", "root", "Gs#ry!@99");
			Connection con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
