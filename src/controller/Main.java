package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.CityDAO;
import dao.TeamDAO;
import model.City;
import model.Team;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		CityDAO citydao=new CityDAO();
		TeamDAO teamdao=new TeamDAO();
		City city=null;
		Team team=null;
		
		System.out.println("Enter the City Id");
		Long id=Long.parseLong(br.readLine());
		System.out.println("Enter the City Name:");
		String cityName=br.readLine();
		
		city=new City(id, cityName);
		
		System.out.println("Enter the team name:");
		String name=br.readLine();
		System.out.println("Enter the Coach name:");
		String coach=br.readLine();
		System.out.println("Enter the Captain name:");
		String captain=br.readLine();
		
		team=new Team(name, coach, captain, city);
		
		teamdao.createTeam(team);
		
		System.out.println("Team Details are:");
		System.out.println("Name \t Coach \t City");
		citydao.getDetails();
		
		System.out.println("Enter the city name to get the city details:");
		String cname=br.readLine();
		citydao.getCityByName(cname);
	}
}
