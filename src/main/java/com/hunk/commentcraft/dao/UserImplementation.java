package com.hunk.commentcraft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hunk.commentcraft.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserImplementation implements UserInterface{

    private EntityManager entityManager;

    @Autowired
    public UserImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u",User.class);
        List<User> users = query.getResultList();
        return users;
    }
}
