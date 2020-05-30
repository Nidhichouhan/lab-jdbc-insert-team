package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.City;
import model.Team;
import utility.ConnectionManager;

public class TeamDAO{
	public void createTeam(Team team) throws ClassNotFoundException, IOException, SQLException {
		Connection con=null;
		con=ConnectionManager.getConnection();
		String sql="INSERT INTO KABADDI(name,coach, captain, cityId, cityName)VALUES(?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		City city=team.getCity();
		
		pst.setString(1, team.getName());
		pst.setString(2, team.getCoach());
		pst.setString(3, team.getCaptain());
		pst.setLong(4, city.getCityId());
		pst.setString(5, city.getCityName());
		
		pst.executeUpdate();
		con.close();
		System.out.println("Team is created");
		}
}
