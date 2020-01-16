#include <stdio.h>
#define ARR_LEN 255
#define elemType int

void bb (elemType arr[], int len,int k) {
    elemType temp;
    int i, j;
    for (i=0; i<k; i++)                   /* 外循环为排序趟数，找几个最小的数循环几次*/
        for (j=len-1; j>i; j--) {         /* 内循环为每趟比较的次数，第i趟比较len-i次 */
            if (arr[j] < arr[j-1]) {      /* 相邻元素比较，把最小的放到最前面 */
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
}
 
main(){
    elemType arr[ARR_LEN] = {3,5,1,4,9,8,10,4};        //从这里找最小的数 
    int len = 8;
    int k;
    printf("请输入要找的个数k："); 
    scanf("%d",&k);
    
    bb (arr, len,k);
    printf("在%d个数{3,5,1,4,9,8,10,4}中，最小的%d个数为：\n",len,k); 
    for (int i=0; i<k; i++)
        printf ("%2d", arr[i]);
     
    return 0;
}
