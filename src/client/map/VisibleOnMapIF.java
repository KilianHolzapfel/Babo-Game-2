package client.map;

import java.awt.image.*;

import client.entities.Position;

public interface VisibleOnMapIF {
    public BufferedImage getImage();
    public Position getPosition();
}
