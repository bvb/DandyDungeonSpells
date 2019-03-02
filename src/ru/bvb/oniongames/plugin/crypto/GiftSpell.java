package ru.bvb.oniongames.plugin.crypto;

import ru.bvb.oniongames.plugin.util.Digest;

import java.text.ParseException;
import java.util.Date;

public class GiftSpell
{
	public static long BaseUnixTimeForJP = 1420038000000L;
	public static long BaseUnixTimeForOTHER = 1420005600000L;
	public static String KeyForMD5 = "dydy";

	public GiftSpell()
	{
	}

	public static String create_JP(String appIdKey, long randomSeed, int dungeonId, int dungeonLevel, long timeStampMs) throws ParseException
	{
		String signature = appIdKey.substring(appIdKey.length() - 7).toLowerCase();
		long encodedTime = (new Date(timeStampMs).getTime() - BaseUnixTimeForJP) / 10000L;
		int randSeed = (int) randomSeed;
		long encodedSignature = Digest.str36ToLong(signature);
		long sigTimeEncoded = (encodedSignature + encodedTime) % 10000L;

		String partOne = Digest.stringWithFill(Digest.long71String_Hiragana(encodedSignature ^ encodedTime % 10L * 1000000L + encodedTime % 1000L * 1000L + encodedTime % 1000L), "る", 6);
		String partTwo = Digest.stringWithFill(Digest.long71String_Hiragana(encodedTime ^ (long) (randSeed * 1000 + randSeed % 1000)), "る", 4);
		String partThree = Digest.stringWithFill(Digest.long71String_Hiragana((long) ((int) ((long) dungeonId ^ sigTimeEncoded))), "る", 3);
		String partFour = Digest.stringWithFill(Digest.long71String_Hiragana((long) ((int) ((long) dungeonLevel ^ sigTimeEncoded % 1000L))), "る", 2);
		String partFive = Digest.stringWithFill(Digest.long71String_Hiragana((long) randSeed), "る", 2);
		String encodedKey = Digest.md5(partOne + partTwo + partThree + partFour + partFive + KeyForMD5);
		String resultSignature = Digest.stringWithFill(Digest.long71String_Hiragana(Digest.str36ToLong(encodedKey.substring(encodedKey.length() - 8))), "る", 7);
		return partOne + partTwo + partThree + partFour + partFive + resultSignature;
	}

	public static String create_OTHER(String appIdKey, long seed, int dungeonId, int dungeonLevel, long timestampMs) throws ParseException
	{
		String partOne = Digest.stringWithFillLeft(appIdKey.substring(appIdKey.length() - 7).toLowerCase(), "0", 7);
		String partTwo = Digest.stringWithFillLeft(Digest.long36String((long) (dungeonId / 100)), "0", 2);
		String partThree = Digest.stringWithFillLeft(Digest.long36String((long) (dungeonId % 100)), "0", 1);
		String partFour = Digest.stringWithFillLeft(Digest.long36String((long) dungeonLevel), "0", 2);

		long timestampOffset = (((new Date(timestampMs)).getTime() - BaseUnixTimeForOTHER) / 1000L) / 10L;
		String encodedTimestamp = Digest.stringWithFillLeft(Digest.long36String(timestampOffset), "0", 5);

		String resultShift = Digest.stringWithFillLeft(Digest.long36String(seed), "0", 1);

		String secondEncoded = shiftString_OTHER(encodedTimestamp, seed, true);
		String firstEncoded = shiftString_OTHER(partOne + partTwo + partThree + partFour, seed + timestampOffset, true);

		String threeParts = firstEncoded + secondEncoded + resultShift;
		String signature = Digest.md5(threeParts + KeyForMD5);
		signature = signature.substring(signature.length() - 6);

		return (threeParts + signature).toUpperCase();
	}


	public static Date getCreateDate_JP(String var0) throws ParseException
	{
		return new Date(getTimeInterval_JP(var0) * 10000L + BaseUnixTimeForJP);
	}

	public static Date getCreateDate_OTHER(String var0) throws ParseException
	{
		long var1 = Digest.str36ToLong(substring_OTHER(var0, 12, 17));
		return new Date(BaseUnixTimeForOTHER + var1 * 10000L);
	}

	public static int getDungeonID_JP(String var0)
	{
		long var1 = getTimeInterval_JP(var0);
		long var3 = getFolkCraftKey_JP(var0);
		return (int) (Digest.str71ToInt_Hiragana(var0.substring(10, 13).replaceAll("る", "")) ^ (var1 + var3) % 10000L);
	}

	public static int getDungeonID_OTHER(String source)
	{
		String first = substring_OTHER(source, 7, 9);
		String last = substring_OTHER(source, 9, 10);
		return (int) (100L * Digest.str36ToLong(first) + Digest.str36ToLong(last));
	}

	public static long getFolkCraftKey_JP(String source)
	{
		long var1 = getTimeInterval_JP(source);
		return Digest.str71ToInt_Hiragana(source.substring(0, 6).replaceAll("る", "")) ^ var1 % 10L * 1000000L + var1 % 1000L * 1000L + var1 % 1000L;
	}

