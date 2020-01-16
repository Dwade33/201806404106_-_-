#include<stdio.h>

int main(){
int a=0,b=0,c=0,d=0,e=0,f=0;
   for(a=1;a<=6;a++)
      for(b=1;b<=6;b++)
      {
         if(b==a) continue;
         for(c=1;c<=6;c++)
         {
             if((c==a)||(c==b)) continue;
             for(d=1;d<=6;d++)
             {
                 if((d==a) || (d==b) || (d==c)) continue;
                 for(e=1;e<=6;e++)
                 {
                     if((e==a)||(e==b)||(e==c)||(e==d)) continue;
                     f=21-(a+b+c+d+e);                     
                     if((a+b+c)==(c+d+e) && (a+b+c)==(a+e+f))    /*判断3个边是否相等*/                     
                       	printf("a=%d,b=%d,c=%d,d=%d,e=%d,f=%d\n",a,b,c,d,e,f);                     
                 }
             }
         }                  
      }
      return 0;
}
