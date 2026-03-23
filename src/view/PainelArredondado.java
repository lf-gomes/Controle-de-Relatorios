package view;


import javax.swing.*;
import java.awt.*;

public class PainelArredondado extends JPanel {

    private int raio = 20;

    public PainelArredondado() {
        setOpaque(false); // MUITO IMPORTANTE
    }

    public PainelArredondado(int raio) {
        this.raio = raio;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), raio, raio);
    }
}