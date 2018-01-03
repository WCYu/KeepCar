package com.ysd.keepcar.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.entity.GoodsInfo;
import com.ysd.keepcar.entity.StoreInfo;
import com.ysd.keepcar.utils.UtilTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017-12-28.
 */

public class ShopcatAdapter extends BaseExpandableListAdapter {
    //商店
    private ArrayList<StoreInfo> groups;
    //商品
    private HashMap<String, ArrayList<GoodsInfo>> childs;
    private Context mContext;
    //复选框的接口
    private CheckInterface checkInterface;
    //修改数量接口
    private ModifyCountInterface modifyCountInterface;
    //判断图片是否点击
    private int count = 0;
    //组的编辑按钮 是否点击，false 没有 true 有
    private boolean flag = false;


    ChildEditorListener childEditorListener;

    public ShopcatAdapter(ArrayList<StoreInfo> groups, HashMap<String, ArrayList<GoodsInfo>> childs, Context mContext) {
        this.groups = groups;
        this.childs = childs;
        this.mContext = mContext;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childs.get(groups.get(i).getId()).size();
    }

    @Override
    public Object getGroup(int i) {
        return groups.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        List<GoodsInfo> childes = childs.get(groups.get(i).getId());
        return childes.get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //店铺
    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder groupViewHolder;
        if (view == null) {
            view = View.inflate(mContext, R.layout.item_shopcat_group, null);
            groupViewHolder = new GroupViewHolder(view);
            view.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) view.getTag();
        }
        final StoreInfo group = (StoreInfo) getGroup(i);
        //设置店铺的名称
        groupViewHolder.store_name.setText(group.getName());
        //店铺的CheckBox
        groupViewHolder.store_checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                group.setChoosed(((CheckBox) view).isChecked());
                checkInterface.checkGroup(i, ((CheckBox) view).isChecked());
            }
        });
        groupViewHolder.store_checkBox.setChecked(group.isChoosed());
        return view;
    }

    //商品
    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        final ChildViewHolder childViewHolder;
        if (view == null) {
            view = View.inflate(mContext, R.layout.item_shopcat_product, null);
            childViewHolder = new ChildViewHolder(view);
            view.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) view.getTag();
        }
        final GoodsInfo child = (GoodsInfo) getChild(i, i1);
        if (child != null) {
            //派送方式
            childViewHolder.goods_name.setText(child.getDesc());
            //价格
            childViewHolder.goods_price.setText("￥" + child.getPrice() + "");
            //图片
            childViewHolder.goods_image.setImageResource(R.drawable.cmaz);
            //小标题
            childViewHolder.goods_carMsg.setText(child.getCarMsg());
            //派送方式
            childViewHolder.goods_distribution.setText(child.getGetWay());
            //设置数量
            childViewHolder.goods_buyNum.setText("x" + child.getCount() + "");

            childViewHolder.goods_Num.setText(String.valueOf(child.getCount()));
            //设置是否选中
            childViewHolder.single_checkBox.setChecked(child.isChoosed());
            childViewHolder.single_checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    child.setChoosed(((CheckBox) v).isChecked());
                    childViewHolder.single_checkBox.setChecked(((CheckBox) v).isChecked());
                    checkInterface.checkChild(i, i1, ((CheckBox) v).isChecked());
                }
            });
            if (child.isActionBarEditor()) {
                child.setEditor(false);
                //groupViewHolder.store_edit.setVisibility(View.GONE);
                flag = false;
            } else {
                flag = true;
                //groupViewHolder.store_edit.setVisibility(View.VISIBLE);
            }

            if (child.isEditor()) {
                childViewHolder.edit_goods_data.setVisibility(View.VISIBLE);
                childViewHolder.goods_data.setVisibility(View.GONE);
            } else {
                childViewHolder.edit_goods_data.setVisibility(View.GONE);
                childViewHolder.goods_data.setVisibility(View.VISIBLE);
            }
            childViewHolder.iv_compile.setOnClickListener(new ChildViewClick(child, i, i1, childViewHolder.iv_compile));

        /*    MainActivity.actionBar_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //如果选中的话
                    if (MainActivity.actionBar_edit.isChecked()) {
                        int postion = child.getPostion();
                        Toast.makeText(mContext, "aaaaaaaa", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, "bbbbb", Toast.LENGTH_SHORT).show();
                    }
                }
            });*/

            //显示完成的布局
            childViewHolder.finish_goods.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    childViewHolder.edit_goods_data.setVisibility(View.GONE);
                    childViewHolder.goods_data.setVisibility(View.VISIBLE);
                }
            });
            //减号
            childViewHolder.reduce_goodsNum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    modifyCountInterface.doDecrease(i, i1, childViewHolder.goods_Num, childViewHolder.single_checkBox.isChecked());
                }
            });
            //加
            childViewHolder.increase_goods_Num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    modifyCountInterface.doIncrease(i, i1, childViewHolder.goods_Num, childViewHolder.single_checkBox.isChecked());
                }
            });
            childViewHolder.goods_Num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog(i, i1, childViewHolder.goods_Num, childViewHolder.single_checkBox.isChecked(), child);
                }
            });

        }


        return view;
    }

    private void showDialog(final int groupPosition, final int childPosition, final View showCountView, final boolean isChecked, final GoodsInfo child) {
        final AlertDialog.Builder alertDialog_Builder = new AlertDialog.Builder(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_change_num, null);
        final AlertDialog dialog = alertDialog_Builder.create();
        dialog.setView(view);//errored,这里是dialog，不是alertDialog_Buidler
        count = child.getCount();
        final EditText num = (EditText) view.findViewById(R.id.dialog_num);
        num.setText(count + "");
        //自动弹出键盘
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                UtilTool.showKeyboard(mContext, showCountView);
            }
        });
        final TextView increase = (TextView) view.findViewById(R.id.dialog_increaseNum);
        final TextView DeIncrease = (TextView) view.findViewById(R.id.dialog_reduceNum);
        final TextView pButton = (TextView) view.findViewById(R.id.dialog_Pbutton);
        final TextView nButton = (TextView) view.findViewById(R.id.dialog_Nbutton);
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(num.getText().toString().trim());
                if (number == 0) {
                    dialog.dismiss();
                } else {
                    num.setText(String.valueOf(number));
                    child.setCount(number);
                    modifyCountInterface.doUpdate(groupPosition, childPosition, showCountView, isChecked);
                    dialog.dismiss();
                }
            }
        });
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                num.setText(String.valueOf(count));
            }
        });
        DeIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 1) {
                    count--;
                    num.setText(String.valueOf(count));
                }
            }
        });
        dialog.show();
    }


    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


    /**
     * 监听子条目的编辑状态
     */
    public interface ChildEditorListener {
        void childEditor(int groupPosition, int childPosition);
    }

    public ChildEditorListener getChildEditorListener() {
        return childEditorListener;
    }

    public void setChildEditorListener(ChildEditorListener childEditorListener) {
        this.childEditorListener = childEditorListener;
    }


    /**
     * 使某个小组处于编辑状态
     */
    private class ChildViewClick implements View.OnClickListener {
        private GoodsInfo child;
        private int groupPosition;
        private int childPosition;
        private ImageView iv_compile;


        public ChildViewClick(GoodsInfo child, int groupPosition, int childPosition, ImageView iv_compile) {
            this.child = child;
            this.groupPosition = groupPosition;
            this.childPosition = childPosition;
            this.iv_compile = iv_compile;
        }


        @Override
        public void onClick(View v) {
            if (iv_compile.getId() == v.getId()) {
                childEditorListener.childEditor(groupPosition, childPosition);
                if (child.isEditor()) {
                    child.setEditor(false);
                } else {
                    child.setEditor(true);
                }
                notifyDataSetChanged();
            }
        }
    }


    /**
     * 店铺的复选框
     */
    public interface CheckInterface {
        /**
         * 组选框状态改变触发的事件
         * 组元素的位置  组元素的选中与否
         */
        void checkGroup(int groupPosition, boolean isChecked);

        /**
         * 子选框状态改变触发的事件
         * 组元素的位置 子元素的位置 子元素的选中与否
         */
        void checkChild(int groupPosition, int childPosition, boolean isChecked);
    }

    public CheckInterface getCheckInterface() {
        return checkInterface;
    }

    public void setCheckInterface(CheckInterface checkInterface) {
        this.checkInterface = checkInterface;
    }

    /**
     * 改变数量的接口
     */
    public interface ModifyCountInterface {
        /**
         * 增加操作
         *
         * @param groupPosition 组元素的位置
         * @param childPosition 子元素的位置
         * @param showCountView 用于展示变化后数量的View
         * @param isChecked     子元素选中与否
         */
        void doIncrease(int groupPosition, int childPosition, View showCountView, boolean isChecked);


        void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked);


        void doUpdate(int groupPosition, int childPosition, View showCountView, boolean isChecked);


        /**
         * 删除子Item
         */
        // void childDelete(int groupPosition, int childPosition);
    }

    public ModifyCountInterface getModifyCountInterface() {
        return modifyCountInterface;
    }


    public void setModifyCountInterface(ModifyCountInterface modifyCountInterface) {
        this.modifyCountInterface = modifyCountInterface;
    }


    public class GroupViewHolder {
        public View rootView;
        public CheckBox store_checkBox;
        public TextView store_name;

        public GroupViewHolder(View rootView) {
            this.rootView = rootView;
            this.store_checkBox = (CheckBox) rootView.findViewById(R.id.store_checkBox);
            this.store_name = (TextView) rootView.findViewById(R.id.store_name);
        }

    }

    public class ChildViewHolder {
        public View rootView;
        public CheckBox single_checkBox;
        public ImageView goods_image;
        public TextView goods_name;
        public ImageView iv_compile;
        public TextView goods_carMsg;
        public TextView goods_distribution;
        public TextView goods_price;
        public TextView goods_buyNum;
        public RelativeLayout goods_data;
        public TextView reduce_goodsNum;
        public TextView goods_Num;
        public TextView increase_goods_Num;
        public TextView goodsSize;
        public TextView finish_goods;
        public LinearLayout edit_goods_data;

        public ChildViewHolder(View rootView) {
            this.rootView = rootView;
            this.single_checkBox = (CheckBox) rootView.findViewById(R.id.single_checkBox);
            this.goods_image = (ImageView) rootView.findViewById(R.id.goods_image);
            this.goods_name = (TextView) rootView.findViewById(R.id.goods_name);
            this.iv_compile = (ImageView) rootView.findViewById(R.id.iv_compile);
            this.goods_carMsg = (TextView) rootView.findViewById(R.id.goods_carMsg);
            this.goods_distribution = (TextView) rootView.findViewById(R.id.goods_distribution);
            this.goods_price = (TextView) rootView.findViewById(R.id.goods_price);
            this.goods_buyNum = (TextView) rootView.findViewById(R.id.goods_buyNum);
            this.goods_data = (RelativeLayout) rootView.findViewById(R.id.goods_data);
            this.reduce_goodsNum = (TextView) rootView.findViewById(R.id.reduce_goodsNum);
            this.goods_Num = (TextView) rootView.findViewById(R.id.goods_Num);
            this.increase_goods_Num = (TextView) rootView.findViewById(R.id.increase_goods_Num);
            this.goodsSize = (TextView) rootView.findViewById(R.id.goodsSize);
            this.finish_goods = (TextView) rootView.findViewById(R.id.finish_goods);
            this.edit_goods_data = (LinearLayout) rootView.findViewById(R.id.edit_goods_data);
        }

    }
}
