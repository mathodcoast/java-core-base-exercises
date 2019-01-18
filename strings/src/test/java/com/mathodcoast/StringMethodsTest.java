package com.mathodcoast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.mathodcoast.StringMethods.*;
import static org.junit.Assert.assertEquals;


@RunWith(JUnit4.class)
public class StringMethodsTest {

    @Test
    public void testConcatTwoStringsWithoutFirstLetters(){
        String str1 = "Mind";
        String str2 = "Control";

        String result = concatTwoStringsWithoutFirstLetters(str1,str2);
        assertEquals("indontrol",result);
    }

    @Test
    public void testCutNotEvenStringFromSides(){
        String str1 = "Litra";
        String str2 = "Malovato!";

        String result1 = cutNotEvenStringFromSides(str1);
        String result2 = cutNotEvenStringFromSides(str2);

        assertEquals("itr", result1);
        assertEquals("ova", result2);
    }

    @Test()
    public void testCutNotEvenStringFromSidesShortOrNotEvenString(){
        String evenString = "shodim";
        String shortString = "da";

        String result1 = cutNotEvenStringFromSides(evenString);
        String result2 = cutNotEvenStringFromSides(shortString);

        assertEquals("Too short string or amount of symbols is even", result1);
        assertEquals("Too short string or amount of symbols is even", result2);
    }

    @Test
    public void testTransferTwoSymbolsFromEndToBeginningOfString(){
        String str = "LonTimeAgoWhenWeWereYounger";

        String result = transferTwoLettersFromEndToBeginning(str);

        assertEquals("erLonTimeAgoWhenWeWereYoung", result);
    }

    @Test
    public void creatingNewStringWithDoublingEachCharacter(){
        String str = "PeaceNoWar";

        String result = createDoublingCharacterString(str);

        assertEquals("PPeeaacceeNNooWWaarr", result);
    }

    @Test
    public void creatingByStreamNewStringWithDoublingEachCharacter(){
        String str = "PeaceNoWar";

        String result = createDoublingCharacterStringWitStream(str);

        assertEquals("PPeeaacceeNNooWWaarr", result);
    }

    @Test
    public void testExcludeAllSpaceSigns(){
        String str = "Cha ra ct er";

        String result = StringMethods.excludeAllSpaceSigns(str);
        assertEquals("Character", result);
    }

}
