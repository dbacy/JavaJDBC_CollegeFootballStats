package com.example.demo.Controllers;

import com.example.demo.Models.Team;
import com.example.demo.Models.YearlyStats;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//localhost:8080/nicknames?nickname
@Controller
public class IndexController {

    Connection con;

    public IndexController() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TeamInfo;";

        try {
            con = DriverManager.getConnection(url,"groot","*^(Fcd)14-0016*^");
        }catch (Exception except) {
            System.out.println(except.getMessage());
            SQLException ex = new SQLException("Connection Failed: " + except.getMessage());
        }
    }
    @RequestMapping("stats/{teamName}")
    public  String Statistics(@PathVariable String teamName, Model model) throws Exception {

        List<YearlyStats> stats = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT Name , Nickname, Year , Rushing_Yards, Receiving_Yards, Kickoff_Return_Yards," +
                    "Sacks, Interceptions, Attempted_PAT,Made_PAT,Attempted_FG, Made_FG " +
                    "       FROM Table_One" +
                    "       join Team_Stats on Table_One.Team_Id = Team_Stats.Team_Id ";
            if (teamName != null && teamName.length() > 0)
                query += "WHERE Nickname like '%" + teamName + "%' ";
            query += "ORDER BY Name";

            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                YearlyStats yearlyStats = new YearlyStats(results.getInt("Year"), results.getInt("Rushing_Yards"),
                        results.getInt("Receiving_Yards"), results.getInt("Kickoff_Return_Yards"),
                        results.getFloat("Sacks"), results.getInt("Interceptions"),
                        results.getInt("Attempted_PAT"), results.getInt("Made_PAT"),
                        results.getInt("Attempted_FG"), results.getInt("Made_FG"));
                stats.add(yearlyStats);
            }
        }catch (Exception except) {
            System.out.println(except.getMessage());
            SQLException ex = new SQLException("Connection Failed: " + except.getMessage());
        }
        model.addAttribute("title","College Football Statistics");
        model.addAttribute("stats",stats);
        model.addAttribute("teamName",teamName);
        return "stats";
    }


    @RequestMapping("nicknames")
    public  String Index(@RequestParam String nickname, Model model) throws Exception {

        List<Team> teams = new ArrayList<>();
        int firstPlayed = 0;

        try{
            Statement stmt = con.createStatement();
            String query = "SELECT Name, Nickname, First_Played, Conference FROM Table_One ";
            if(nickname != null && nickname.length() > 0)
                query += "WHERE Nickname like '%" + nickname + "%' ";
            query += "ORDER BY Name";

            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                firstPlayed += results.getInt("First_Played");
                Team team = new Team(results.getString("name"), results.getInt("First_Played"),
                        results.getString("Nickname"),results.getString("Conference"));
                teams.add(team);
            }
        }catch (Exception except) {
            System.out.println(except.getMessage());
            SQLException ex = new SQLException("Connection Failed: " + except.getMessage());
        }
        model.addAttribute("title", "College Football Teams");
        model.addAttribute("teams", teams);
        model.addAttribute("firstPlayed", firstPlayed);
        model.addAttribute("nickname",nickname);
        return "teams";
    }




}
