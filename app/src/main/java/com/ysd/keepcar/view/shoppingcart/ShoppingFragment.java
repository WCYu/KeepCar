package com.ysd.keepcar.view.shoppingcart;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.adapter.ShopcatAdapter;
import com.ysd.keepcar.entity.GoodsInfo;
import com.ysd.keepcar.entity.StoreInfo;
import com.ysd.keepcar.utils.UtilTool;
import com.ysd.keepcar.utils.UtilsLog;
import com.ysd.keepcar.view.shoppingcart.activity.RealOrderActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * 购物车
 * 购物车的思路：数据库 ---暂未实现
 * 1.判断是否加入购物车，如果没有在让用户进入App商铺逛逛  暂未实现
 * 2.判断从哪家店铺添加的商品（ 店铺名称--- 点击跳进相应的店铺
 * 商品信息---图片（判断是从什么地方加入的购物车，并添加Logo 洗车或项目）
 * ---商品名称  车牌号 品牌 车系  取货方式--快递 自取 上门安装
 * ---价格
 * ）   暂未实现
 * 3.点击编辑所有----商品条目改变成编辑状态，判断是否有加入购物车，显示没有购物车 和加入购物布局的切换  暂未实现
 * 4.点击提交订单---跳转到确定订单界面
 */
public class ShoppingFragment extends Fragment implements View.OnClickListener, ShopcatAdapter.CheckInterface, ShopcatAdapter.ModifyCountInterface, ShopcatAdapter.ChildEditorListener {
    private ArrayList<StoreInfo> groups;
    private HashMap<String, ArrayList<GoodsInfo>> childs;
    private ExpandableListView ev_listView;
    private LinearLayout ll_cart;
    private CheckBox all_checkBox;
    private TextView total_price;
    private TextView go_pay;
    private LinearLayout order_info;
    private ShopcatAdapter adapter;
    private double mtotalPrice;
    private int mtotalCount;
    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_shopping, container, false);
        initView(inflate);
        //加载数据
        setListViewHeightBasedOnChildren(ev_listView);
        initData();

        return inflate;
    }

    private void initData() {
        groups = new ArrayList<StoreInfo>();
        childs = new HashMap<String, ArrayList<GoodsInfo>>();
        for (int i = 0; i < 5; i++) {
            groups.add(new StoreInfo(i + "", "小马的第" + (i + 1) + "号当铺"));
            ArrayList<GoodsInfo> goods = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int[] img = {R.drawable.cmaz, R.drawable.cmaz, R.drawable.cmaz, R.drawable.cmaz, R.drawable.cmaz, R.drawable.cmaz};

                //i-j 就是商品的id， 对应着第几个店铺的第几个商品，1-1 就是第一个店铺的第一个商品
                goods.add(new GoodsInfo(i + "-" + j, "商品", groups.get(i).getName() + "的第" + (j + 1) + "\n"+"个商品双12活动购买", 255.00 + new Random().nextInt(155), "奥迪" + j, "快递", img[j], new Random().nextInt(100)));
            }
            childs.put(groups.get(i).getId(), goods);
        }
        adapter = new ShopcatAdapter(groups, childs, getActivity());
        //设置复选框的接口
        adapter.setChildEditorListener(this);
        adapter.setCheckInterface(this);
        adapter.setModifyCountInterface(this);
        ev_listView.setGroupIndicator(null);
        ev_listView.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            ev_listView.expandGroup(i);
            Log.e("e", String.valueOf(i));
        }
        //二级列表的滑动监听
        ev_listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }
            /*
                firstVisibleItem--i 第一条目
                visibleItemCount--i1 显示条目
                totalItemCount--总条目
                */

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                //获取第一条目
                int firstVisiablePostion = absListView.getFirstVisiblePosition();
                int top = -1;
                View firstView = absListView.getChildAt(i);
                UtilsLog.i("childCount=" + absListView.getChildCount());//返回的是显示层面上的所包含的子view的个数
                if (firstView != null) {
                    top = firstView.getTop();
                }
                UtilsLog.i("firstVisiableItem=" + i + ",fistVisiablePosition=" + firstVisiablePostion + ",firstView=" + firstView + ",top=" + top);
             /*   if (i == 0 && top == 0) {
                    mPtrFrame.setEnabled(true);
                } else {
                    mPtrFrame.setEnabled(false);
                }
*/
            }
        });


    }


    private void initView(View inflate) {
        //二级列表
        ev_listView = (ExpandableListView) inflate.findViewById(R.id.ev_listView);
        //是否全选
        all_checkBox = (CheckBox) inflate.findViewById(R.id.all_checkBox);
        //总价格
        total_price = (TextView) inflate.findViewById(R.id.total_price);
        //提交订单
        go_pay = (TextView) inflate.findViewById(R.id.go_pay);
        //提交订单的总布局
        order_info = (LinearLayout) inflate.findViewById(R.id.order_info);
        //整体布局--包含二级列表，全选 --价格--订单 -订单总布局
        ll_cart = (LinearLayout) inflate.findViewById(R.id.ll_cart);
        //全选的监听
        all_checkBox.setOnClickListener(this);
        go_pay.setOnClickListener(this);
    }

    //scrollView嵌套ExpandableListView
    public static void setListViewHeightBasedOnChildren(ExpandableListView listView) {
        // 获取ListView对应的Adapter
        ExpandableListAdapter listAdapter = listView.getExpandableListAdapter();
        if (listAdapter == null) {
            // pre -condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            // listAdapter.getCount()返回数据项的数目
            View listgroupItem = listAdapter.getGroupView(i, true, null, listView);
            listgroupItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listgroupItem.getMeasuredHeight(); // 统计所有子项的总高度
            System.out.println("height : group" + i + "次" + totalHeight);
            for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                View listchildItem = listAdapter.getChildView(i, j, false, null, listView);
                listchildItem.measure(0, 0); // 计算子项View 的宽高
                totalHeight += listchildItem.getMeasuredHeight(); // 统计所有子项的总高度
                System.out.println("height :" + "group:" + i + " child:" + j + "次" + totalHeight);
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //是否全选
            case R.id.all_checkBox:
                doCheckAll();
                break;
            //点击提交订单，判断是否有选择要支付的商品，有的话，直接进行下一个界面(需要传值---死数据)
            case R.id.go_pay:
                if (mtotalCount == 0) {
                    UtilTool.toast(getActivity(), "请选择您要结算的物品");
                    return;
                }
                startActivity(new Intent(getActivity(), RealOrderActivity.class));
                break;
        }
    }

    private void doCheckAll() {
        for (int i = 0; i < groups.size(); i++) {
            StoreInfo storeInfo = groups.get(i);
            storeInfo.setChoosed(all_checkBox.isChecked());
            ArrayList<GoodsInfo> goodsInfos = childs.get(storeInfo.getId());
            for (int j = 0; j < goodsInfos.size(); j++) {
                goodsInfos.get(j).setChoosed(all_checkBox.isChecked());
            }
        }
        adapter.notifyDataSetChanged();
        calulate();
    }

    /**
     * 计算商品总价格，操作步骤
     * 1.先清空全局计价,计数
     * 2.遍历所有的子元素，只要是被选中的，就进行相关的计算操作
     * 3.给textView填充数据
     */
    private void calulate() {
        mtotalPrice = 0.00;
        mtotalCount = 0;
        for (int i = 0; i < groups.size(); i++) {
            StoreInfo group = groups.get(i);
            List<GoodsInfo> child = childs.get(group.getId());
            for (int j = 0; j < child.size(); j++) {
                GoodsInfo good = child.get(j);
                if (good.isChoosed()) {
                    mtotalCount++;
                    mtotalPrice += good.getPrice() * good.getCount();
                }
            }
        }
        total_price.setText("￥" + mtotalPrice + "");
    }

    @Override
    public void checkGroup(int groupPosition, boolean isChecked) {
        StoreInfo group = groups.get(groupPosition);
        List<GoodsInfo> child = childs.get(group.getId());
        for (int i = 0; i < child.size(); i++) {
            child.get(i).setChoosed(isChecked);
        }
        if (isCheckAll()) {
            all_checkBox.setChecked(true);//全选
        } else {
            all_checkBox.setChecked(false);//反选
        }
        adapter.notifyDataSetChanged();
        calulate();
    }

    @Override
    public void checkChild(int groupPosition, int childPosition, boolean isChecked) {
        boolean allChildSameState = true; //判断该组下面的所有子元素是否处于同一状态
        StoreInfo group = groups.get(groupPosition);
        List<GoodsInfo> child = childs.get(group.getId());
        for (int i = 0; i < child.size(); i++) {
            //不选全中
            if (child.get(i).isChoosed() != isChecked) {
                allChildSameState = false;
                break;
            }
        }
        if (allChildSameState) {
            group.setChoosed(isChecked);//如果子元素状态相同，那么对应的组元素也设置成这一种的同一状态
        } else {
            group.setChoosed(false);//否则一律视为未选中
        }
        if (isCheckAll()) {
            all_checkBox.setChecked(true);//全选
        } else {
            all_checkBox.setChecked(false);//反选
        }
        adapter.notifyDataSetChanged();
        calulate();
    }
    /**
     * 判断组元素是否全选
     */
    private boolean isCheckAll() {
        for (StoreInfo group : groups) {
            if (!group.isChoosed()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void doIncrease(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
        GoodsInfo good = (GoodsInfo) adapter.getChild(groupPosition, childPosition);
        int count = good.getCount();
        count++;
        good.setCount(count);
        ((TextView) showCountView).setText(String.valueOf(count));
        adapter.notifyDataSetChanged();
        calulate();
    }

    @Override
    public void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
        GoodsInfo good = (GoodsInfo) adapter.getChild(groupPosition, childPosition);
        int count = good.getCount();
        if (count == 1) {
            return;
        }
        count--;
        good.setCount(count);
        ((TextView) showCountView).setText("" + count);
        adapter.notifyDataSetChanged();
        calulate();
    }

    @Override
    public void doUpdate(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
        GoodsInfo good = (GoodsInfo) adapter.getChild(groupPosition, childPosition);
        int count = good.getCount();
        UtilsLog.i("进行更新数据，数量" + count + "");
        ((TextView) showCountView).setText(String.valueOf(count));
        adapter.notifyDataSetChanged();
        calulate();
    }

    @Override
    public void childEditor(int groupPosition, int childPosition) {

    }
}
