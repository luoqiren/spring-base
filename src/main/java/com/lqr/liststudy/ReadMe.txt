ref:
https://blog.csdn.net/zwwhnly/article/details/104987143?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-7.add_param_isCf&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-7.add_param_isCf

List如何一边遍历，一边删除？

1. ListError 是错误写法, 根据对象删除:Exception in thread "main" java.util.ConcurrentModificationException
2. ListError2 是错误写法, 根据下标删除:2个相同的对象并没有清理

3. ListIterator 是正确的
4. ListIndexFix 是正确的,修正下下标的值
5. ListReserch 是正确的,倒序处理

JDK1.8开始新特性
6. ListJDK8 是正确的 Lambda expression

