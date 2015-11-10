import java.util.Vector;
class test {
	public static void main(String[] args) {
		/*int[] a = {4,2,3,7,1};
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
		System.out.println(min);*/
		Vector<Integer> a = new Vector<Integer>();
		a.add(4);
		a.add(2);
		a.add(3);
		a.add(7);
		a.add(1);
		int N = 5;
		int min = a.get(0);
		int i=1;
		while (i<N)
		{
			if (a.get(i)<min)
			{
			min = a.get(i);
			}
			i = i + 1;
		}
		System.out.println(min);
	}
}