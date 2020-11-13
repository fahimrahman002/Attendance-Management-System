/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancemanagementsystem.Database;

import java.sql.Connection;

/**
 *
 * @author fahim
 */
public class DB_Connection {
public Connection conn = null;
    public DB_Connection() {
        conn = JConnection.connectdb();
    }
    
}
