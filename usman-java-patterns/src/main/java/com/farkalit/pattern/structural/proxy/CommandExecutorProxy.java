/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.proxy;

/**
 *
 * @author 72010995
 */
public class CommandExecutorProxy implements CommandExecutor
{

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user, String pwd)
    {
        if ("Usman".equals(user) && "Usman123".equals(pwd))
        {
            isAdmin = true;
        }
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception
    {
        if (isAdmin)
        {
            System.out.println("Authenticated User: Going to run the command.");
            //if (!cmd.trim().startsWith("http"))
            //if (cmd.trim().startsWith("rm"))
            if (!cmd.trim().endsWith(".pdf"))
            {
                System.err.println("Error: Command ["+cmd+"] is not allowed for non-admin users.");
                //throw new Exception("Error: Command ["+cmd+"]is not allowed for non-admin users.");
            }
            else
            {
                executor.runCommand(cmd);
            }
        }
        else
        {
            System.out.println("Not Authenticated User.");
        }
    }

}
