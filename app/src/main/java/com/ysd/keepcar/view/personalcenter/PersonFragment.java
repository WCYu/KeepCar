package com.ysd.keepcar.view.personalcenter;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ysd.keepcar.R;
import com.ysd.keepcar.app.BaseFragment;
import com.ysd.keepcar.utils.ImageUtils;
import com.ysd.keepcar.view.personalcenter.myOrder.MyOrderActivity;
import com.ysd.keepcar.view.personalcenter.mycar.MyCarActivity;
import com.ysd.keepcar.view.personalcenter.myshop.MyShopActivity;
import com.ysd.keepcar.view.personalcenter.tab.ChuZhiFragment;
import com.ysd.keepcar.view.personalcenter.tab.DingEFragment;
import com.ysd.keepcar.view.personalcenter.tab.JiFenFragment;
import com.ysd.keepcar.view.personalcenter.tab.XiCheFragment;
import com.ysd.keepcar.view.personalcenter.tab.XiangMuFragment;
import com.ysd.keepcar.view.personalcenter.tab.YuEFragment;
import com.ysd.keepcar.view.personalcenter.tab.ZheKouFragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * 个人页面
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends BaseFragment implements View.OnClickListener {


    private static final String TAG = "MainActivity";

    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;

    private ImageView imageView;
    private TextView textView;
    private ImageView imageView2;
    private LinearLayout wodecheliang;
    private LinearLayout dangqiancheliang;
    private LinearLayout zhanghu;
    private LinearLayout dianpu;
    private ViewPager vp_person;
    private RelativeLayout wodedingdan_person;
    private ImageView wode;
    private TabLayout tab_person;

    private int big[]=new int[]{
            R.drawable.onetab,
            R.drawable.twotab,
            R.drawable.threetab,
            R.drawable.fourtab,
            R.drawable.fivetab,
            R.drawable.sixtab,
            R.drawable.seventab};

    @Override
    public int getInitId() {
        return R.layout.fragment_person;
    }

    public void initView(View inflate) {
        imageView = (ImageView) inflate.findViewById(R.id.imageView);
        textView = (TextView) inflate.findViewById(R.id.textView);
        imageView2 = (ImageView) inflate.findViewById(R.id.imageView2);
        wodecheliang = (LinearLayout) inflate.findViewById(R.id.wodecheliang_person);
        dangqiancheliang = (LinearLayout) inflate.findViewById(R.id.dangqiancheliang_person);
        zhanghu = (LinearLayout) inflate.findViewById(R.id.zhanghu_person);
        dianpu = (LinearLayout) inflate.findViewById(R.id.dianpu_person);
        wode = inflate.findViewById(R.id.imageView2);
        tab_person = inflate.findViewById(R.id.tab_person);
        vp_person = inflate.findViewById(R.id.vp_person);


        imageView.setOnClickListener(this);
        wodecheliang.setOnClickListener(this);
        dangqiancheliang.setOnClickListener(this);
        zhanghu.setOnClickListener(this);
        dianpu.setOnClickListener(this);
        wode.setOnClickListener(this);
    }

    @Override
    public void initData() {
        List<String> tabs = new ArrayList<>();
        tabs.add("积分");
        tabs.add("储值");
        tabs.add("洗车");
        tabs.add("级别折扣");
        tabs.add("项目");
        tabs.add("定额券");
        tabs.add("余额券");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new JiFenFragment());
        fragmentList.add(new ChuZhiFragment());
        fragmentList.add(new XiCheFragment());
        fragmentList.add(new ZheKouFragment());
        fragmentList.add(new XiangMuFragment());
        fragmentList.add(new DingEFragment());
        fragmentList.add(new YuEFragment());

        FragmentAdapter adapter = new FragmentAdapter(getActivity().getSupportFragmentManager(),tabs,fragmentList,getActivity(),big);
        vp_person.setAdapter(adapter);
        tab_person.setupWithViewPager(vp_person);

    }

    @Override
    public void initAdapter() {

    }

    @Override
    public void initLinstener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView:
                showChoosePicDialog(imageView);
                break;
            case R.id.wodecheliang_person:
                Intent intent1 = new Intent(getActivity(), MyCarActivity.class);
                startActivity(intent1);
                Toast.makeText(getActivity(), "我的车辆", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dangqiancheliang_person:
                Intent intent2 = new Intent(getActivity(), MyCarActivity.class);
                startActivity(intent2);
                Toast.makeText(getActivity(), "当前车辆", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zhanghu_person:
                Toast.makeText(getActivity(), "账户", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dianpu_person:
                Intent intent4 = new Intent(getActivity(), MyShopActivity.class);
                startActivity(intent4);
                Toast.makeText(getActivity(), "店铺", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView2:
                Intent intent = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 显示修改头像的对话框
     */
    public void showChoosePicDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("设置头像");
        String[] items = {"选择本地照片", "拍照"};
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case TAKE_PICTURE: // 拍照
                        takePicture();
                        break;
                }
            }
        });
        builder.create().show();
    }

    private void takePicture() {
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT >= 23) {
            // 需要申请动态权限
            int check = ContextCompat.checkSelfPermission(getActivity(), permissions[0]);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (check != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
        Intent openCameraIntent = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE);
        File file = new File(Environment
                .getExternalStorageDirectory(), "image.jpg");
        //判断是否是AndroidN以及更高的版本
        if (Build.VERSION.SDK_INT >= 24) {
            openCameraIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            tempUri = FileProvider.getUriForFile(getActivity(), "com.lt.uploadpicdemo.fileProvider", file);
        } else {
            tempUri = Uri.fromFile(new File(Environment
                    .getExternalStorageDirectory(), "image.jpg"));
        }
        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
        startActivityForResult(openCameraIntent, TAKE_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            Log.d(TAG, "setImageToView:" + photo);
            photo = ImageUtils.toRoundBitmap(photo); // 这个时候的图片已经被处理成圆形的了
            imageView.setImageBitmap(photo);
            uploadPic(photo);
        }
    }

    private void uploadPic(Bitmap bitmap) {
        // 上传至服务器
        // ... 可以在这里把Bitmap转换成file，然后得到file的url，做文件上传操作
        // 注意这里得到的图片已经是圆形图片了
        // bitmap是没有做个圆形处理的，但已经被裁剪了
        String imagePath = ImageUtils.savePhoto(bitmap, Environment
                .getExternalStorageDirectory().getAbsolutePath(), String
                .valueOf(System.currentTimeMillis()));
        Log.e("imagePath", imagePath + "");
        if (imagePath != null) {
            // 拿着imagePath上传了
            // ...
            Log.d(TAG, "imagePath:" + imagePath);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        } else {
            // 没有获取 到权限，从新请求，或者关闭app
            Toast.makeText(getActivity(), "需要存储权限", Toast.LENGTH_SHORT).show();
        }
    }
}
