package com.sy.controller;

import redis.clients.jedis.Jedis;

public class Study {

	public static void main(String[] args) throws Exception {
		/*
		 * String s = ""; int[] a = {1,3,4,6,9,8}; int[] b =
		 * {0,1,4,0,5,1,4,3,0,4,2}; for (int i : b) { s += a[i]; }
		 * System.out.println(s);
		 */

		String q = "123";
		String w = "123";
		String s = new String("2");
		String b = new String("2");
		System.out.println(q.equals(w));
		System.out.println(q == w);
		System.out.println(s == b);
		System.out.println(s.equals(b));

	}

}
