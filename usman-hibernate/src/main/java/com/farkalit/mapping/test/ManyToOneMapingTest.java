/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.mapping.test;

import com.farkalit.mapping.model.VoterAddress;
import com.farkalit.mapping.model.Voters;
import com.farkalit.util.HibSessionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author 72010995
 */
public class ManyToOneMapingTest {

    private static final SessionFactory sessionFactory = HibSessionManager.getSessionFactory();

    public static void main(String[] args) {

        try {
            Session session = sessionFactory.openSession();
            System.out.println("Session created");
            //start transaction
            Transaction tx = session.beginTransaction();

            VoterAddress addr = new VoterAddress("Jamia Nagar", "Delhi", "Delhi", "123123");
            //Save the Model object
            Voters vot1 = new Voters("V1", addr);
            Voters vot2 = new Voters("V2", addr);
            Voters vot3 = new Voters("V3", addr);

            session.save(vot1);
            session.save(vot2);
            session.save(vot3);
            //Commit transaction
            tx.commit();
            System.out.println("Voters ID=" + vot1.getVotId());
            //Get Saved Trasaction Data
            printTransactionData(vot1.getVotId(), sessionFactory);

            HibSessionManager.closeSessionFactory();
        } catch (Exception e) {
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (!sessionFactory.isClosed()) {
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }

    }

    private static void printTransactionData(Long id, SessionFactory sessionFactory) {
        try {
            Session session = sessionFactory.openSession();
            //start transaction
            Transaction tx = session.beginTransaction();
            //Save the Model object
            Voters voter = (Voters) session.get(Voters.class, id);
            //Commit transaction
            tx.commit();
            System.out.println("Voter Details=\n" + voter.toString());

        } catch (Exception e) {
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        }
    }

}
