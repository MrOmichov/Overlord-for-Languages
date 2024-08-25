package org.mromichov.overlordforlanguages.odm;

import java.util.Map;

public class Word {
    String meaning;
    Map<String, String> cases;
    public Word(String meaning, Map<String, String> cases) {
        this.meaning = meaning;
        this.cases = cases;
    }
}
