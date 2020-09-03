package transformacoes;

import java.awt.Polygon;

public class Transformacoes2D {

    public Transformacoes2D() {
    }

    public void translacao(Polygon obj, double tx, double ty) {
        double T[][] = {{1, 0, tx}, {0, 1, ty}, {0, 0, 1}};
        aplicar(obj,T);
    }

    public void escala(Polygon obj, double sx, double sy) {
        double E[][] = {{sx, 0, 0}, {0, sy, 0}, {0, 0, 1}};
        
        double c[] = centroMassa(obj);
        double T1[][] = {{1, 0, c[0]}, {0, 1, c[1]}, {0, 0, 1}};
        double M[][] = multMatrizMatriz(T1,E);
        double T2[][]  = {{1, 0, -c[0]}, {0, 1, -c[1]}, {0, 0, 1}};
        M = multMatrizMatriz(M, T2);
        aplicar(obj,M);
    }
    
    public void rotacao(Polygon obj, double angulo) {
        double theta = Math.toRadians(angulo);
        double R[][] = {{Math.cos(theta), -Math.sin(theta), 0}, {Math.sin(theta), Math.cos(theta), 0}, {0, 0, 1}};
        
        double c[] = centroMassa(obj);
        double T1[][] = {{1, 0, c[0]}, {0, 1, c[1]}, {0, 0, 1}};
        double M[][] = multMatrizMatriz(T1,R);
        
        double T2[][]  = {{1, 0, -c[0]}, {0, 1, -c[1]}, {0, 0, 1}};
        M = multMatrizMatriz(M, T2);
        aplicar(obj,M);
    }
    
    
    //
    // ÚTEIS
    //
    
    private void aplicar(Polygon obj, double M[][]){
        for (int i = 0; i < obj.npoints; i++) {
            double p[] = {obj.xpoints[i], obj.ypoints[i], 1};
            double n[] = multMatrizPonto(M, p);
            obj.xpoints[i] = (int) n[0];
            obj.ypoints[i] = (int) n[1];
        }
    }

    private double[] centroMassa(Polygon obj) {
        double c[] = {0, 0};
        for (int i = 0; i < obj.npoints; i++) {
            c[0] += obj.xpoints[i];
            c[1] += obj.ypoints[i];
        }
        c[0] = c[0] / obj.npoints;
        c[1] = c[1] / obj.npoints;
        return c;
    }

    private double[] multMatrizPonto(double mat[][], double ponto[]) {
        double[] res = new double[3];
        for (int i = 0; i < res.length; i++) {
            double soma = 0;
            for (int j = 0; j < res.length; j++) {
                soma += mat[i][j] * ponto[j];
            }
            res[i] = soma;
        }
        return res;
    }

    private static double[][] multMatrizMatriz(double[][] a, double[][] b) {

        int aLin = a.length;
        int aCol = a[0].length;
        int bCol = b[0].length;

        double[][] c = new double[aLin][bCol];
        for (int i = 0; i < aLin; i++) {
            for (int j = 0; j < bCol; j++) {
                for (int k = 0; k < aCol; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

}