	public static long getFolkCraftKey_OTHER(String paramString)
	{
		return Digest.str36ToLong(substring_OTHER(paramString, 0, 7));
	}

	public static int getLevel_JP(String var0)
	{
		long var1 = getTimeInterval_JP(var0);
		long var3 = getFolkCraftKey_JP(var0);
		return (int) (Digest.str71ToInt_Hiragana(var0.substring(13, 15).replaceAll("る", "")) ^ (var1 + var3) % 1000L);
	}

	public static int getLevel_OTHER(String paramString)
	{
		return (int) Digest.str36ToLong(substring_OTHER(paramString, 10, 12));
	}

	public static long getTimeInterval_JP(String var0)
	{
		long var1 = Digest.str71ToInt_Hiragana(var0.substring(15, 17).replaceAll("る", ""));
		return Digest.str71ToInt_Hiragana(var0.substring(6, 10).replaceAll("る", "")) ^ var1 * 1000L + var1 % 1000L;
	}

	private static int shiftAlphanumeric_OTHER(int var0, int var1)
	{
		byte var3 = 0;
		int var2;
		if (var0 >= 48 && var0 <= 57)
		{
			var2 = var0 - 48;
		} else if (var0 >= 97 && var0 <= 122)
		{
			var2 = var0 + 10 - 97;
		} else
		{
			var2 = var3;
			if (var0 >= 65)
			{
				var2 = var3;
				if (var0 <= 90)
				{
					var2 = var0 + 10 - 65;
				}
			}
		}

		int var4 = var2 + var1;

		while (true)
		{
			var1 = var4;
			if (var4 < 36)
			{
				while (var1 < 0)
				{
					var1 += 36;
				}

				return var1 < 10 ? (var1 + 48) : (var1 - 10 + 97);
			}

			var4 -= 36;
		}
	}

	private static String shiftString_OTHER(String var0, long var1, boolean shiftFlag)
	{
		char[] chars = var0.toCharArray();
//		int[] codePoints = new int[chars.length];

		for (int i = 0; i < chars.length; ++i)
		{
			var1 = simpleRand_OTHER(var1);
			int var6 = (int) (var1 % 36L);
			int var4 = chars[i];
			if (!shiftFlag)
			{
				var6 = -var6;
			}

			int result = shiftAlphanumeric_OTHER(var4, var6);
//			codePoints[i] = result;

			chars[i] = (char)result;
		}

		return fromCharCode(chars);
	}

	public static String fromCharCode(char[] chars) {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < chars.length; i++)
		{
			int codePoint = chars[i];
			stringBuilder.append((char)codePoint);
		}

		return stringBuilder.toString();
	}

	private static long simpleRand_OTHER(long paramLong)
	{
		return ((1103515245L * paramLong) + 12347L) % 0x80000000;
	}

	public static String substring_OTHER(String source, int beginIndex, int endIndex)
	{
		source = source.toLowerCase();
		String var5 =       source.substring(0, 12); //11 chars
		String var7 =       source.substring(12, 17); //5 chars
		String var0 =       source.substring(17, 18); //1 char
		String signature =  source.substring(18); //7 chars
		long var3 = Digest.str36ToLong(var0);
		var7 = shiftString_OTHER(var7, var3, false);
		var5 = shiftString_OTHER(var5, var3 + Digest.str36ToLong(var7), false);
		return (var5 + var7 + var0 + signature).substring(beginIndex, endIndex);
	}

	public static VerifyState verify_JP(String source)
	{
		source = source.replaceAll("\\s+", "");

		String paramString1 = source.substring(0, 6);
		String str1 = source.substring(6, 10);
		String str2 = source.substring(10, 13);
		String str3 = source.substring(13, 15);
		String str4 = source.substring(15, 17);
		String toCompareSig = source.substring(17);

		String encoded = Digest.md5(paramString1 + str1 + str2 + str3 + str4 + KeyForMD5);

		long sig = Digest.str36ToLong(encoded.substring(encoded.length() - 8));
		String toHiragana = Digest.long71String_Hiragana(sig);
		String toSource = Digest.stringWithFill(toHiragana, "る", 7);

		if (!toCompareSig.equals(toSource))
		{
			return VerifyState.NotMatchMD5;
		}
		return VerifyState.Normal;
	}

	public static VerifyState verify_OTHER(String source)
	{
		source = source.replaceAll("\\s+", "");

		if (source.length() != 24)
		{
			return VerifyState.Unknown;
		}
		source = source.toLowerCase();
		String firstPart = source.substring(0, 18);
		String signaturePart = source.substring(18);

		String result = Digest.md5(firstPart + KeyForMD5).toLowerCase();
		if (!result.substring(result.length() - 6).equals(signaturePart))
		{
			return VerifyState.NotMatchMD5;
		}
		return VerifyState.Normal;
	}
}
