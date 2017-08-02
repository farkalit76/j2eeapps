/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.team;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author fusman
 */
@WebService
public class Teams {

    private TeamsUtility utils;

    public Teams()
    {
        utils = new TeamsUtility();
        utils.make_test_teams();
    }

    @WebMethod
    public Team getTeam(String name)
    {
        return utils.getTeam(name);
    }

    @WebMethod
    public List<Team> getTeams()
    {
        return utils.getTeams();
    }
}
