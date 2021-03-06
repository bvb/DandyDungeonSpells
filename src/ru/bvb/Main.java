package ru.bvb;

import ru.bvb.oniongames.plugin.util.SpellEncoder;
import ru.bvb.oniongames.plugin.DungeonSpell;

public class Main
{
	private static String info = ""
	+ "returns spell info by spell code\n"
	+ "ZZZZ 1ZZ4 ZZZ Z ZZZZZ...\n"
	+ "\n"
	+ "returns spell with current date\n"
	+ "--renew ZZZZ 1ZZ4 ZZZ Z ZZZZZ\n"
	+ "-r ZZZZ 1ZZ4 ZZZ Z ZZZZZ\n"
	+ "\n"
	+ "prints out spellCodes from input isJapan, dungeonId, level, N times\n"
	+ "--create 0 424242 22 2\n"
	+ "-c 0 424242 22 2\n"
	+ "\n"
	+ "prints out spellCodes for all special dungeons isJapan, N times, level"
	+ "--all 0 42 22\n";

	public static void main(String[] args)
	{
		if (args == null)
		{
			return;
		}

		if (args.length == 0 || args[0].equals("--help") || args[0].equals("-h"))
		{
			System.out.println(info);
		}
		else if (tryToTest(args))
		{
			//ok
		}
		else if (tryToRenewSpell(args))
		{
			//ok
		}
		else if (tryToCreateSpell(args))
		{
			//ok
		}
		else if (tryToPrintAll(args))
		{
			//ok
		}
		else if (tryToDecodeSpell(args))
		{
			//ok
		}
	}

	private static boolean tryToTest(String[] args)
	{
		if (!(args[0].equals("--test") || args[0].equals("-t")))
		{
			return false;
		}

		String spellKey = "BQT21YGTCIMYUPDN4J3AC589";
		printTest(spellKey);
		return true;
	}

	private static boolean tryToRenewSpell(String[] args)
	{
		if (!(args[0].equals("--renew") || args[0].equals("-r")))
		{
			return false;
		}

		String spellKey = args[1];
		for (int i = 2; i < args.length; i++)
		{
			spellKey += args[i];
		}

		printRenewSpell(spellKey);
		return true;
	}

	private static boolean tryToCreateSpell(String[] args)
	{
		if (!(args[0].equals("--create") || args[0].equals("-c")) || args.length != 5)
		{
			return false;
		}

		boolean isJapan = Integer.parseInt(args[1]) != 0;
		int dungeonId = Integer.parseInt(args[2]);
		int level = Integer.parseInt(args[3]);
		int times = Integer.parseInt(args[4]);

		printGenerateSpellCodeNTimes(isJapan, dungeonId, level, times);

		return true;
	}

	private static boolean tryToDecodeSpell(String[] args)
	{
		String spellKey = args[0];
		for (int i = 1; i < args.length; i++)
		{
			spellKey += args[i];
		}

		printSpellData(spellKey);
		return true;
	}

	private static boolean tryToPrintAll(String[] args)
	{
		if (!args[0].equals("--all") || args.length != 4)
		{
			return false;
		}

		boolean isJapan = Integer.parseInt(args[1]) != 0;
		int level = Integer.parseInt(args[2]);
		int times = Integer.parseInt(args[3]);

		Dungeons.init();

		for (int i = 0; i < Dungeons.dungeonIDs.size(); i++)
		{
			int dungeonId = Dungeons.dungeonIDs.get(i);
			String dungeonName = Dungeons.dungeonNames.get(i);

			System.out.println(dungeonName);
			printGenerateSpellCodeNTimes(isJapan, dungeonId, level, times);
			System.out.println("");
		}

		return true;
	}

	public static void printSpellData(String spellKey)
	{
		String result = getSpellData(spellKey);
		System.out.println(result);
	}

	public static void printTest(String spellKey)
	{
		SpellEncoder.useFakeData = true;

		DungeonSpell spell = new DungeonSpell();
		spell.decodeKey(spellKey);
		String key = spell.generateNewKey();

		SpellEncoder.useFakeData = false;

		System.out.println(key);
		System.out.println(key.equals("879XFLENA08CETEPIS5B37E9"));
	}

	public static void printRenewSpell(String spellKey)
	{
		String result = getRenewSpell(spellKey);
		System.out.println(result);
	}

	public static void printGenerateSpellCodeNTimes(boolean isJP, int dungeonId, int dungeonLevel, int times)
	{
		for (int i = 0; i < times; i++)
		{
			String key = getGenerateSpellCode(isJP, dungeonId, dungeonLevel);
			System.out.println(key);
		}
	}

	public static String getSpellData(String spellKey)
	{
		DungeonSpell dungeonSpell = new DungeonSpell();
		dungeonSpell.decodeKey(spellKey);
		return dungeonSpell.getJSON();
	}

	public static String getRenewSpell(String spellKey)
	{
		DungeonSpell dungeonSpell = new DungeonSpell();
		dungeonSpell.decodeKey(spellKey);

		String newKey = dungeonSpell.generateNewKey();

		if (newKey == null)
		{
			return Dungeons.ERROR_SPELL;
		}
		return newKey;
	}

	public static String getGenerateSpellCode(boolean isJP, int dungeonId, int dungeonLevel)
	{
		String newKey = SpellEncoder.generateRandomValidKey(isJP, dungeonId, dungeonLevel);

		if (newKey == null)
		{
			return Dungeons.ERROR_SPELL;
		}
		return newKey;
	}
}
