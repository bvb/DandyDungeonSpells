
<h2 align="center">DandyDungeon spell generator and decoder</h2>

## How to use

Open [Generator](https://bvb.github.io/DandyDungeonSpells/) and generate as many number of spell codes as you like!
Or use java console application.

## Warning

Japan spell codes does not work for web app(for now), use console application.

## Console application

**Get spell info by spell code**

```sh
java -jar ddspell.jar ZZZZ 1ZZ4 ZZZ Z ZZZZZ
```

**Get spell with current date**

```sh
java -jar ddspell.jar --renew ZZZZ 1ZZ4 ZZZ Z ZZZZZ
```

**Generate spell**
prints out spellCodes from input isJapan, dungeonId, level, N times
```sh
java -jar ddspell.jar --create 0 424242 22 2
```