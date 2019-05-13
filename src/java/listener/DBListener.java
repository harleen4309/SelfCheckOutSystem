/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import db.DBConnection;
import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 */
@WebListener()
/**
 * class which creates and destroys conn at starting and end of application
 */
public class DBListener implements ServletContextListener {

    @Override
    /**
     * creates connection when application is started and sets it as attribute
     * for DAO class methods to use
     */
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext sc = sce.getServletContext();
        String driver = sc.getInitParameter("driver");
        String dbName = sc.getInitParameter("database");
        String username = sc.getInitParameter("dbusername");
        String password = sc.getInitParameter("dbpassword");
        String url = sc.getInitParameter("url");

        DBConnection dbConnectionObject = new DBConnection(driver, url, dbName, username, password);

        sc.setAttribute("conn", dbConnectionObject.getConnection());

    }

    @Override
    /**
     * gets the previously set connection and destroys it at the end of stopping
     * application
     */
    public void contextDestroyed(ServletContextEvent sce) {
        Connection conn = (Connection) sce.getServletContext().getAttribute("conn");
        DBConnection.closeJDBCObjects(conn, null);
    }
}
