# Java Mask蒙版图处理

###实现mask抠图的要点

1. 创建新图时要指定**TYPE_INT_ARGB**类型的
2. 循环遍历原图，如果是完全透明的，则将新图的改位置设置为透明的，否则从mask蒙版图

### 示例1

蒙版：![source](/Users/cmlanche/sourcetree/java-mask/java-mask/resources/source.jpg)



原图：shape01.png

![shape01](/Users/cmlanche/sourcetree/java-mask/java-mask/resources/shape01.png)

处理后：



![test](/Users/cmlanche/sourcetree/java-mask/java-mask/test.png)

### 示例2

蒙版：同示例1

原图：shape02.png

![shape02](/Users/cmlanche/sourcetree/java-mask/java-mask/resources/shape02.png)

处理后：

![shape02_result](/Users/cmlanche/sourcetree/java-mask/shape02_result.png)