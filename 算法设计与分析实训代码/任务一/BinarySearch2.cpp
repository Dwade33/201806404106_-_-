#include<stdio.h>

int a[8]={1,2,3,4,5,7,9,11};
int BinarySearch(int x,int y,int k)  //x是数组从哪开始，y是从哪结束,k是查找值
{
	int m=x+(y-x)/2;   //中间数
	if(x>y)
		return -1;
	else
	{
		if(a[m]==k)
			return m;
		else if(a[m]>k)  //找左边
			return BinarySearch(x,m-1,k);
		else             //找右边
			return BinarySearch(m+1,y,k);
	}
}

int main()
{
	int middle=BinarySearch(0,8,7);
	printf("这个数是数组的a[%d]\n",middle);

	return 0;
}
