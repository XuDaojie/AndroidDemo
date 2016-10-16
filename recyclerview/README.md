RecyclerView
===

## 自定义LayoutManager
1. LayoutManger滑动需要自己实现
2. RecyclerView.getHeight() // 为可见区域的高度
3. Recycler.getViewForPosition() 一个非常重要的方法,ViewHolder创建和绑定都在这个方法中进行
4. onLayoutChildren 初始化及`Adapter`数据修改时触发

## Thanks
[打造属于你的LayoutManager](http://www.jianshu.com/p/08d998d047d8)
[创建一个 RecyclerView LayoutManager – Part 1](https://github.com/hehonghui/android-tech-frontier/blob/master/issue-9/%E5%88%9B%E5%BB%BA-RecyclerView-LayoutManager-Part-1.md)
