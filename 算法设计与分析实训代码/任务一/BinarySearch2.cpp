#include<stdio.h>

int a[8]={1,2,3,4,5,7,9,11};
int BinarySearch(int x,int y,int k)  //x��������Ŀ�ʼ��y�Ǵ��Ľ���,k�ǲ���ֵ
{
	int m=x+(y-x)/2;   //�м���
	if(x>y)
		return -1;
	else
	{
		if(a[m]==k)
			return m;
		else if(a[m]>k)  //�����
			return BinarySearch(x,m-1,k);
		else             //���ұ�
			return BinarySearch(m+1,y,k);
	}
}

int main()
{
	int middle=BinarySearch(0,8,7);
	printf("������������a[%d]\n",middle);

	return 0;
}
