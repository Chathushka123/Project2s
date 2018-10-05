/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.sql.*;

/**
 *
 * @author Samson
 */
public class MysqlConnection {

    static Connection con;
	
    public static Connection conn() throws Exception{
	if(con == null || con.isClosed()){
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thayagammediclinic","root","");
            return con;
        }
	else{
            return con;
	}
    }
	
    public boolean putData(String sql){
	try{
            Statement stmt = MysqlConnection.conn().createStatement();
            stmt.executeUpdate(sql);
            return true;
	}
        catch(Exception exc){
            exc.printStackTrace();
            return false;
	}
    }
	
    public ResultSet getData(String sql){
	try{
            Statement stmt = MysqlConnection.conn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
	}
	catch(Exception exc){
            exc.printStackTrace();
            return null;
	}
    }
	
    public boolean close(){
        try{
            if(!con.isClosed()){
                con.close();
                return true;
            }
	}
	catch(Exception exc){
            exc.printStackTrace();
	}
	return false;
    }
}
