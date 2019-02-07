package com.mathodcoast;

import com.mathodcoast.model.AnagramString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

@RunWith( JUnit4.class )
public class TestCollections {

    @Test
    public void testAnagramString(){
        Set<AnagramString> setA = new HashSet<>();
        setA.add(new AnagramString("ABCD"));
        setA.add(new AnagramString("BCDA"));
        setA.add(new AnagramString("XBCD"));

        Set<AnagramString> setB = new HashSet<>();
        setB.add(new AnagramString("DCAB"));
        setB.add(new AnagramString("DACB"));
        setB.add(new AnagramString("DXCB"));

        System.out.println("SetA: " + setA);
        System.out.println("SetB: " + setB);

        assertEquals(setA,setB);
    }
}
