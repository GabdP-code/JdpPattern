# W.I.P.
-extend your class with:
* BaseActivity
* BaseFragment
* DrawerActivity
* DrawerFragment
* DetailFragment
* SwipebackbaseActivity
* Swipebackbasefragment
* TabbedFragment
* SwipebackTabbedFragment
* PocketAdapter


#version
[https://jitpack.io/#jamesdeperio/JDPPattern/](https://jitpack.io/#jamesdeperio/JDPPattern/)
# GRADLE
* add jamesdeperio:JDPLib in your dependency
* add dependency of [(Jake Wharton ButterKnife)](jakewharton.github.io/butterknife)
```gradle
  repositories {
    maven { url 'https://jitpack.io' }
  }
  dependencies {
     compile 'com.github.jamesdeperio:JdpPattern:-SNAPSHOT'
     compile 'com.jakewharton:butterknife:8.6.0'
     compile 'com.jakewharton:butterknife-compiler:8.6.0'
  }
```
# Utilities
## CleanView
* used to clear memory from specific view (fragment container)
```java
  CleanView.INSTANCE.clearMemory(WeakReference<View> view);
```
## UserPermission [(Karumi Dexter)](https://github.com/Karumi/Dexter)
* run time permission.
```java
  UserPermission.INSTANCE.showPermissionDialog(Activity activity, Collection<String> permission, MultiplePermissionListener listener);
```
* how to implement:
```java
  List<String> permissionList = new ArrayList<>();
  permissionList.add(Manifest.permission.CAMERA);
  permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);

  UserPermission.INSTANCE.showPermissionDialog(this, permissionList, listener);

  ...

   private MultiplePermissionListener listener = new MultiplePermissionListener(getActivity()) {
      @Override
      protected void denied(String permissionName) {
        //TODO: callback if denied
      }
      @Override
      protected void granted(String permissionName) {
        //TODO: callback if granted
      }
  };
```
## FragmentChange
* used to change fragment.
```java
  FragmentChange.INSTANCE.load(int layout,FragmentManager fragmentManager,Fragment toFragment);
  //with backstack
  FragmentChange.INSTANCE.add(int layout,FragmentManager fragmentManager,Fragment fromFragment,Fragment toFragment);
  FragmentChange.INSTANCE.unLoad(WeakReference<View> view,FragmentManager fragmentManager,Fragment toFragment)
  FragmentChange.INSTANCE.unLoad(FragmentManager fragmentManager,Fragment toFragment)
```

# Helper
## RecyclerLayoutManager
* RecyclerLinearLayoutManager(FragmentActivity activity,int LinearLayout.Orrientation, boolean reverseLayout);
* RecyclerGridLayoutManager(Context context, int spanCount, int LinearLayout.Orrientation, boolean reverseLayout);
* RecyclerStaggeredLayoutManager(int spanCount, int LinearLayout.Orrientation);
## RecyclerAnim [(Wasabeef RecyclerView Animator)](https://github.com/wasabeef/recyclerview-animators)
* add animation to recyclerview.

|         Animation         |
| :-----------------------: |
| RecyclerAnim.ALPHA_IN     |
| RecyclerAnim.SCALE_IN     |
| RecyclerAnim.SLIDE_BOTTOM |
| RecyclerAnim.SLIDE_LEFT   |
| RecyclerAnim.SLIDE_RIGHT  |

```java
  RecyclerAnim anim = new RecyclerAnimHelper(FragmentActivity activity);
  anim.addAnim(RecyclerAnim animation)
      .setRecyclerView(RecyclerView recyclerView)
      .setpocketAdapter(PocketAdapter adapter)  // your recyclerview adapter should be extend with pocketAdapter
      .setLayoutManager(RecyclerLayoutManager layoutManager)
      .commit();
```
