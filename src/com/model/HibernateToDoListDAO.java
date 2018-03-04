package com.model;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.*;

import java.util.List;

/**
 * Created by tomerktzv on 04/03/2018.
 */
public class HibernateToDoListDAO implements IToDoListDAO {
    private static SessionFactory sessionFactory;
    private static HibernateToDoListDAO inst;

    private HibernateToDoListDAO() {
//        try {
////            sessionFactory = new AnnotationConfiguration().configure()
//        }
    }

    @Override
    public void createUser(Users user) throws exceptionsUsersTasks {

    }

    @Override
    public List<Tasks> listOfTasks(int id) {
        return null;
    }

    @Override
    public void editTask(int taskId) throws exceptionsUsersTasks {

    }

    @Override
    public void removeTask(int taskId) throws exceptionsUsersTasks {

    }
}
