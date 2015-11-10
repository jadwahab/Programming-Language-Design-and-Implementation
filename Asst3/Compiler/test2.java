
class test2 {
	public static void main(String[] args) {
		int[] a = {4,2,3,7,1};
		int N = 5;
		int min = a[0];
		int i=1;
		while (i<N)
		{
			if (a[i]<min)
			{
			min = a[i];
			}
			i = i + 1;
		}
		System.out.println(min);
	}
}