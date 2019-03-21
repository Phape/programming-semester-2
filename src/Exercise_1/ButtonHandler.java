package Exercise_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {

    private Container container;

    public ButtonHandler(Container container) {
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        container.setBackground(Color.BLACK);
    }
}
