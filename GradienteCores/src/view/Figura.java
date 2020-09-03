package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import util.JPanelGraphics;

public class Figura extends JPanelGraphics {

    public Figura(Dimension d) {
        super(d);
    }

    public void ponto(int x, int y, Color rgb) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(rgb);
        g.drawLine(x, y, x, y);
        repaint();
    }

    public void retangulo(int x, int y, int largura, int altura, Color rgb) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(rgb);

        //g.drawRect(x, y, largura, altura);
        g.fillRect(x, y, largura, altura);

        repaint();
    }

    public void circulo(int x, int y, int raio, Color rgb) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(rgb);
        
        //g.drawOval(x, y, raio, raio);
        g.fillOval(x, y, raio, raio);
        
        repaint();
    }

    public void gradiente(Color corIni, Color corFim, int xIni, int yIni, int xFim, int yFim) {

        Graphics2D g = (Graphics2D) image.getGraphics();
        GradientPaint grad = new GradientPaint(
                xIni, yIni, corIni,
                xFim, yFim, corFim
        );
        g.setPaint(grad);
        g.fill(new Rectangle2D.Double(0, 0, 600, 400));
        repaint();
    }

    public void poligono(Polygon p, Color rgb) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(rgb);

        //g.drawPolygon(p);
        g.fillPolygon(p);

        p.reset();
        repaint();
    }

    public void limpar() {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth() - 1, this.getWidth() - 1);
        repaint();
    }
}
