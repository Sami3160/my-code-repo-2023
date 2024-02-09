
class  Wrapper1
{
	public static void main( String args[ ] )
	{
		// boxing
		Integer  iOb = new Integer(100);

		//unboxing
		int i = iOb.intValue();

		System.out.println(i + " : " + iOb); 
	}
}
