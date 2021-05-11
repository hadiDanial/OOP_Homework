package images;

public class MainForImages {

	public static void main(String[] args) 
	{
		testAllImages();
//		testFinalDrawing();
	}


	protected static void testFinalDrawing() {
		Image i1 = new Gradient(500, 500, RGB.BLUE, RGB.BLACK);
		Image i2 = new Transpose(new Gradient(500, 500, RGB.RED, RGB.BLACK));
		Image i3 = new Mix(i1, i2, 0.5);
		Image i4 = new Circle(350, 150, new RGB(1, 1, 0), RGB.BLACK);
		Image i5 = new Circle(200, 100, new RGB(0, 0.5, 1), RGB.BLACK);
		Image i6 = new Circle(500, 200, RGB.WHITE, RGB.BLACK);

		Image i7 = new Superpose(i3, i4);
		Image i8 = new Superpose(i5, i6);
		Image i9 = new Superpose(i7, i8);

		Displayer.display(i9);
	}

	@SuppressWarnings("unused") // Function for testing. Can only display one image at a time, so the rest are unused.
	protected static void testAllImages() {
		Image i = new Gradient(200, 100, RGB.RED, new RGB(1, 1, 0));
		//Displayer.display(i);
		
		Image c = new Circle(800, 400, 4*70, 4*70, 4*90, RGB.BLUE, new RGB(0.5, 0, 0.5));
		//Displayer.display(c);
		
		Image ic = new Circle(120, 60, RGB.WHITE, RGB.BLACK);
		//Displayer.display(ic);
		
		Image filter = new Filter(ic, new RGB(0.5, 0, 1));
		//Displayer.display(filter);
		
		Image inverted = new Invert(new Circle(120, 60, RGB.RED, RGB.BLACK));
		//Displayer.display(inverted);
		
		Image transposed = new Transpose(new Gradient(100, 200, RGB.BLUE, RGB.GREEN));
		//Displayer.display(transposed);
		
		
		Image sg1 = new Gradient(100, 150, RGB.RED, RGB.RED);
		Image sg2 = new Gradient(200, 100, RGB.BLUE, RGB.BLUE);
		Image superposed = new Superpose(sg1,  sg2);
		//Displayer.display(superposed);
		
		Image mg1 = new Gradient(100, 150, RGB.RED, RGB.WHITE);
		Image mg2 = new Gradient(200, 100, RGB.BLUE, RGB.GREEN);
		Image mix = new Mix(mg1,  mg2, 0.7);
		//Displayer.display(mix);
		
		Image twoC = new TwoColorImage(200, 100, RGB.BLACK, RGB.RED, new Func1());
		Displayer.display(twoC);
	}

}
