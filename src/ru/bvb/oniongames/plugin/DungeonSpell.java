package ru.bvb.oniongames.plugin;

import ru.bvb.Dungeons;
import ru.bvb.oniongames.plugin.crypto.GiftSpell;
import ru.bvb.oniongames.plugin.crypto.VerifyState;
import ru.bvb.oniongames.plugin.util.SpellEncoder;

import java.text.ParseException;
import java.util.Date;

public class DungeonSpell
{
	private Date spellDate;
	private int dungeonId;
	private long seed;
	private int dungeonLevel;

	private boolean isValid = false;
	private boolean isJP = false;

	public DungeonSpell()
	{

	}

	public boolean decodeKey(String spellKey)
	{
		String source = spellKey.replaceAll("\\s+", "");

		VerifyState isValid;

		isValid = GiftSpell.verify_OTHER(source);
		if (isValid == VerifyState.Normal)
		{
			return decodeValidKey(source, false);
		}

		isValid = GiftSpell.verify_JP(source);
		if (isValid == VerifyState.Normal)
		{
			return decodeValidKey(source, true);
		}

		return false;
	}

	private boolean decodeValidKey(String source, boolean isJP)
	{
		try
		{
			if (isJP)
			{
				this.spellDate = GiftSpell.getCreateDate_JP(source);
				this.dungeonId = GiftSpell.getDungeonID_JP(source);
				this.seed = GiftSpell.getFolkCraftKey_JP(source);
				this.dungeonLevel = GiftSpell.getLevel_JP(source);
			}
			else
			{
				this.spellDate = GiftSpell.getCreateDate_OTHER(source);
				this.dungeonId = GiftSpell.getDungeonID_OTHER(source);
				this.seed = GiftSpell.getFolkCraftKey_OTHER(source);
				this.dungeonLevel = GiftSpell.getLevel_OTHER(source);
			}

			this.isJP = isJP;
			this.isValid = true;

		} catch (ParseException e)
		{
			this.isValid = false;
			//e.printStackTrace();
			return false;
		}

		return true;
	}

	public String generateNewKey()
	{
		String appIdKey = SpellEncoder.generateAppId();
		long randomSeed = SpellEncoder.generateRandomSeed(isJP);
		long unixTimeMs = SpellEncoder.getTime();

		return SpellEncoder.encode(appIdKey, randomSeed, dungeonId, dungeonLevel, unixTimeMs, isJP);
	}

	public String getJSON()
	{
		if (!isValid)
			return Dungeons.ERROR_SPELL;

//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
//		df.setTimeZone(TimeZone.getTimeZone("UTC"));
//		String dateAsISO = df.format(spellDate);

		long unixTimestamp = spellDate.getTime() / 1000L;

		String resultStr = "{";
		resultStr += "\"dungeon_id\": " + dungeonId + ", ";
		resultStr += "\"dungeon_name\": \"" + getDungeonName(dungeonId) + "\", ";
		resultStr += "\"level\": " + dungeonLevel + ", ";
		resultStr += "\"seed\": " + seed + ", ";
		resultStr += "\"timestamp\": " + unixTimestamp + ", ";
		resultStr += "\"localDate\": " + "\"" + spellDate + "\"";
		resultStr += "}";

//		return String.format("{\"dungeon_id\": %s, \"level\": %s, \"seed\": %s, \"timestamp\": %s, \"localDate\":\"%s\"}",
//				dungeonId, dungeonLevel, seed, unixTimestamp, spellDate);
		return resultStr;
	}

	public static String getDungeonName(int dungeonID)
	{
		for (int i = 0; i < Dungeons.dungeonIDs.size(); i++)
		{
			if (dungeonID == Dungeons.dungeonIDs.get(i))
			{
				return Dungeons.dungeonNames.get(i);
			}
		}

		return "UNKNOWN_DUNGEON";
	}

	public static String separateKey(String spellKey)
	{
		int SEP = 4;
		String result = "";

		if (spellKey.length() < SEP)
		{
			return spellKey;
		}

		for (int i = 0; i < spellKey.length(); i+=SEP)
		{
			result += spellKey.substring(i,i+SEP);

			if (i + SEP < spellKey.length())
			{
				result += " ";
			}
		}

		return result;
	}
}
