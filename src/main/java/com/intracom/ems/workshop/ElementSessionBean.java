package com.intracom.ems.workshop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import org.apache.commons.validator.routines.InetAddressValidator;

@Stateless
@Local
public class ElementSessionBean implements ElementSession {
    @Resource(lookup = "java:jboss/datasources/ExampleDS")
    private DataSource dataSource;

    @Override
    public void addElement(String ip, double lon, double lat)
        throws ApplLogicException {
        if(!InetAddressValidator.getInstance().isValid(ip)) {
            throw new ApplLogicException("Not valid IP");
        }
        try(Connection con = dataSource.getConnection();) {
            try(Statement stmt = con.createStatement();) {
                // Thirteenth Exercise: Add an element in database
                // You have to write code that:
                // a) check if the same IP already exists in the database.
                // in that case you will thrown a ApplLogicException()
                // with the appropriate message.
                // If IP does not exist, then the appropriate insertions to
                // the database have to be done.
                // 
            }
            catch (SQLException exc) {
                exc.printStackTrace();
                throw new ApplLogicException(exc.getMessage());
            }
        }
        catch(SQLException exc)
        {
            throw new EJBException("Cannot obtain a database connection");
        }
    }
}
