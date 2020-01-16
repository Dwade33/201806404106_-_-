#include<stdio.h>

template<class Type>
int BinarySearch(Type a[],const Type& x,int n)   //a[]�����飬x�ǲ���ֵ��n���ж��ٸ�����
{
	int left =0;
	int right = n-1;
	while(left<=right)  //�����С���ң������黹û�в����� 
	{
		int middle = (left+right)/2;
		if(x == a[middle])
			return middle;
	    else if(x>a[middle])
			left=middle+1;
		else
			right = middle-1;
	}
	return-1;
}

int main()
{
	int a[8]={1,2,3,4,5,7,9,11};
	int middle=BinarySearch(a,7,8);
	printf("������������a[%d]\n",middle);

	
	return 0;
}
