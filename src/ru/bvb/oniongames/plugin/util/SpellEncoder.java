package ru.bvb.oniongames.plugin.util;

import ru.bvb.oniongames.plugin.crypto.GiftSpell;

import java.text.ParseException;
import java.util.Date;
import java.util.Random;

public class SpellEncoder
{
	public static String FAKE_APP_ID = "6512bd43d9caa6e02c990b0a82652dca"; //Digest.md5(1 + "" + 1);
	public static long FAKE_SEED = 28L;
	public static long FAKE_SEED_JP = 42L;
	public static long FAKE_UNIX_TIME = 1550347678L * 1000L;

	public static boolean useFakeData = false;

	public static String generateAppId()
	{
		if (useFakeData)
		{
			return FAKE_APP_ID;
		}

		long l = new Date().getTime();
		int i = new Random().nextInt();
		return Digest.md5(l + "" + i);
	}

	public static long generateRandomSeed(boolean isJPSeed)
	{
		if (useFakeData)
		{
			return isJPSeed ? FAKE_SEED_JP : FAKE_SEED;
		}

		if (isJPSeed)
		{
			return (long) ((int) (Math.random() * 4000.0D));
		}
		return (long) ((int) (Math.random() * 36.0D));
	}

	public static long getTime()
	{
		if (useFakeData)
		{
			return FAKE_UNIX_TIME;
		}

		return new Date().getTime();
	}

	public static String generateRandomValidKey(boolean generateJPKey, int dungeonId, int dungeonLevel)
	{
		String appIdKey = generateAppId();
		long randomSeed = generateRandomSeed(generateJPKey);
		long unixTimeMs = getTime();

		return encode(appIdKey, randomSeed, dungeonId, dungeonLevel, unixTimeMs, generateJPKey);
	}

	public static String encode(String appIdKey, long randomSeed, int dungeonId, int dungeonLevel, long unixTimeMs, boolean generateJPKey)
	{
		if (appIdKey == null)
		{
			return null;
		}

		try
		{
			if (generateJPKey)
			{
				return GiftSpell.create_JP(appIdKey, randomSeed, dungeonId, dungeonLevel, unixTimeMs);
			}
			return GiftSpell.create_OTHER(appIdKey, randomSeed, dungeonId, dungeonLevel, unixTimeMs);
		} catch (ParseException e)
		{
			System.out.println(e);
			//e.printStackTrace();
		}
		return null;

	}
}
