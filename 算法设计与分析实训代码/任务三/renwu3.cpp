#include <stdio.h>
#define ARR_LEN 255
#define elemType int

void bb (elemType arr[], int len,int k) {
    elemType temp;
    int i, j;
    for (i=0; i<k; i++)                   /* ��ѭ��Ϊ�����������Ҽ�����С����ѭ������*/
        for (j=len-1; j>i; j--) {         /* ��ѭ��Ϊÿ�˱ȽϵĴ�������i�˱Ƚ�len-i�� */
            if (arr[j] < arr[j-1]) {      /* ����Ԫ�رȽϣ�����С�ķŵ���ǰ�� */
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
}
 
main(){
    elemType arr[ARR_LEN] = {3,5,1,4,9,8,10,4};        //����������С���� 
    int len = 8;
    int k;
    printf("������Ҫ�ҵĸ���k��"); 
    scanf("%d",&k);
    
    bb (arr, len,k);
    printf("��%d����{3,5,1,4,9,8,10,4}�У���С��%d����Ϊ��\n",len,k); 
    for (int i=0; i<k; i++)
        printf ("%2d", arr[i]);
     
    return 0;
}
