package ru.bvb;

//import java.util.ArrayList;
//import java.util.HashMap;

public class Dungeons
{
	//public static ArrayList<Integer> dungeonIDs = new ArrayList<>();
	//public static HashMap<Integer, String> dungeonIDtoName = new HashMap<>();
	public static int MIN_LEVEL = 1;
	public static int MAX_LEVEL = 99;

	public static String ERROR_SPELL = "{ \"error\": \"invalid spell\"}";

	public static void init()
	{
		//TODO add all dungeonIDs
		//http://dandydungeon.wikia.com/wiki/Special_Dungeons
		add(9305, "Legendary Dragonkeep");
	}

	public static void add(Integer id, String name)
	{
//		dungeonIDs.add(id);
//		dungeonIDtoName.put(id, name);
	}

	//King Silamon Tower
	//U99V Y8A7 1H33 3SZY 9D35 F4E7
	//24 HOURS from 2019/02/04 09:11:30
	public static String dungeonOne = "U99V Y8A7 1H33 3SZY 9D35 F4E7";

	//Legendary Dragonkeep
	// 02h34m
	//8:14 AM - 8 Feb 2019
	/*spellDate = {Date@522} "Thu Feb 07 21:49:00 MSK 2019"
	dungeonId = 9305
	seed = 4367016040
	dungeonLevel = 1*/

	public static String dungeonTwo = "3WVM WPBG 69R7 2BD4 54C1 DAA2";

	//Legendary Dragonkeep
	//05h28m
	//4:53 PM - 7 Feb 2019
	/*
	spellDate = {Date@527} "Thu Feb 07 09:19:20 MSK 2019"
	dungeonId = 9305
	seed = 29096006409
	dungeonLevel = 1
	 */
	public static String dungeonThree = "TC1X 6BJR HOEM N434 CT03 37CE";

	//"King Sliamond Tower"
	//23h59m
	//10:30 PM - 6 Feb 2019
	public static String dungeonFour = "ECTE H1AS UUGW 89GY 6Y60 9931";

	//Legendary Dragonkeep
	// 23h59m
	// level 15
	public static String dungeonFive = "VJFL KZLO 6X7T 45HP H227 B3C8";

	//Legendary Dragonkeep
	//Danmaku Castle
	public static String dungeonSix = "FM8YVST18B1HFA7U7QE02C2B";
}
