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
		add(2302, "TycoonTower of Tokyo ★★");
		add(2302, "TycoonTower of NYC ★★");
		add(2302, "TycoonTower of Cairo ★★");
		add(2302, "TycoonTower of Paris ★★");
		add(2302, "TycoonTower of London ★★");

		add(2202, "MtGoldenest of Tokyo ★★");
		add(2202, "MtGoldenest of NYC ★★");
		add(2202, "MtGoldenest of Cairo ★★");
		add(2202, "MtGoldenest of Paris ★★");
		add(2202, "MtGoldenest of London ★★");

		add(2102, "Gold wood of Tokyo ★★");
		add(2102, "Gold wood of NYC ★★");
		add(2102, "Gold wood of Cairo ★★");
		add(2102, "Gold wood of Paris ★★");
		add(2102, "Gold wood of London ★★");

		//3
		add(2403, "Gold Slime Tower ★★★");

		//4
		add(3404, "Sliamond Tower ★★★★");

		//5
		add(4405, "King Sliamond Tower ★★★★★");

		//1
		add(101, "Picnic Grove ★");
		add(201, "Goblin House ★");
		add(301, "Spell Academy ★");
		add(401, "Skittery Park ★");
		add(501, "Slimeville ★");

		//2
		add(5102, "Ghost House ★★");
		add(5202, "Flame Cave ★★");
		add(5302, "Mimictown ★★");
		add(5502, "Boneboat ★★");

		//3
		add(3303, "Samurai Dojo ★★★");
		add(3903, "House of Nanjaro(weekends) ★★★");
		add(5403, "Royal Rat Trove ★★★");
		add(5603, "Aja's Tower ★★★");
		add(9103, "Dragon Castle ★★★");
		add(1103, "Weird Woody Woods ★★★");
		add(1203, "Fort Goblin ★★★");
		add(1503, "Slimurai Hamlet ★★★");
		add(1403, "Beegarden ★★★");
		add(1303, "Sorcery School ★★★");

		//4
		add(6104, "King Ghost's Palace ★★★★");
		add(6204, "Fire Golem Cave ★★★★");
		add(6304, "Mimiqueen's Villa ★★★★");
		add(9204, "Asparaguster's Ranch ★★★★");
		add(6504, "Cap'n Bone's Big Boat ★★★★");

		//5
		add(6705, "Mysterious Hard Labor Zone ★★★★★");
		add(9305, "Legendary Dragonkeep ★★★★★");
		add(4105, "Holy Thelomon Castle ★★★★★");
		add(3505, "Garbi Desert ★★★★★");

		//3
		add(3803, "Morning Porkpark ★★★");
		add(3103, "Pignoon Paradise ★★★");
		add(2503, "Bistro Porkpork ★★★");
		add(3003, "Pignite Farm ★★★");

		//3
		add(1603, "Bonefield ★★★");
		add(8003, "Wacky Hanami Party ★★★");
		add(8103, "Toilet Island ★★★");
		add(5803, "Snowbytown Square ★★★");

		//4
		add(7003, "Mamayan Ruins ★★★★");
		add(7103, "Heck Yeah High School ★★★★");
		add(7203, "Turtle Bath ★★★★");
		add(7303, "Crocodile Eighteen ★★★★");
		add(1703, "Pumpkin Patch ★★★★");

		//5
		add(4704, "Onion Hotel ★★★★★");
		add(4005, "Maestro Nobiyo's Farm ★★★★★");
		add(4505, "Danmaku Castle ★★★★★");
		add(5705, "Santa Flophouse ★★★★★");
		add(6005, "Lavender Avenue Shop ★★★★★");
		add(5905, "Raid Tower ★★★★★");
		add(4205, "Fort Supopon ★★★★★");

		add(4805, "Heaven's Door ★★★★★");
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
}
