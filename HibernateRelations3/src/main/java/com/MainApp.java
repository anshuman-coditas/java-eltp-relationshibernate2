package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Employee employee=new Employee();
        employee.setName("Ak");

        Account account=new Account();

        employee.setAccount(account);
        account.setEmployee(employee);

        session.save(employee);
        session.save(account);
        transaction.commit();
    }
}
