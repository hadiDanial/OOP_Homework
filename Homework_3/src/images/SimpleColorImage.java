package images;

public class SimpleColorImage extends BaseImage
	{
		private RGB color;
		
		public SimpleColorImage(int width, int height, RGB color)
		{
			super(width, height);
			this.color = color;
		}

		@Override
		public RGB get(int x, int y) 
		{			
			return color;
		}

	}