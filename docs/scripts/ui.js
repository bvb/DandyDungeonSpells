'use strict';

//fill dungeon levels list
function fillCountOptionsList(listId, from, to) {
    for (var i = from; i <= to; i++) {
        $(listId).append('<option value="' + i + '">' + i + '</option>');
    }
}

function fillDungeonLevelsList(listId) {
    ru.bvb.Dungeons.init();

    var dungeonIDs = ru.bvb.Dungeons.dungeonIDs.array;
    var dungeonNames = ru.bvb.Dungeons.dungeonNames.array;

    for (var i = 0; i < dungeonIDs.length; i++) {
        var dungeonId = dungeonIDs[i];
        var dungeonName = dungeonNames[i];

        $(listId).append('<option value="' + dungeonId + '">' + dungeonName + '</option>');
    }
}

function printDecodeResult(spellCode)
{
    var $sp = $("#decode_spell");
    $("blockquote.decode_result").remove();
    $sp.append("<blockquote class='decode_result'><p>" + spellCode + "</p></blockquote>");
}

function printSpellGenerateResult(spellCodes)
{
    var $sp = $("#generate_spell");
    $("blockquote.generate_result").remove();

    for (var i = 0; i < spellCodes.length; i++) {
        var code = spellCodes[i];
        $sp.append("<blockquote class='generate_result'><p>" + code + "</p></blockquote>");
    }
}

//decode
$("#decode_spell_button").click(function (event) {
    var spellCode = $("#spellCodeField").val();
    var spellJSON = ru.bvb.Main.getSpellData(spellCode);
    printDecodeResult(spellJSON);
    event.preventDefault();
});

//renew
$("#renew_spell_button").click(function (event) {
    var spellCode = $("#spellCodeField").val();
    var newCode = ru.bvb.Main.getRenewSpell(spellCode);
    printDecodeResult(newCode);
    event.preventDefault();
});


$("#generate_spell_button").click(function (event) {

    var customDungeonId = parseInt($("#dungeonIdField").val());
    var dungeonId = !isNaN(customDungeonId) ? customDungeonId : parseInt($("#dungeonIdSelect").val());

    var isJP = $("#isJapanCode").prop('checked');
    var dungeonLevel = parseInt($("#dungeonLevelSelect").val());
    var count = parseInt($("#resultCodeCountSelect").val());

    var resultCodes = [];
    for (var i = 0; i < count; i++) {
        var newCode = ru.bvb.Main.getGenerateSpellCode(isJP, dungeonId, dungeonLevel);
        resultCodes.push(newCode);
    }

    printSpellGenerateResult(resultCodes);
    event.preventDefault();
});

fillCountOptionsList("#dungeonLevelSelect", 1, 99);
fillCountOptionsList("#resultCodeCountSelect", 1, 99);
fillDungeonLevelsList("#dungeonIdSelect");

//JS hack for correct int64 random generation
ru.bvb.oniongames.plugin.crypto.GiftSpell.simpleRand_OTHER = function (paramLong) {
    return new BigNumber(paramLong).multipliedBy(1103515245).plus(12347).mod(0x80000000).toNumber();
};

//EN codes generation is correct
//ru.bvb.Main.printTest("BQT21YGTCIMYUPDN4J3AC589");

//JP codes generation is wrong