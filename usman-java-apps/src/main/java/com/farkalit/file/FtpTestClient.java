/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.file;

import java.io.*;
import java.text.*;
import java.util.*;
  
 
import org.apache.commons.net.ftp.*;
/**
 *
 * @author 72010995
 */
public class FtpTestClient {
    
    public final static int DEFAULT_FTP_PORT = 21;
     
    private FTPClient ftpc;
         
    public static void main(String[] args) {
     
         
        String[] host_names = {"vtsdevepms1.vtx.local", "10.1.1.2", "host.mycompany.com"};
        String[] user_names = {"sftp-dcw", "superuser", "hostuser"};
        String[] passwords =  {"RsXIlQA", "superpass", "hostpass"};
        String ftp_src_folder = "/tmp";
        String ftp_src_file = "DC-WASAReport.txt";
         
        for (int i = 0; i < 1; i++) {
            FtpTestClient.getFile(host_names[i], user_names[i],
                passwords[i], ftp_src_folder, ftp_src_file);
        }
    }
         
    public FtpTestClient(String host, String login, String passwd)
    throws Exception
    {
        this(host, String.valueOf(FtpTestClient.DEFAULT_FTP_PORT), login, passwd);
    }
    /**
     * Creates a new instance of FtpTestClient
     * 
     * 
     * @param host Server host name
     * @param port Server port number
     * @param login FTP login name
     * @param passwd FTP login password
     * @throws Exception if client create fails
     */
    public FtpTestClient(String host, String port, String login, String passwd)
    throws Exception
    {
        try {
            ftpc = new FTPClient();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
     
    /**
     * get a single file from the server. Destination filename is same as that
     * on server.
     *
     * @param server ftp server name
     * @param username ftp server login name
     * @param password ftp server password
     * @param folder source folder on the ftp server
     * @param fname file to be transferred
     * @return true if successful
     */
    public static boolean getFile(String server, String username,
            String password, String folder, String fname)
    {
        System.out.println("Reading file started now...");
        
        System.out.println("server:"+server);
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println("folder:"+folder);
        System.out.println("fname:"+fname);
        
        boolean status = false;
         
        FTPClient ftp = null;
        try {
            ftp = new FTPClient();
             
            ftp.connect( server );
            ftp.login( username, password );
             
            ftp.changeWorkingDirectory( folder );
             
            File file = new File(fname);
            FileOutputStream fos = new FileOutputStream( file );
             
            ftp.retrieveFile(fname, fos);
            fos.close();
             
            status = true;
             
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (Exception e) {}
        }
        System.out.println("Reading file finished.");
        return status;
    }
     
    public static void getAllFiles( String server,
            String username,
            String password,
            String folder,
            String destinationFolder,
            Calendar start,
            Calendar end ) {
        try {
            // Connect and logon to FTP Server
            FTPClient ftp = new FTPClient();
            ftp.connect( server );
            ftp.login( username, password );
            System.out.println("Connected to " +
                    server + ".");
            System.out.print(ftp.getReplyString());
             
            // List the files in the directory
            ftp.changeWorkingDirectory( folder );
            FTPFile[] files = ftp.listFiles();
            System.out.println( "Number of files in dir: " + files.length );
            DateFormat df = DateFormat.getDateInstance( DateFormat.SHORT );
            for( int i=0; i<files.length; i++ ) {
                Date fileDate = files[ i ].getTimestamp().getTime();
                if( fileDate.compareTo( start.getTime() ) >= 0 &&
                        fileDate.compareTo( end.getTime() ) <= 0 ) {
                    // Download a file from the FTP Server
                    System.out.print( df.format( files[ i ].getTimestamp().getTime() ) );
                    System.out.println( "\t" + files[ i ].getName() );
                    File file = new File( destinationFolder +
                            File.separator + files[ i ].getName() );
                    FileOutputStream fos = new FileOutputStream( file );
                    ftp.retrieveFile( files[ i ].getName(), fos );
                    fos.close();
                    file.setLastModified( fileDate.getTime() );
                }
            }
             
            // Logout from the FTP Server and disconnect
            ftp.logout();
            ftp.disconnect();
             
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
     
    /**
     * Gets all files which matches a specified file name template. The template
     * is a regular expression. 
     *
     * @param server ftp server name
     * @param username ftp server login name
     * @param password ftp server password
     * @param folder source folder on the ftp server
     * @param ftempl regular expression for file name
     * @return true if successful
     * @throws Exception if unable to connect and other problems.
     */
    public static boolean getFilesOfType(String server, String username,
            String password, String folder, String ftempl)
            throws Exception 
    {
        FTPClient ftp = null;
        boolean status = false;
         
        try {
            // Connect and logon to FTP Server
            ftp = new FTPClient();
            ftp.connect( server );
            ftp.login( username, password );
             
            // List the files in the directory
  
            ftp.changeWorkingDirectory( folder );
            FTPFile[] files = ftp.listFiles();
         
            // get files which match name template
            // at present just check for prefix
            for (int i = 0; i < files.length; i++) {
                /*
                 if (files[i].matches(ftempl)) {
                     
                }*/
            }
        } catch (Exception e) {
            throw e;
        }
         
        finally {
            // close connection
            if (ftp != null && ftp.isConnected()) {
                ftp.disconnect();
            }
        }
         
        return status;
    }
     
    /**
     * Upload a single file to the server. Destination filename is same as that
     * on server.
     *
     * @param server ftp server name
     * @param username ftp server login name
     * @param password ftp server password
     * @param folder source folder on the ftp server
     * @param fname file to be transferred
     * @return true if successful
     */
    public boolean putFile(String server, String username,
            String password, String folder, String fname)
    throws Exception {
        return false;
    }
     
    public void setMode(int type) {
         
    }
     
    public int getMode() {
        return -1;
    }
}
