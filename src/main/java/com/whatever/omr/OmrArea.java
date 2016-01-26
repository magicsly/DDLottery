package com.whatever.omr;

public class OmrArea {
	private int width;
	private int height;
	private int left;
	private int top;
	boolean[][] content;

	public OmrArea(int width, int height, int left, int top) {
		this.width = width;
		this.height = height;
		this.left = left;
		this.top = top;
		content = new boolean[width][height];
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		//sb.append("1B6403");//feed 3 line
//		sb.append("1B25011B21001B260378780CFFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000");
//		sb.append("1B25011B21001B260379790CFFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000000000000000000000000000");
//	    sb.append("1B25011B21001B26037A7A0C0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF");  
//		sb.append("1B25011B21001B26037B7B0C0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF000000000000000000000000");
		
//		sb.append("1B25011B21001B26037B7B0CFFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000");
//		sb.append("1B25011B21001B26037C7C0CFFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000000000000000000000000000");
//	    sb.append("1B25011B21001B26037D7D0C0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF");  
//		sb.append("1B25011B21001B26037E7E0C0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF000000000000000000000000");
		
		sb.append("1B25011B21001B2603787B");
		sb.append("0CFFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000");
		sb.append("0CFFC000FFC000FFC000FFC000FFC000FFC000FFC000FFC000000000000000000000000000");
	    sb.append("0C0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF");  
		sb.append("0C0003FF0003FF0003FF0003FF0003FF0003FF0003FF0003FF000000000000000000000000");
		
		sb.append("1D509DA9");//x,y unit set
		sb.append("1D4C0000");//left margin
		sb.append("1B3329");//line space 29
		sb.append("1B2100");//12 dot font
		sb.append("1D2100");//default font size
		sb.append("1D6100");//left align
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (x==0){
					sb.append("1B200078781B200679");
				}else if (content[x][y]) {
//					if (x==13){
//						//sb.append("1B20007A7A");//column 14
//					}else{
						
					if (x<13) {
						sb.append("1B20007A7A1B20067B");
					}
					
				} else {
//					if (x==13){
//						//sb.append("1B20002020");//column 14
//					}else{
						
					if (x<13){
						sb.append("1B200020201B200620");
					}
				}
			}
			sb.append("0A");
		}
		
		sb.append("1D500000");//x,y unit restore
				
		return sb.toString();
	}

	public boolean fill(OmrArea oa) {
		if (oa.width + oa.left > this.width) {
			return false;
		}

		if (oa.height + oa.top > this.height) {
			return false;
		}

		for (int y = 0; y < oa.height; y++) {
			for (int x = 0; x < oa.width; x++) {
				this.content[x + oa.left][y + oa.top] = oa.content[x][y];
			}
		}

		return true;
	}

	public boolean mark(int x, int y) {
		if (x > width || y > height) {
			return false;
		}

		content[x][y] = true;

		return true;
	}
	
	public boolean mark(OmrPoint point) {
		if (point.getX() > width || point.getY() > height) {
			return false;
		}

		content[point.getX()][point.getY()] = true;

		return true;
	}
	
}
