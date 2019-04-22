package birthday.service.impl;

import birthday.entities.Reminder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.sql.Date;
import java.time.LocalDate;

public class ReminderServiceTest {

    private Reminder reminder1, reminder2, reminder3;
    @Inject
    private ReminderService reminderService;

    @Before
    public void test() {
        reminder1 = new Reminder();
        reminder2 = new Reminder();
        reminder1.setName("Test");
        reminder2.setName("test2");
        reminder1.setBirthdaydate(Date.valueOf(LocalDate.MIN));
        reminder2.setBirthdaydate(Date.valueOf(LocalDate.MAX));
        reminder1.setReminderdate(Date.valueOf(LocalDate.MAX));
        reminder2.setBirthdaydate(Date.valueOf(LocalDate.MIN));
        reminder1.setEveryyear(false);
        reminder2.setEveryyear(true);
    }

    @org.junit.Test
    public void createReminder() {
        if (reminderService != null) {
            System.out.println("Created: " + reminderService.createReminder(reminder1));
            System.out.println("Created: " + reminderService.createReminder(reminder2));
        } else {
            System.out.println("null");
        }
    }

    @org.junit.Test
    public void updateReminder() {
    }

    @org.junit.Test
    public void findReminder() {
    }

    @org.junit.Test
    public void deleteReminderId() {
    }

    @org.junit.Test
    public void getReminders() {
    }

    @org.junit.Test
    public void clearAll() {
    }
}