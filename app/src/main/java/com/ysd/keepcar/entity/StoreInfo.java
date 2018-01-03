package com.ysd.keepcar.entity;

/**
 * Created by Administrator on 2017-12-27.
 * 店铺信息
 *
 * 因为组的编辑没有，所有在再此类不需要 判断 是否都该组的编辑状态 全局对该组的编辑状态，应该在商店信息里
 */
public class StoreInfo {
    private String id;
    private String name;
    private boolean isChoosed;
   /* private boolean isEditor; //自己对该组的编辑状态
    private boolean ActionBarEditor;// 全局对该组的编辑状态*/
    private int flag;
    public StoreInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChoosed() {
        return isChoosed;
    }

    public void setChoosed(boolean choosed) {
        isChoosed = choosed;
    }

  /*  public boolean isEditor() {
        return isEditor;
    }

    public void setEditor(boolean editor) {
        isEditor = editor;
    }

    public boolean isActionBarEditor() {
        return ActionBarEditor;
    }

    public void setActionBarEditor(boolean actionBarEditor) {
        ActionBarEditor = actionBarEditor;
    }*/
}
