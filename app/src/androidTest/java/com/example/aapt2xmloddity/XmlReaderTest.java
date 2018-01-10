package com.example.aapt2xmloddity;


import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class XmlReaderTest {
    private XmlReader xmlReader = new XmlReader(InstrumentationRegistry.getTargetContext());

    @Test
    public void regularText() throws Exception {
        assertEquals("Regular text", xmlReader.readXml().get(0));
    }

    @Test
    public void textInDoubleQuotes() throws Exception {
        assertEquals("\"Text in double quotes\"", xmlReader.readXml().get(1));
    }

    @Test
    public void textInSingleQuotes() throws Exception {
        assertEquals("'Text in single quotes'", xmlReader.readXml().get(2));
    }

    @Test
    public void textContainingDoubleQuotes() throws Exception {
        assertEquals("Text containing \"double quotes\"", xmlReader.readXml().get(3));
    }

    @Test
    public void textContainingSingleQuotes() throws Exception {
        assertEquals("Text containing 'single quotes'", xmlReader.readXml().get(4));
    }
}
