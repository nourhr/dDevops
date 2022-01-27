package tn.esprit.spring;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {
	@Autowired
	IUserService us;

	@Test
	@Order(1)
	public void testRestrieveAllUsersFirst() {
		List<User> listUsers = us.retrieveAllUsers();
		int j = 0;
		for (int i = 0; i < listUsers.size(); i++) {
			j = j++;
		}
		Assertions.assertEquals(j, listUsers.size());
	}

	@Test
	@Order(2)
	public void testAddUser() throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date d = date.parse("2021-10-10");
		User u = new User("Nour", "Hermi", d, Role.INGENIEUR);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
	}

	@Test
	@Order(3)
	public void testRestrieveAllUsersSecond() {
		List<User> listUsers = us.retrieveAllUsers();
		int j = 0;
		for (int i = 0; i < listUsers.size(); i++) {
			j = j++;
		}
		Assertions.assertEquals(j, listUsers.size());
	}

	@Test
	@Order(4)
	public void testUpdateUser() throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date d = date.parse("2021-10-10");
		User u = new User(1L, "BenAmor", "Mouhammed", d, Role.INGENIEUR);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
	}

	@Test
	@Order(5)
	public void testRetrieveUser() {
		int l = 7 + us.retrieveAllUsers().size();
		User userRetieved = us.retrieveUser((long) l);
		Assertions.assertEquals(l, userRetieved.getId());
	}

	@Test
	@Order(6)
	public void testDeletUser() {
		int l = 7 + us.retrieveAllUsers().size();
		us.deleteUser((long) l);
		List<User> listUserss = us.retrieveAllUsers();
		int i = us.retrieveAllUsers().size() - 1;
		Assertions.assertEquals(i, listUserss.size());
	}
}
