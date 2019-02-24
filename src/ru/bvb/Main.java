package ru.bvb;

import ru.bvb.oniongames.plugin.util.SpellEncoder;
import ru.bvb.oniongames.plugin.DungeonSpell;

//import java.math.BigDecimal;

//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.nio.charset.StandardCharsets;

public class Main
{

	public static void main(String[] args)
	{
//		long d = 119106031;
//		System.out.println(d);
//		System.out.println(1103515245L * d);
//		System.out.println((1103515245L * d) + 12347L);
//		System.out.println(((1103515245L * d) + 12347L)& 0x7FFFFFFF );
//
//		System.out.println("-----------");
//
//		BigDecimal a = BigDecimal.valueOf(1103515245L);
//		BigDecimal offset = BigDecimal.valueOf(12347L);
//		BigDecimal mod = BigDecimal.valueOf(0x7FFFFFFF);
//		BigDecimal mod2 = BigDecimal.valueOf(0x80000000);
//
//		System.out.println(a);
//		System.out.println(offset);
//		System.out.println(mod);
//
//		BigDecimal bigInt = BigDecimal.valueOf(d);
//		System.out.println(bigInt);
//
//		bigInt = bigInt.multiply(a);
//		System.out.println(bigInt);
//
//		bigInt = bigInt.add(offset);
//		System.out.println(bigInt);
//
//		bigInt = bigInt.remainder(mod2);
//		System.out.println(bigInt);


		//bigInt.longValue();

		long d = 119106031;
		long rnd = generateSimpleRandom(d);
		System.out.println(rnd == 1643322622L);
		System.out.println(rnd);


		String str1;
		String str2;
		String str3;
		String str4;

		SpellEncoder.useFakeData = true;

		str1 = printSpellData(Dungeons.dungeonTwo);
		str2 = printRenewSpell(Dungeons.dungeonOne);

		str3 = printGenerateSpellCode(false, 9305, 22);
		str4 = printGenerateSpellCode(true, 9305, 22);

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		System.out.println("-------------");

		SpellEncoder.useFakeData = false;
		printGenerateSpellCodeNTimes(false, 9305, 22, 4);
	}

	public static String printSpellData(String spellKey)
	{
		DungeonSpell dungeonSpell = new DungeonSpell();
		dungeonSpell.decodeKey(spellKey);
		return dungeonSpell.getJSON();
	}

	public static String printRenewSpell(String spellKey)
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

	public static String printGenerateSpellCode(boolean isJP, int dungeonId, int dungeonLevel)
	{
		String newKey = SpellEncoder.generateRandomValidKey(isJP, dungeonId, dungeonLevel);

		if (newKey == null)
		{
			return Dungeons.ERROR_SPELL;
		}
		return newKey;
	}

	public static void printGenerateSpellCodeNTimes(boolean isJP, int dungeonId, int dungeonLevel, int times)
	{
		for (int i = 0; i < times; i++)
		{
			String key = printGenerateSpellCode(isJP, dungeonId, dungeonLevel);
			System.out.println(key);
		}
	}

	private static long generateSimpleRandom(long paramLong)
	{
//		BigInteger a = BigInteger.valueOf(1103515245L);
//		BigInteger offset = BigInteger.valueOf(12347L);
//		BigInteger mod = BigInteger.valueOf(0x7FFFFFFF);

//		BigDecimal a = BigDecimal.valueOf(1103515245L);
//		BigDecimal offset = BigDecimal.valueOf(12347L);
//		BigDecimal mod = BigDecimal.valueOf(0x80000000);

//		BigDecimal bigInt = BigDecimal.valueOf(paramLong);
//		bigInt = bigInt.multiply(a);
//		bigInt = bigInt.add(offset);
//		bigInt = bigInt.remainder(mod);

//		return bigInt.longValue();

		//return ((1103515245L * paramLong) + 12347L) & 0x7FFFFFFF;
		return ((1103515245L * paramLong) + 12347L) % 0x80000000;
	}
}
