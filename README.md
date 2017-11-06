# Title View
This is a Custom View for Title View Pager. 


### Sample 
<p align="center">
  <img width="300" height="500" src="http://laluhilman.com/github/TitleView/titleview.gif">
</p>



### Installing
1. Copy some file to your project.
2. Add titleView to your xml layout.
```
      <com.laluhilman.titlescroolview.customview.TitleView
        android:id="@+id/demo_title_view"
        android:layout_width="match_parent"
        android:layout_height="50dp">

    </com.laluhilman.titlescroolview.customview.TitleView>

```
3. Setup View through java code

```
        titleViewDemo = (TitleView) findViewById(R.id.demo_title_view);
        titleViewDemo.setUpView(generateTitleList(), getWindowManager().getDefaultDisplay().getWidth()/3);
        
        generateTitleList() = ArrayList of String. This is List title.
        getWindowManager().getDefaultDisplay().getWidth()/3 = Size of each title. Each Title will cosume 1/3 of width screen.
        
        
```
  

