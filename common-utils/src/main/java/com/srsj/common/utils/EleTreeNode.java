package com.srsj.common.utils;

import java.util.List;

/**
 * Created by weichen on 2017/6/3.
 */
public class EleTreeNode {

    private String id;
    public  String pid;
    private String label;
    private String state;
    private List<EleTreeNode> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<EleTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<EleTreeNode> children) {
        this.children = children;
    }
}
