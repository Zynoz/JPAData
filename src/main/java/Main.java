import birthday.entities.Reminder;
import birthday.service.impl.ReminderService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.test();
        main.createReminder();
    }

    private Reminder reminder1, reminder2, reminder3;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private EntityManager em = emf.createEntityManager();
    private ReminderService reminderService = new ReminderService();
    private EntityTransaction tx = em.getTransaction();

    private void test() {
        reminder1 = new Reminder();
        reminder2 = new Reminder();
        reminder1.setName("Test");
        reminder2.setName("test2");
        reminder1.setBirthdaydate(Date.valueOf(LocalDate.now()));
        reminder2.setBirthdaydate(Date.valueOf(LocalDate.now()));
        reminder1.setReminderdate(Date.valueOf(LocalDate.now()));
        reminder2.setReminderdate(Date.valueOf(LocalDate.now()));
        reminder1.setEveryyear(false);
        reminder2.setEveryyear(true);

        reminderService.setEntityManager(em);

        tx.begin();
        createReminder();
        getReminders();
        getAllNames();
        tx.commit();
    }

    public void createReminder() {
            System.out.println("Created: " + reminderService.createReminder(reminder1));
            System.out.println("Created: " + reminderService.createReminder(reminder2));
    }

    public void updateReminder() {
    }

    public void findReminder() {
    }

    public void deleteReminderId() {
    }

    public void getReminders() {
        System.out.println("output: " + reminderService.getReminders());
    }

    public void clearAll() {
        reminderService.clearAll();
    }

    public void getAllNames(){
        for (String s : reminderService.getNames()) {
            System.out.println(s);
        }
    }
}