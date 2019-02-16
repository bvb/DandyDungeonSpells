package ru.bvb;

import ru.bvb.oniongames.plugin.util.SpellEncoder;
import ru.bvb.oniongames.plugin.DungeonSpell;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Main
{

	public static void main(String[] args)
	{
		printSpellData(Dungeons.dungeonTwo);
		printRenewSpell(Dungeons.dungeonOne);

		printGenerateSpellCode(false, 9305, 22);
		printGenerateSpellCode(true, 9305, 22);
	}

	public static void printSpellData(String spellKey)
	{
		DungeonSpell dungeonSpell = new DungeonSpell();
		dungeonSpell.decodeKey(spellKey);

		OutputStream stdout = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(stdout, StandardCharsets.UTF_8);
		PrintWriter writer = new PrintWriter(osw, true);

		writer.println(dungeonSpell.getJSON());
	}

	public static void printRenewSpell(String spellKey)
	{
		DungeonSpell dungeonSpell = new DungeonSpell();
		dungeonSpell.decodeKey(spellKey);

		String newKey = dungeonSpell.generateNewKey();

		OutputStream stdout = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(stdout, StandardCharsets.UTF_8);
		PrintWriter writer = new PrintWriter(osw, true);

		if (newKey == null)
		{
			writer.println(Dungeons.ERROR_SPELL);
			return;
		}

		writer.println(newKey);
	}

	public static void printGenerateSpellCode(boolean isJP, int dungeonId, int dungeonLevel)
	{
		String newKey = SpellEncoder.generateRandomValidKey(isJP, dungeonId, dungeonLevel);

		OutputStream stdout = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(stdout, StandardCharsets.UTF_8);
		PrintWriter writer = new PrintWriter(osw, true);

		if (newKey == null)
		{
			writer.println(Dungeons.ERROR_SPELL);
			return;
		}
		writer.println(newKey);
	}
}
