/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.team;

import teamsC.TeamsService;
import teamsC.Teams;
import teamsC.Team;
import teamsC.Player;
import java.util.List;

/**
 *
 * @author fusman
 */
public class TeamClient {

    public static void main(String[] args)
    {
        TeamsService service = new TeamsService();
        teamsC.Teams port = service.getTeamsPort();
        List<Team> teams = port.getTeams();
        for (Team team : teams)
        {
            System.out.println("Team name: "+ team.getName()
                    + " (roster count:" + team.getRosterCount() + ")");
            for (Player player : team.getPlayers())
            {
                System.out.println(" Player: " + player.getNickname());
            }
        }
    }
}
