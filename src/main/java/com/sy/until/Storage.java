package com.sy.until;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sy.entity.NewOrder;
import com.sy.entity.User;

@Component
public class Storage {
	public static void main(String args[]) {
		Storage s = new Storage();
		User uuu = new User();
		uuu.setPassword("111");
		// s.addAttribute(uuu);
	}

	@PostConstruct
	public void initMethod() {
		User u = new User();
		u.setPassword("1");
		u.setPhone("12312312311");
		userMap.put("12312312311", u);
	}

	private static Storage s = new Storage();
	private static HashMap<String, User> userMap = new HashMap<String, User>();;
	private static Storage instance = new Storage();

	private Storage() {
		// userMap = new HashMap<String,User>();
	}

	public static Storage getInstance() {
		return instance;
	}

	public static HashMap<String, User> getUserMap() {
		return userMap;
	}

	// public static Storage s = new Storage();
	private static User user = new User();

	public static boolean addAttribute(User u) {
		// System.out.println(u.getPassword());
		// System.out.println("id:"+u.getIdnumber());
		if ((u.getPassword() != null) && (u.getPassword() != "")) {
			user.setPassword(u.getPassword());
		}

		if ((u.getPhone() != null) && (u.getPhone() != "")) {
			user.setPhone(u.getPhone());
		}

		/*
		 * if((u.getIdnumber()!=null)&&(u.getIdnumber()!="")){
		 * user.setIdnumber(u.getIdnumber()); }
		 * 
		 * if((u.getWallet()!=null)&&(u.getWallet()!="")){
		 * user.setWallet(u.getWallet()); }
		 * 
		 * if((u.getName()!=null)&&(u.getName()!="")){
		 * user.setName(u.getName()); }
		 * 
		 * if((u.getEmail()!=null)&&(u.getEmail()!="")){
		 * user.setEmail(u.getEmail()); }
		 */
		return true;
	}

	public static User getUser() {
		return user;
	}

	public User getUserByPhone(String phone) {

		if (userMap.get(phone) != null) {
			return userMap.get(phone);
		} else
			return null;
	}

	public boolean alterUser(String phone, User user) {
		// User user = new User();
		User u = new User();
		if ((userMap.containsKey(phone)) && (userMap.get(phone) != null)) {
			u = userMap.get(phone);
		} else {
			System.out.println("error altering user!");
			return false;
		}

		if ((user.getPassword() != null) && (user.getPassword() != "")) {
			u.setPassword(user.getPassword());
		}

		if ((user.getPhone() != null) && (user.getPhone() != "")) {
			u.setPhone(user.getPhone());
		}

		/*
		 * if((user.getUsername()!=null)&&(user.getUsername()!="")){
		 * u.setUsername(user.getUsername()); }
		 */
		/*
		 * if((user.getIdnumber()!=null)&&(user.getIdnumber()!="")){
		 * u.setIdnumber(user.getIdnumber()); }
		 * 
		 * if((user.getWallet()!=null)&&(user.getWallet()!="")){
		 * u.setWallet(user.getWallet()); }
		 * 
		 * 
		 * 
		 * if((user.getEmail()!=null)&&(user.getEmail()!="")){
		 * u.setEmail(user.getEmail()); }
		 * 
		 * if((user.getBankcard()!=null)&&(user.getBankcard()!="")){
		 * u.setBankcard(user.getBankcard()); }
		 * 
		 * if((user.getBankAddress()!=null)&&(user.getBankAddress()!="")){
		 * u.setBankAddress(user.getBankAddress()); }
		 */
		userMap.put(phone, u);
		return true;
	}

	public boolean checkUserList(String phone, String password) {
		if ((userMap.containsKey(phone)) && (userMap.get(phone) != null)
				&& (userMap.get(phone).getPassword().equals(password))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean tryRegister(String phone, User u) {
		if (!userMap.containsKey(phone)) {
			userMap.put(phone, u);
			System.out.println("registered");
			System.out.println(phone);
			System.out.println(userMap.size());
			System.out.println("all usermap");
			System.out.println(Storage.getUserMap().size());
			return true;
		} else {
			return false;
		}
	}

	public String export() {
		StringBuilder sb = new StringBuilder();
		for (User u : getInstance().userMap.values()) {
			sb.append(u.getPhone());
			sb.append("\t");
			/*
			 * sb.append(u.getUsername()); sb.append("\t");
			 */
			sb.append(u.getPassword());
			sb.append("\n\r");
			Iterator<NewOrder> orderI = u.getOrderList().iterator();
			while (orderI.hasNext()) {
				sb.append(orderI.next().getOrdernum());
				sb.append("\t");
			}
			sb.append("henglianorder\n\r");
		}
		return sb.toString();
	}

	public String exportJson() {
		StringBuilder sb = new StringBuilder();
		for (User u : getInstance().userMap.values()) {
			GsonBuilder builder = new GsonBuilder();
			// System.out.println(userInfo);
			Gson gson = builder.create();
			String abc = gson.toJson(u, User.class);
			// System.out.println(abc);
			sb.append(abc);
			sb.append("\n\r");
			Iterator<NewOrder> orderI = u.getOrderList().iterator();
			while (orderI.hasNext()) {
				sb.append(orderI.next().getOrdernum());
				sb.append("\t");
			}
			sb.append("\n\r");
		}
		return sb.toString();
	}

	private static HashMap<String, Integer> VerifyMap = new HashMap<String, Integer>();

	public static HashMap<String, Integer> getVerifyMap() {
		return VerifyMap;
	};
}