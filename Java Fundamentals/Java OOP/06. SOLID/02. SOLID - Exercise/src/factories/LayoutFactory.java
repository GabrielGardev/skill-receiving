package factories;

import interfeaces.Factory;
import interfeaces.Layout;
import models.SimpleLayout;
import models.XmlLayout;

public class LayoutFactory implements Factory<Layout> {
    @Override
    public Layout produce(String produceData) {
        Layout layout = null;

        if (produceData.equals("SimpleLayout")){
            layout = new SimpleLayout();
        }else if (produceData.equals("XmlLayout")){
            layout = new XmlLayout();
        }
        return layout;
    }
}
