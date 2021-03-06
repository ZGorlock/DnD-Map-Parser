/*
 * File:    Frame.java
 * Package: objects
 * Author:  Zachary Gill
 */

package graphy.objects.base;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import graphy.math.vector.Vector;

/**
 * Defines a Frame Object for Objects.
 */
public class Frame extends Object {
    
    //Fields
    
    /**
     * The Object that the Frame was created for.
     */
    protected AbstractObject base;
    
    
    //Constructors
    
    /**
     * The constructor for a Frame.
     *
     * @param base  The Object to create a frame for.
     * @param color The color of the Frame.
     */
    public Frame(AbstractObject base, Color color) {
        super(base.getCenter(), color);
        
        this.base = base;
        base.registerFrame(this);
        setColor(color);
    }
    
    /**
     * The constructor for a Frame.
     *
     * @param base The Object to create a frame for.
     */
    public Frame(Object base) {
        this(base, Color.BLACK);
    }
    
    
    //Methods
    
    /**
     * Calculates the edges of the Frame.
     */
    @Override
    protected void calculate() {
    }
    
    /**
     * Prepares the Object to be rendered.
     *
     * @return The list of BaseObjects that were prepared.
     */
    @Override
    public List<BaseObject> prepare() {
        return new ArrayList<>();
    }
    
    /**
     * Renders the Object on the screen.
     *
     * @param g2 The 2D Graphics entity.
     */
    public void render(Graphics2D g2, List<Vector> prepared) {
        if (!visible || base.displayMode == DisplayMode.VERTEX) {
            return;
        }
        
        g2.setColor(color);
        
        if (prepared.size() > 1) {
            for (int i = 1; i < prepared.size(); i++) {
                g2.drawLine((int) prepared.get(i - 1).getX(), (int) prepared.get(i - 1).getY(), (int) prepared.get(i).getX(), (int) prepared.get(i).getY());
                if (i == prepared.size() - 1 && i > 1) {
                    g2.drawLine((int) prepared.get(i).getX(), (int) prepared.get(i).getY(), (int) prepared.get(0).getX(), (int) prepared.get(0).getY());
                }
            }
        }
    }
    
    /**
     * Renders the Object on the screen.
     *
     * @param g2 The 2D Graphics entity.
     */
    @Override
    public void render(Graphics2D g2) {
    }
    
}
