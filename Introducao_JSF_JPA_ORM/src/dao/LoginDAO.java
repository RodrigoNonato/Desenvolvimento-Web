package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DataConnect;

public class LoginDAO
{
	public static boolean validate(String user, String password)
	{
        Connection con = null;
        PreparedStatement ps = null;
 
        try
        {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("SELECT nome, senha FROM usuarios WHERE nome = ? and senha = ?");
            ps.setString(1, user);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next())
            {
                //resultado encontrado, significa entradas válidas
                return true;
            }
        }
        
        catch (SQLException ex)
        {
            System.out.println("Erro Login -->" + ex.getMessage());
            
            return false;
        }
        
        finally
        {
            DataConnect.close(con);
        }
        return false;
    }
}
