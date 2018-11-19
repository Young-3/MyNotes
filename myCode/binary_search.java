/**
 *
 ���ֲ���
 * �ݹ���ǵݹ�
 * @author Young
 *
 */


/**
 * 
 * @author Young
 *�ݹ�
 *a Ϊ˳������
 *start ������ʼ��ַ�±�
 *end ���������ַ�±�
 *key ����
 */
public class binary_search {
	public static int binSearch(int[] a, int key) {
		return binSearch(a , 0 , a.length - 1, key );
	}
	
	public static int binSearch(int[] a, int start, int end, int key) {
		int mid = (end - start)/2 + start;
		if(a[mid] == key) {
			return mid; //exit
		}
		if(start>=mid) {
			return -1;
		}else if(key > a[mid]) {
			return binSearch(a, mid + 1, end, key);
		}else if(key < a[mid]) {
			return binSearch(a, start, mid - 1 ,key);
		}
		return -1;
		
		


	}
	
	public static int bs(int[] a, int key) {
	
		int mid;
		int start = 0;
		int end = a.length - 1;
		
		while(start<=end) { //while ���÷��������ж�Ϊtrue��ִ�����
			mid = start + (end - start)/2;
			if(key<a[mid]) {
				end = mid -1;
			}else if(key>a[mid]) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		
		return -1;
		
	}

	
	public static void main(String[] args) {

        int[] a = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        System.out.println(binSearch(a, 222));
        System.out.println(binSearch(a, 81));
        System.out.println(bs(a,87));
        System.out.println(bs(a,11));
	}
}
