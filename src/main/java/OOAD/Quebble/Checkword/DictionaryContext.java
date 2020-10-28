package OOAD.Quebble.Checkword;

public class DictionaryContext {
    private IDictionary dictionary;

    public DictionaryContext(IDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public IDictionary getDictionary() {
        return dictionary;
    }
}
