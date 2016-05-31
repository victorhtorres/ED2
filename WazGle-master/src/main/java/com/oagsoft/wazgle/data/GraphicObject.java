package com.oagsoft.wazgle.data;

import com.oagsoft.grafo.data.Ideable;
import java.awt.Graphics2D;

/**
 *
 * @author oarcila
 */
public abstract class GraphicObject implements Ideable
{
    public abstract void draw ( Graphics2D g);
}
