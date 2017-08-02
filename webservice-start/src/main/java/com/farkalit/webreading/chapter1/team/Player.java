/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.team;

/**
 *
 * @author fusman
 */
public class Player {

    private String name;
    private String nickname;

    public Player()
    {
    }

    public Player(String name, String nickname)
    {
        setName(name);
        setNickname(nickname);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getNickname()
    {
        return nickname;
    }
}
