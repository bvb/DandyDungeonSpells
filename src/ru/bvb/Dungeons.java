package ru.bvb;

import java.util.ArrayList;

public class Dungeons
{
	public static ArrayList<Integer> dungeonIDs = new ArrayList<>();
	public static ArrayList<String> dungeonNames = new ArrayList<>();
	public static ArrayList<Integer> rarityIDs = new ArrayList<>();
	public static ArrayList<String> rarityNames = new ArrayList<>();

	public static String ERROR_SPELL = "{ \"error\": \"invalid spell\"}";

	public static void init()
	{
		//TODO add all dungeonIDs
		//https://dandydungeon.fandom.com/wiki/Dungeons
		//https://dandydungeon.fandom.com/wiki/Special_Dungeons
		//https://dandydungeon.fandom.com/wiki/List_of_Special_Events
		initDungeons();
		//rarity: from ★ to ★★★★★
		initRarity();
	}

	private static void initRarity()
	{
		rarityIDs.add(1);
		rarityIDs.add(2);
		rarityIDs.add(3);
		rarityIDs.add(4);
		rarityIDs.add(5);
		rarityNames.add("★");
		rarityNames.add("★★");
		rarityNames.add("★★★");
		rarityNames.add("★★★★");
		rarityNames.add("★★★★★");
	}

	private static void initDungeons()
	{
		add(1, "Picnic Grove");
		add(2, "Goblin House");
		add(3, "Spell Academy");
		add(4, "Skittery Park");
		add(5, "Slimeville");
		//06 X
		//07 X
		//08 X
		//09 X
		//10 X
		add(11, "Weird Woody Woods");
		add(12, "Fort Goblin");
		add(13, "Sorcery School");
		add(14, "Beegarden");
		add(15, "Slimurai Hamlet");
		add(16, "Bonefield");
		add(17, "Pumpkin Patch");
		//18 X
		//19 X
		//20 X
		add(21, "Gold wood of [Capital]");
		add(22, "MtGoldenest of [Capital]");
		add(23, "TycoonTower of [Capital]");

		add(24, "Gold Slime Tower");
		add(25, "Bistro Porkpork");

		add(26, "Rare 2 Woods");
		add(27, "Rare 2 Sewer");
		add(28, "Rare 2 Mansion");
		add(29, "Rare 2 Ruins");

		add(30, "Pignite Farm");
		add(31, "Pignoon Paradise");
		add(32, "Chez Pharaoh(Fragments)");
		add(33, "Samurai Dojo");
		add(34, "Sliamond Tower ");
		add(35, "Garbi Desert");
		add(36, "Twisty Misty Woods");
		add(37, "Poison City Sewer");

		add(38, "Morning Porkpark");
		add(39, "House of Nanjaro(weekends)");
		add(40, "Maestro Nobiyo's Farm");
		add(41, "Holy Thelomon Castle");
		add(42, "Fort Supopon");
		//43 X
		add(44, "King Sliamond Tower");
		add(45, "Danmaku Castle");
		//46 X
		add(47, "Onion Hotel");
		add(48, "Heaven's Door");
		//49 X
		//50 X
		add(51, "Ghost House");
		add(52, "Flame Cave");
		add(53, "Mimictown");
		add(54, "Royal Rat Trove");
		add(55, "Boneboat");
		add(56, "Aja's Tower");
		add(57, "Santa Flophouse");
		add(58, "Snowbytown Square");
		add(59, "Raid Tower");
		add(60, "Lavender Avenue Shop");
		add(61, "King Ghost's Palace");
		add(62, "Fire Golem Cave");
		add(63, "Mimiqueen's Villa");
		//64 X
		add(65, "Cap'n Bone's Big Boat");
		//66 X
		add(67, "Mysterious Hard Labor Zone");
		//68 X
		//69 X
		add(70, "Mamayan Ruins");
		add(71, "Heck Yeah High School");
		add(72, "Turtle Bath(weekends)");
		add(73, "Crocodile Eighteen");
		//74 X
		//75 X
		//76 X
		//77 X
		//78 X
		//79 X
		add(80, "Wacky Hanami Party");
		add(81, "Toilet Island");
		//82 X
		//83 X
		//84 X
		//85 X
		//86 X
		//87 X
		//88 X
		//89 X
		//90 X
		add(91, "Dragon Castle");
		add(92, "Asparaguster's Ranch ");
		add(93, "Legendary Dragonkeep");
		//94 X
		//95 X
		//96 X
		//97 X
		//98 X
		add(99, "Porto Pepperoni Warehouse #3");
		//100X
	}

	public static void add(Integer id, String name)
	{
		if (id == 0 || name.isEmpty())
		{
			return;
		}

		dungeonIDs.add(id*100);
		dungeonNames.add("("+id.toString()+")" + name);
	}
}
