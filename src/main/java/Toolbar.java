import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {
    private JButton helloButton;
    private JButton goodByeButton;

    private TextPanel textPanel;

    public Toolbar() {
        helloButton = new JButton("Hello");
        goodByeButton = new JButton("Goodbye");

        helloButton.addActionListener(this);
        goodByeButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodByeButton);
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if (clicked == helloButton) {
            textPanel.appendText("hello\n");
        } else if (clicked == goodByeButton) {
            textPanel.appendText("goodbye\n");
        }
    }
}
