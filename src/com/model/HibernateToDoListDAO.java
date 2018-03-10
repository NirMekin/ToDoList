package com.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateToDoListDAO implements IToDoListDAO {
    private static SessionFactory sessionFactory;
    private static HibernateToDoListDAO inst;

    private HibernateToDoListDAO() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory Creation Failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static HibernateToDoListDAO getInstance() {
        if (inst == null) inst = new HibernateToDoListDAO();
        return inst;
    }

    @Override
    public List<Tasks> listOfTasks(int id) {
        return null;
    }

    @Override
    public void editTask(String taskId, String taskName, String taskDesc, String taskCurrentStatus) throws exceptionsUsersTasks {
        Session sess = sessionFactory.openSession();
        System.out.println("Updating Task #" + taskId);
        sess.beginTransaction();
        Tasks task = sess.load(Tasks.class, new Integer(taskId));
        task.setTaskName(taskName);
        task.setDescription(taskDesc);
        task.setTaskCurrentStatus(taskCurrentStatus);
        sess.getTransaction().commit();
    }

    @Override
    public void removeTask(String taskId) throws exceptionsUsersTasks {
        Session sess = sessionFactory.openSession();
        System.out.println("Deleting Task #" + taskId);
        String findTask = "SELECT * FROM ToDoList.tasks WHERE taskId=" + taskId;
        try{
            Tasks task = (Tasks)sess.createNativeQuery(findTask).addEntity(Tasks.class).list().get(0);
            System.out.println("Found TASK " + task.getTaskName());
            sess.beginTransaction();
            sess.delete(task);
            sess.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }

    }

    @Override
    public Users signIn(Users user) throws exceptionsUsersTasks {
        Session sess = sessionFactory.openSession();
        List<Users>listOfUsers = null;
        String emailAddress = user.getEmailAddress();
        String pass = user.getPassword();
        String findUserQuery = "SELECT * FROM ToDoList.users WHERE email = '" + user.getEmailAddress() + "' AND password = '" + user.getPassword() + "'";
        System.out.println("*** " + findUserQuery);
        System.out.println("Email: " + user.getEmailAddress() + ", Password: " + user.getPassword());
        try {
            listOfUsers = (List<Users>)sess.createNativeQuery(findUserQuery).addEntity(Users.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }

        if (listOfUsers == null || listOfUsers.isEmpty()) {
            System.out.println("No user was found");
            throw new exceptionsUsersTasks("User does not exist");
        }
        else {
            System.out.println(listOfUsers.get(0).getFirstName());
            return listOfUsers.get(0);
        }

    }

    @Override
    public void register(Users user) throws exceptionsUsersTasks {
        Session sess = sessionFactory.openSession();
        System.out.println("Registering the following:\nEmail: " + user.getEmailAddress() + ", Password: " + user.getPassword());
        try {
            sess.beginTransaction();
            Query findUser = sess.createNativeQuery("SELECT * FROM ToDoList.users WHERE email = '" + user.getEmailAddress() + "' AND password = '" + user.getPassword() + "'");
            List<Users>listOfUsers = (List<Users>)findUser.list();
            if (listOfUsers == null || listOfUsers.isEmpty()) {
                sess.save(user);
                sess.getTransaction().commit();
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }

    }

    public List<Tasks> getTasks(Users user) throws exceptionsUsersTasks {
        Session sess = sessionFactory.openSession();
        List<Tasks>listOfTasks = null;
        System.out.println("Retrieving List of Tasks....");
        String getAllTasks = "SELECT * FROM ToDoList.Tasks WHERE userId = '" + user.getId() + " ORDER BY taskId'";
        try {
            listOfTasks = (List<Tasks>)sess.createNativeQuery(getAllTasks).addEntity(Tasks.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }

        if (listOfTasks == null || listOfTasks.isEmpty()) {
            System.out.println("User #" + user.getId() + " has no existing tasks");
            throw new exceptionsUsersTasks("User does not exist");
        }
        else {
            System.out.println(listOfTasks);
            return listOfTasks;
        }

    }

    public void createTask(Tasks task) throws exceptionsUsersTasks {
        Session sess = sessionFactory.openSession();
        System.out.println("Creating new task with ID: " + task.getTaskId() + "...");
        try {
            sess.beginTransaction();
            sess.save(task);
            sess.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }

    }


}
