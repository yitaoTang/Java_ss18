/**
 * Image Manipulation
 * 
 * @author Marcus
 */
public class Aufgabe2 {

	/**
	 * Converts a RGB color to a gray scale.
	 * 
	 * @param rgb The RGB value to convert.
	 * @return The gray scale value.
	 */
	public static int convertColorToGrayscale(int rgb) {
		// TODO: implement me!
		int zahl = (Colors.getB(rgb) + Colors.getR(rgb) + Colors.getG(rgb)) / 3;
		int greyScale = Colors.toRGB(zahl, zahl , zahl);
		return greyScale ;
	}
	
	/**
	 * Converts the pixels of an image from RGB to a gray scale.
	 * 
	 * @param pixels The input pixels.
	 * @return The modified pixels.
	 */
	public static int[][] convertPictureToGrayscale(int[][] pixels) {
		// TODO: implement me!

		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				int red = Colors.getR(pixels[i][j]);
				int green = Colors.getG(pixels[i][j]);
				int blue = Colors.getB(pixels[i][j]);
				int zahl = (red + green + blue) / 3;
				pixels[i][j] = Colors.toRGB(zahl, zahl, zahl);
			}
		}
		return pixels;
	}
	
	/**
	 * Converts a picture by dividing it in three equal parts along the X axis. 
	 * In the first (left) part, only the red component is drawn. In the second 
	 * (middle) part, only the green component is drawn. In the third (right) part,
	 * only the blue component is drawn.
	 * 
	 * @param pixels The input pixels.
	 * @return The output pixels.
	 */
	public static int[][] andyWarhol(int[][] pixels) {
		// TODO: implement me!
		int firstX = pixels.length / 3;
		int secondX = firstX * 2;


		int[][] newPixel = new int[pixels.length][pixels[0].length];

		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				if(i < firstX) {
					newPixel[i][j] = Colors.toRGB(Colors.getR(pixels[i][j]), 0, 0);
				}else if( i >= firstX && i < secondX) {
					newPixel[i][j] = Colors.toRGB(0, Colors.getG(pixels[i][j]), 0);
				}else if(i >= secondX) {
					newPixel[i][j] = Colors.toRGB(0, 0, Colors.getB(pixels[i][j]));
				}
			}
		}
		return newPixel;
	}
	
	/**
	 * Draws a border of the specified borderWidth with the specified borderColor
	 * onto the picture.
	 * 
	 * @param pixels The pixels of the picture.
	 * @param borderWidth The border width in number of pixels (>= 0).
	 * @param borderColor The border color.
	 * @return The picture with a border of the specified width and color.
	 */
	public static  int[][] drawBorderOnPicture(int[][] pixels, int borderWidth, int borderColor) {
		// TODO: implement me!
		int red = Colors.getR(borderColor);
		int green = Colors.getG(borderColor);
		int blue = Colors.getB(borderColor);

		for(int i = 0; i < borderWidth; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				pixels[i][j] = Colors.toRGB(red, green, blue);
			}
		}

		for(int i = pixels.length - borderWidth; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				pixels[i][j] = Colors.toRGB(red, green, blue);
			}
		}

		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < borderWidth; j++) {
				pixels[i][j] = Colors.toRGB(red, green, blue);
			}
		}

		for(int i = 0; i < pixels.length; i++) {
			for(int j = pixels[0].length - borderWidth; j < pixels[0].length; j++) {
				pixels[i][j] = Colors.toRGB(red, green, blue);
			}
		}
		return pixels;
	}
	
	/**
	 * Extends a picture with a border with the specified borderWidth and borderColor.
	 * 
	 * @param pixels The pixels of the picture.
	 * @param borderWidth The width of the border in pixels (>= 0).
	 * @param borderColor The border color.
	 * @return The extended picture with a border with the specified number of pixels in the specified color.
	 */
	public static  int[][] extendPictureWithBorder(int[][] pixels, int borderWidth, int borderColor) {
		// TODO: implement me!
	
		int[][] newPixels = new int[pixels.length + 2 * borderWidth][pixels[0].length + 2 * borderWidth];

		int red = Colors.getR(borderColor);
		int green = Colors.getG(borderColor);
		int blue = Colors.getB(borderColor);
		
		
		
		for(int i = 0; i < newPixels.length; i++) {
			for ( int j =0; j < newPixels[i].length ; j++) {
				if(( i < borderWidth || i >= newPixels.length    -borderWidth )
				|| ( j < borderWidth || j >= newPixels[i].length -borderWidth)) {
					newPixels [i][j]= Colors.toRGB(red, green, blue);
				}else {
					newPixels[i][j] = pixels[i - borderWidth][j - borderWidth];
				}
			}
		}
		return newPixels;
	}

		/*for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[i].length; j++) {
				newPixels[i + borderWidth][j + borderWidth] = pixels[i][j];
			}
		}

		for(int i = 0; i < borderWidth; i++) {
			for(int j = 0; j < y; j++) {
				newPixels[i][j] = Colors.toRGB(red, green, blue);
			}
		}

		for(int i = x - borderWidth; i < x; i++) {
			for(int j = 0; j < y; j++) {
				newPixels[i][j] = Colors.toRGB(red, green, blue);
			}
		}

		for(int i = 0; i < x; i++) {
			for(int j = 0; j < borderWidth; j++) {
				newPixels[i][j] = Colors.toRGB(red, green, blue);
			}
		}

		for(int i = 0; i < x; i++) {
			for(int j = y - borderWidth; j < y; j++) {
				newPixels[i][j] = Colors.toRGB(red, green, blue);
			}
		}



		return newPixels;
	}
	*/
		
	/**
	 * Rotates a picture by 90 degrees by swapping out the
	 * x and y axis.
	 * 
	 * @param pixels The pixels.
	 * @return The rotated picture.
	 */
	public static int[][] rotatePicture(int[][] pixels) {
		// TODO: implement me!
		int[][] newPixels = new int[pixels[0].length][pixels.length];
		for(int i = 0; i < pixels[0].length; i++) {
			for(int j = 0; j < pixels.length; j++) {
				newPixels[i][j] = pixels[pixels.length - 1 - j][i];
			}
		}
		return newPixels;
	}
	
	/**
	 * Computes the size of an axis when shrinking it by only drawing
	 * every n-th pixel.
	 * 
	 * @param length The length of the axis (>0)
	 * @param n The interval of the pixels (>0).
	 * @return The number of pixels on the axis.
	 */
	public static int computeShrinkedSize(int length, int n) {
		// TODO: implement me!
		int newLength = 0;

		if(length % n == 0) {
			newLength = length / n;
		}else if(length % n != 0) {
			newLength = length / n + 1;
		}
		return newLength;
	}
	
	/**
	 * Shrinks a picture while keeping the aspect ratio
	 * by drawing only every n-th pixel in each dimension.
	 * 
	 * @param pixels The pixels of the image.
	 * @param n The n to define how much to shrink the picture.
	 * @return The shrunken picture.
	 */
	public static int[][] shrinkPicture(int[][] pixels, int n) {
		// TODO: implement me!
		int x = computeShrinkedSize(pixels.length, n);
		int y = computeShrinkedSize(pixels[0].length, n);
		int[][] newPixels = new int[x][y];

		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				newPixels[i][j] = pixels[n * i][n * j];
			}
		}
		return newPixels;
	}
	
	/**
	 * Computes the average color of a group of pixels in another array starting at
	 * startX and startY going to min(startX + n, pixels.length), 
	 * min(startY + n, pixels[0].length).
	 * 
	 * @param pixels The pixels
	 * @param startX The x coordinate of the start.
	 * @param startY The y coordinate of the start.
	 * @param n The number of pixels in each dimension.
	 * @return The (component-wise) average color value representing the group of pixels.
	 */
	public static int computeAverageColor(int[][] pixels, int startX, int startY, int n) {
		// TODO: implement me!
		int a = 0;
		int count = 0;
		int redSumme = 0;
		int greenSumme = 0;
		int blueSumme = 0;

		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				if(a != n ) {
					while (a != n) {
						redSumme += Colors.getR(pixels[startX + a][startY + a]);
						greenSumme += Colors.getR(pixels[startX + a][startY + a]);
						blueSumme += Colors.getR(pixels[startX + a][startY + a]);
						a++;
						count++;
					}
				}else if(a == n ) {
					a = 0;
				}
				startX = n * i;
				startY = n * j;
			}
		}
		int red = redSumme / count;
		int blue = blueSumme / count;
		int green = greenSumme / count;

		pixels[startX][startY] = Colors.toRGB(red, blue, green);
		return pixels[startX][startY];
	}
	
	/**
	 * Smoothly shrinks a picture while keeping the aspect ratio
	 * by drawing only every n-th pixel in each dimension but
	 * using the average of all "shrunken" pixels.  
	 * 
	 * @param pixels The input pixels.
	 * @param n The n to define how much to shrink the picture.
	 * @return The smoothly shrunken picture.
	 */
	public static int[][] shrinkPictureSmooth(int[][] pixels, int n) {
		// TODO: implement me!
		return pixels;
	}
	
	
	/**
	 * Reads a picture, runs all conversion methods and saves
	 * the output to a new file with the following format:
	 * 
	 * name-'conversion'-'timestamp'
	 * 
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		String name = "notre-dame";
		String extension = ".png";
		String input = name + extension;
		long timestamp = System.currentTimeMillis();
		Images.writeImage(name + "-gray-" + timestamp + extension, convertPictureToGrayscale(Images.readImage(input)));
		Images.writeImage(name + "-warhol-" + timestamp + extension, andyWarhol(Images.readImage(input)));
		Images.writeImage(name + "-draw-" + timestamp + extension, drawBorderOnPicture(Images.readImage(input), 100, Colors.toRGB(255, 0, 0)));
		Images.writeImage(name + "-extend-" + timestamp + extension, extendPictureWithBorder(Images.readImage(input), 100, Colors.toRGB(0, 255, 0)));
		Images.writeImage(name + "-rotate-" + timestamp + extension, rotatePicture(Images.readImage(input)));
		Images.writeImage(name + "-shrink-" + timestamp + extension, shrinkPicture(Images.readImage(input), 3));
		Images.writeImage(name + "-smooth-" + timestamp + extension, shrinkPictureSmooth(Images.readImage(input), 3));
	}
	
	
	
	
	
}
