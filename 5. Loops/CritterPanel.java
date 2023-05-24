// Stuart Reges
// 1/26/00
// grader: self
//
// Class CritterPanel displays a grid of critters

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class CritterPanel extends JPanel {
    private CritterModel myModel;
    private Font myFont;

    public static final int FONT_SIZE = 12;

    public CritterPanel(CritterModel model) {
        myModel = model;
        // construct font and compute char width once in constructor
        // for efficiency
        myFont = new Font("Monospaced", Font.BOLD, FONT_SIZE);
        setBackground(Color.cyan);
        setPreferredSize(new Dimension(FONT_SIZE * model.getWidth() / 2 + 125,
                                       FONT_SIZE * model.getHeight() + 20));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(myFont);
        int height = myModel.getHeight();
        int width = myModel.getWidth();
        // because font is monospaced, all widths should be the same;
        // so we can get char width from any char (in this case x)
        int charWidth = g.getFontMetrics().charWidth('x');
        int extraX = getWidth() - (width + 1) * charWidth;
        int extraY = getHeight() - (height - 1) * FONT_SIZE;
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                g.drawString("" + myModel.getChar(i, j),
                             extraX/2 + i * charWidth,
                             extraY/2 + j * FONT_SIZE);
    }
}
