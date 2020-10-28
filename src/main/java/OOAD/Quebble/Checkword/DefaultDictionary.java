package OOAD.Quebble.Checkword;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DefaultDictionary implements IDictionary {
    private ArrayList<String> dictionary;

    public DefaultDictionary() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("wordlist.txt");
        this.dictionary = new ArrayList<String>();

        Scanner scanner = null;
        try {
            if (resource != null) {
                scanner = new Scanner(new File(resource.toURI()), "UTF-8");
            }
        } catch (FileNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        }

        if (scanner != null) {
            while (scanner.hasNext()) {
                dictionary.add(scanner.next());
            }
            scanner.close();
        }
    }

    @Override
    public boolean validateWord(String word) {
        return dictionary.contains(word.toLowerCase());
    }
}
