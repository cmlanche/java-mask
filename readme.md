# Java Mask蒙版图处理

###实现mask抠图的要点

1. 创建新图时要指定**TYPE_INT_ARGB**类型的
2. 循环遍历原图，如果是完全透明的，则将新图的改位置设置为透明的，否则从mask蒙版图

### 示例1

蒙版：![source](https://github.com/cmlanche/java-mask/blob/master/java-mask/resources/source.jpg)

原图：shape01.png

![shape01](https://github.com/cmlanche/java-mask/blob/master/java-mask/resources/shape01.png)

处理后：

![shape01](https://github.com/cmlanche/java-mask/blob/master/shape01_result.png)

### 示例2

蒙版：同示例1

原图：shape02.png

![shape02](https://github.com/cmlanche/java-mask/blob/master/java-mask/resources/shape02.png)

处理后：

![shape02_result](https://github.com/cmlanche/java-mask/blob/master/shape02_result.png)