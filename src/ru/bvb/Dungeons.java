package ru.bvb;

import java.util.ArrayList;

public class Dungeons
{
	public static ArrayList<Integer> dungeonIDs = new ArrayList<>();
	public static ArrayList<String> dungeonNames = new ArrayList<>();

	public static int MIN_LEVEL = 1;
	public static int MAX_LEVEL = 99;

	public static String ERROR_SPELL = "{ \"error\": \"invalid spell\"}";

	public static void init()
	{
		//TODO add all dungeonIDs
		//https://dandydungeon.fandom.com/wiki/Dungeons
		//https://dandydungeon.fandom.com/wiki/Special_Dungeons
		//https://dandydungeon.fandom.com/wiki/List_of_Special_Events

		//by rarity:
		//2
		add(0, "TycoonTower of Tokyo");
		add(2302, "TycoonTower of NYC");
		add(0, "TycoonTower of Cairo");
		add(0, "TycoonTower of Paris");
		add(0, "TycoonTower of London");
		add(0, "MtGoldenest of Tokyo");
		add(0, "MtGoldenest of NYC");
		add(2202, "MtGoldenest of Cairo");
		add(0, "MtGoldenest of Paris");
		add(0, "MtGoldenest of London");
		add(0, "Gold wood of Tokyo");
		add(0, "Gold wood of NYC");
		add(0, "Gold wood of Cairo");
		add(0, "Gold wood of Paris");
		add(0, "Gold wood of London");

		//3
		add(0, "Gold Slime Tower");

		//4
		add(0, "Sliamond Tower");

		//5
		add(4405, "King Sliamond Tower");

		//1
		add(101, "Picnic Grove");
		add(201, "Goblin House");
		add(0, "Slimeville");
		add(401, "Skittery Park");
		add(0, "Spell Academy");

		//2
		add(5302, "Mimictown");
		add(0, "Boneboat");
		add(0, "Ghost House");
		add(0, "Flame Cave");

		//3
		add(0, "Samurai Dojo");
		add(0, "House of Nanjaro");
		add(0, "Weekends only");
		add(5403, "Royal Rat Trove");
		add(5603, "Aja's Tower");
		add(0, "Dragon Castle");
		add(0, "Fort Goblin");
		add(0, "Weird Woody Woods");
		add(1503, "Slimurai Hamlet");
		add(0, "Beegarden");
		add(0, "Sorcery School");
		add(0, "Previously aka Spell Academy");

		//4
		add(0, "King Ghost's Palace");
		add(0, "Mimiqueen's Villa");
		add(0, "Asparaguster's Ranch");
		add(6504, "Cap'n Bone's Big Boat");
		add(6204, "Fire Golem Cave");

		//5
		add(6705, "Mysterious Hard Labor Zone");
		add(9305, "Legendary Dragonkeep");
		add(4105, "Holy Thelomon Castle");
		add(3505, "Garbi Desert");

		//3
		add(0, "Morning Porkpark");
		add(3103, "Pignoon Paradise");
		add(0, "Bistro Porkpork");
		add(0, "Pignite Farm");

		//3
		add(1603, "Bonefield");
		add(8103, "Toilet Island");
		add(0, "Wacky Hanami Party");
		add(0, "Snowbytown Square");

		//4
		add(7003, "Mamayan Ruins");
		add(7103, "Heck Yeah High School");
		add(7203, "Turtle Bath");
		add(7303, "Crocodile Eighteen");
		add(1703, "Pumpkin Patch");

		//5
		add(4704, "Onion Hotel");
		add(4005, "Maestro Nobiyo's Farm");
		add(4505, "Danmaku Castle");
		add(5705, "Santa Flophouse");
		add(6005, "Lavender Avenue Shop");
		add(5905, "Raid Tower");
		add(4205, "Fort Supopon");

		add(4805, "Heaven's Door");
	}

	public static void add(Integer id, String name)
	{
		if (id == 0 || name.isEmpty())
		{
			return;
		}

		dungeonIDs.add(id);
		dungeonNames.add(name);
	}

	//TEST DATA BELOW

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

	//"Bonefield"
	//"Bonefield" 23h54m
	// Valid: BQT21YGTCIMYUPDN4J3AC589
	// Pharaoh Buddy!
}
