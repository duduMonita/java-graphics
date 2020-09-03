/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacoes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import util.JPanelGraphics;

/**
 *
 * @author Rodrigo Plotze
 */
public class Objeto extends JPanelGraphics {
    
    private Polygon p;
    
    public Objeto(Dimension d) {
        super(d);
        this.p = new Polygon();
    }
   
    public Polygon getObjeto(){
        return p;
    }    

     public void eixos(Color cor) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(cor);
        g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        repaint();
    }       

    public void retangulo(Color cor) {
        p.reset();
        p.addPoint(150, 100);
        p.addPoint(450, 100);
        p.addPoint(450, 300);
        p.addPoint(150, 300);
        desenhar(cor);
    }

    public void triangulo(Color cor) {
        p.reset();
        p.addPoint(300, 100);
        p.addPoint(450, 300);
        p.addPoint(150, 300);
        desenhar(cor);
    }


    public void desenhar(Color cor) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        
        //limpar a imagem
        g.setColor(Color.WHITE);
        g.fillRect(1, 1, this.getWidth() - 2, this.getHeight()- 2);
        eixos(Color.gray);
        
        //desenhar o novo objeto
        g.setColor(cor);
        g.drawPolygon(p);
        repaint();
    }    
    
    public void limpar() {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth() - 1, this.getWidth() - 1);
        repaint();
    }
}
