package client.utilities;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import client.resources.Res;

public class ImageTool {
	// .jpg file to BufferedImage
	public static BufferedImage loadImageFromFile(String fileName){
		try {
			File file = new File(fileName);
			BufferedImage image = null;
			if (file.exists()){
				image = ImageIO.read(file);
				return image;
			} else {
				Functions.showErrorScreen(Res.error.errorFileNotFound + fileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
			Functions.showErrorScreen(Res.error.errorFileNotRead + fileName);
		};
		return null;
	}
	
	public static BufferedImage rotateImage(BufferedImage image, double angle) throws java.awt.image.RasterFormatException{
		AffineTransform transform = new AffineTransform();
	    transform.rotate(angle, image.getWidth()/2, image.getHeight()/2);
	    AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
	    return op.filter(image, null);
	}
	
	public static AffineTransform getRotationObj(int imageWidth, int imageHeight, double angle){
		AffineTransform at = new AffineTransform();
        at.translate(imageWidth/2, imageHeight/2);
        at.rotate(angle);
        at.translate(-imageWidth/2, -imageHeight/2);
        return at;
	}
	
	// change width and height of BufferedImage
	public static BufferedImage resize(BufferedImage image, int x, int y){
		BufferedImage resizedImage = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, 0, 0, x, y, null);
        g.dispose();
        return resizedImage;
	}
	
	
	// prepare used images
	public static BufferedImage prepareImage(String fileName, int sizeX, int sizeY){
		return ImageTool.resize(ImageTool.loadImageFromFile(fileName), sizeX, sizeY);
	}
	
	public static BufferedImage copyImage(BufferedImage bi) {
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	
	public static void changeAlpha(BufferedImage img, float alphaPercent) {
	    for (int cx=0;cx<img.getWidth();cx++) {
	        for (int cy=0;cy<img.getHeight();cy++) {
	            int color = img.getRGB(cx, cy);
	            byte alpha = (byte) (color >> 24);
	            alpha = (byte) ((float) (int) (alpha & 0xff) * alphaPercent);
	            color &= 0x00ffffff;
	            color |= ((alpha & 0xff) << 24);
	            img.setRGB(cx, cy, color);
	        }
	    }
	}
	
	public static void resizeAndBrighter(BufferedImage image, float scale, int brighter){
		RescaleOp rescaleOp = new RescaleOp(scale, brighter, null);
		rescaleOp.filter(image, image);
	}
	
	public static BufferedImage cloneImage(BufferedImage bi) {
		 ColorModel cm = bi.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = bi.copyData(null);
		 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	
	public static BufferedImage newImageResizedAndBrighter(BufferedImage image, float scale, int brighter){
		BufferedImage newImage = cloneImage(image);
		resizeAndBrighter(newImage, scale, brighter);
		return newImage;
	}
	
	public static BufferedImage getSubimage(BufferedImage image, int posX, int posY, int width, int height){
		return image.getSubimage(posX, posY, width, height);
	}
	
	public static BufferedImage makeQuadratic(BufferedImage image){
		if (image.getWidth() > image.getHeight()){
			return getSubimage(image, (image.getWidth() - image.getHeight()) / 2, 0, image.getHeight(), image.getHeight());
		} else {
			return getSubimage(image, 0, (image.getHeight() - image.getWidth()) / 2, image.getWidth(), image.getWidth());
		}
	}
	
	// splits an image in rows and columns
	public static BufferedImage[] splitImage(BufferedImage image, int rows, int columns){
		BufferedImage[] result = new BufferedImage[rows * columns];
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++){
				result[i*columns + j] = ImageTool.getSubimage(image, j * image.getWidth() / columns, i * image.getHeight() / rows, image.getWidth() / columns, image.getHeight() / rows);
				result[i*columns + j] = ImageTool.makeQuadratic(result[i*columns + j]);
			}
		}
		return result;
	}
}
