package com.yogesh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogesh.models.Users;

@Repository
public class LoginDao{
 
 @Autowired
 SessionFactory sessionFactory;

 Session session = null;
 Transaction tx = null;


 public Users findByUserName(String username) {
  session = sessionFactory.openSession();
  tx = session.getTransaction();
  session.beginTransaction();
  Users user = (Users) session.load(Users.class, new String(username));
  tx.commit();
  return user;
 }

}

