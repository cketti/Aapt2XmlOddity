package com.example.aapt2xmloddity;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.XmlResourceParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


class XmlReader {
    private final Context context;

    XmlReader(Context context) {
        this.context = context;
    }

    List<String> readXml() {
        try {
            return readSampleXml();
        } catch (XmlPullParserException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> readSampleXml() throws XmlPullParserException, IOException {
        List<String> result = new ArrayList<>();

        XmlResourceParser parser = context.getResources().getXml(R.xml.sample);

        parser.next();
        parser.next();

        while (parser.next() == XmlPullParser.START_TAG) {
            if (parser.next() == XmlPullParser.TEXT) {
                result.add(parser.getText());
                parser.next();
            } else {
                result.add(null);
            }
        }

        return result;
    }
}
