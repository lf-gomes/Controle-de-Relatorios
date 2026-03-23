package view;

import javax.swing.*;
import java.awt.*;

public class TextFieldArredondado extends JTextField {

    private int raio = 20;

    public TextFieldArredondado(int raio) {
        this.raio = raio;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // espaço interno
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fundo arredondado
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), raio, raio);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, raio, raio);
    }
}