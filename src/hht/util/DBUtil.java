package hht.util;

import java.sql.*;

public class DBUtil {

	private static Connection connection;
    
    private DBUtil() {}
 
    public static synchronized Connection getConnection() {
    	
        if (connection != null)
        {
            return connection;
        }
        else 
        {
            try 
            {
                // set the db url, username, and password
            	Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/hht";
                String username = "hht_user";
                String password = "Lemon123";

                // get and return the connection
                connection = DriverManager.getConnection(url, username, password);
                return connection;
            }
            catch (SQLException e) 
            {
                e.printStackTrace();
                return null;
            } 
            catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}            
        }
    }
    
    public static synchronized void closeConnection() {
        if (connection != null)
        {
            try 
            {
            	connection.close();
            }
            catch (SQLException e)
            {
            	System.out.println(e);
            } 
            finally
            {
            	connection = null;
            }
        }
    }
    
    // A utility method for working with strings that contain one or more apostrophes(')
    public static String fixDBString(String s) {
    	
    	// if the string is null, return it
    	if (s == null)
    		return s;
    	
    	// add an apostrophe before each existing apostrophe
    	StringBuilder sb = new StringBuilder(s);
    	for (int i=0; i < sb.length(); i++)
    	{
    		char ch = sb.charAt(i);
    		if (ch == 39)	// 39 is the ASCII code for an apostrophe
    			sb.insert(i++,  "'");
    	}
    	return sb.toString();
    }

}
