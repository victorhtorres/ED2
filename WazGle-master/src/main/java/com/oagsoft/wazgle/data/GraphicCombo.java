package com.oagsoft.wazgle.data;

import java.awt.Graphics2D;

/**
 *
 * @author oarcila
 */
public class GraphicCombo extends GraphicObject
{
    private GraphicEdge edge;
    private GraphicTrack track;

    public GraphicCombo(GraphicEdge edge, GraphicTrack track) {
        this.edge = edge;
        this.track = track;
    }

    public GraphicEdge getEdge() {
        return edge;
    }

    public void setEdge(GraphicEdge edge) {
        this.edge = edge;
    }

    public GraphicTrack getTrack() {
        return track;
    }

    public void setTrack(GraphicTrack track) {
        this.track = track;
    }

    @Override
    public void draw(Graphics2D g) 
    {
        edge.draw(g);
        track.draw(g);
    }

  @Override
  public int getId() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

    @Override
    public void setId(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
