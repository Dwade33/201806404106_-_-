def QuickSort(lst):
    def partition(arr, left, right):                           # 此函数完成分区操作
        key = left                                             # 划分第一个数为基准数
        while left < right:
            while left < right and arr[right] >= arr[key]:     #后边的数比基准数大或相等,则一直前移到有比基准数小的数
                right -= 1
            while left < right and arr[left] <= arr[key]:      #前边的数比基准数小或相等,则一直后移到有比基准数大的数
                left += 1
            (arr[left], arr[right]) = (arr[right], arr[left])  #将基数大的和小的互换位置
        (arr[left], arr[key]) = (arr[key], arr[left])          #直到两个位置相等时结束，将左边小的同基准进行交换
        return left                                            # 返回目前基准所在位置的索引
 
    def quicksort(arr, left, right):  
        if left >= right:
            return
        mid = partition(arr, left, right)            # 从基准开始分区
        quicksort(arr, left, mid - 1)                # 递归调用
        quicksort(arr, mid + 1, right)               # 递归调用

    # 主函数
    n = len(lst)
    if n <= 1:
        return lst
    quicksort(lst, 0, n - 1)
    return lst

#运行的主代码
print("<<< Quick Sort >>>")
x = input("请输入待排序数列：\n")
y = x.split()
arr = []
for i in y:
    arr.append(int(i))           #将x加到arr数组
arr = QuickSort(arr)
print("数列按序排列如下：")
for i in arr:
    print(i, end=' ')