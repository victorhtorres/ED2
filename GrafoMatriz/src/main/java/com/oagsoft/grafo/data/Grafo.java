package com.oagsoft.grafo.data;

/**
 *
 * @author oarcila
 */
public class Grafo
{

    private int m[][];
    private int nVertices;

    public Grafo(int nVertices)
    {
        this.nVertices = nVertices;
        m = new int[nVertices][nVertices];
    }

    public int getnVertices()
    {
        return nVertices;
    }

    //<editor-fold defaultstate="collapsed" desc="Metodo :: adyacencia(int, int)">
    public void adyacencia(int vIni, int vFin)
    {
        m[vIni][vFin] = 1;
//        m[vFin][vIni] = 1;
    }
    //</editor-fold>
    
    public boolean sonAdyacentes(int vIni, int vFin)
    {
        return m[vIni][vFin] == 1;
    }

    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < nVertices; i++)
        {
            for (int j = 0; j < nVertices; j++)
            {
                string.append(" ").append(m[i][j]);
            }
            string.append("\n");
        }
        return string.toString();
    }

}
