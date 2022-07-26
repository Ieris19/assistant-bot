package dev.ieris19.util;

import lib.ieris19.util.cli.TextColor;
import lib.ieris19.util.log.Log;
import lib.ieris19.util.properties.FileProperties;

import java.util.Scanner;

/**
 * Class container for the token
 */
public class Token {
	/**
	 * API token
	 */
	private static String TOKEN;

	static {
		try {
			TOKEN = FileProperties.getInstance("token").getProperty("api-token");
		} catch (IllegalArgumentException e) {
			Log.getInstance().error("There is no such property in the config file");
			Log.getInstance().info("Creating token property");
			Scanner input = new Scanner(System.in);
			Log.getInstance().info("Please enter your token");
			TextColor.print("Please enter your token ", TextColor.YELLOW);
			FileProperties.getInstance("sensitive").createProperty("api-token", input.nextLine());
			TOKEN = FileProperties.getInstance("sensitive").getProperty("api-token");
		}
	}

	/**
	 * Returns the token
	 */
	public static String get() {
		return TOKEN;
	}
}
