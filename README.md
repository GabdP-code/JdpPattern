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
     compile 'com.github.jamesdeperio:JDPPattern:2dca2169b6'
     compile 'com.jakewharton:butterknife:8.6.0'
     compile 'com.jakewharton:butterknife-compiler:8.6.0'
  }
```
# Utilities
## CleanView Util
* used to clear memory from specific view (fragment container)
```java
  CleanViewUtil.Companion.clearMemory(View view);
```
## Dexter Util [(Karumi Dexter)](https://github.com/Karumi/Dexter)
* run time permission.
```java
  DexterUtil.Companion.showPermissionDialog(Activity activity, Collection<String> permission, MultiplePermissionListener listener);
```
* how to implement:
```java
  List<String> permissionList = new ArrayList<>();
  permissionList.add(Manifest.permission.CAMERA);
  permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);

  DexterUtil.Companion.showPermissionDialog(this, permissionList, listener);

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
## SweetAlertUtil [(Pendant SweetAlertDialog)](https://github.com/pedant/sweet-alert-dialog)
```java
    // PROGRESS LOADER
    SweetAlertDialog dialog = SweetAlertUtil.Companion.loader(Activity activity, String title, String hexcolor);
    dialog.dismiss();

    // BASIC DIALOG
    SweetAlertUtil.Companion.basicDialog(Activity activity, String title);

    // BASIC DIALOG WITH CONTENT
    SweetAlertUtil.Companion.basicDialogWithContent(Activity activity, String title, String message);

    // ONERROR DIALOG
    SweetAlertUtil.Companion.error(Activity activity, String title, String message);

    // ONSUCCESS DIALOG
    SweetAlertUtil.Companion.success(Activity activity, String title, String message);

    // ONWARNING DIALOG
    SweetAlertDialog dialog = SweetAlertUtil.Companion.warning(Activity activity, String title, String message, String confirmText, String cancelText);
    dialog.setCancelClickListener(listener);
    dialog.setConfirmClickListener(listener);
    dialog.show;
```
## FragmentUtil
* used to change fragment.
```java
  FragmentUtil.Companion.loadFragment(@LayoutRes int layout,FragmentManager fragmentManager,Fragment toFragment);
  FragmentUtil.Companion.loadFragment(@LayoutRes int layout,FragmentManager fragmentManager,DrawerFragment toFragment);
  //with backstack
  FragmentUtil.Companion.onAddFragment(@LayoutRes int layout,FragmentManager fragmentManager,Fragment fromFragment,Fragment toFragment);
```

# Helper
## RecyclerLayoutManager
* RecyclerLinearLayoutManager(FragmentActivity activity,int LinearLayout.Orrientation, boolean reverseLayout);
* RecyclerGridLayoutManager(Context context, int spanCount, int LinearLayout.Orrientation, boolean reverseLayout);
* RecyclerStaggeredLayoutManager(int spanCount, int LinearLayout.Orrientation);
## RecyclerAnimHelper [(Wasabeef RecyclerView Animator)](https://github.com/wasabeef/recyclerview-animators)
* add animation to recyclerview.

|               Animation              |
| :----------------------------------: |
| RecyclerAnimHelper.Anim.ALPHA_IN     |
| RecyclerAnimHelper.Anim.SCALE_IN     |
| RecyclerAnimHelper.Anim.SLIDE_BOTTOM |
| RecyclerAnimHelper.Anim.SLIDE_LEFT   |
| RecyclerAnimHelper.Anim.SLIDE_RIGHT  |

```java
  RecyclerAnimHelper anim = new RecyclerAnimHelper(FragmentActivity activity);
  anim.addAnim(RecyclerAnimHelper.Anim animation)
      .setRecyclerView(RecyclerView recyclerView)
      .setpocketAdapter(PocketAdapter adapter)  // your recyclerview adapter should be extend with pocketAdapter
      .setLayoutManager(RecyclerLayoutManager layoutManager)
      .commit();
```
