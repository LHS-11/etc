package decoratorPattern.version1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Strings extends Item {

    private ArrayList<String> strings = new ArrayList<String>();


    public void add(String item){
        strings.add(item);
    }
    @Override

    public int getLinesCount() {
        return strings.size();
    }

    @Override
    public int getMaxLength() {
        Iterator<String> iter = strings.iterator();
        int maxWidth=0;

        while (iter.hasNext()) {
            String string = iter.next();
            maxWidth = Math.max(string.length(), maxWidth);
        }
        return maxWidth;
    }

    @Override
    public int getLength(int index) {
        return strings.get(index).length();
    }

    @Override
    public String getString(int index) {
        return strings.get(index);
    }
}
