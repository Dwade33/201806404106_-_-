#include<stdio.h>

template<class Type>
int BinarySearch(Type a[],const Type& x,int n)   //a[]是数组，x是查找值，n是有多少个数。
{
	int left =0;
	int right = n-1;
	while(left<=right)  //如果左还小于右，即数组还没有查找完 
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
	printf("这个数是数组的a[%d]\n",middle);

	
	return 0;
}
