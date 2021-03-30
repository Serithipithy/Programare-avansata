package compulsory;

import java.awt.*;
import java.awt.geom.*;

public class Circle extends Ellipse2D.Double  {
    public Circle(int x, int y, int radius) {
        super(x - radius, y - radius, radius , radius);
    }

}
