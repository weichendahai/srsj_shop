package com.srsj.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weichen on 2017/6/5.
 */
public class EleTreeNodeUtil {
    /**
     * @Title: getfatherNode
     * @Description 方法描述: 父节点
     * @param @param treeDataList
     * @param @return
     * @return 返回类型：List<JsonTreeData>
     * @throws
     * @date 最后修改时间：2015年6月9日 下午6:39:26
     */
    public final static List<EleTreeNode> getfatherNode(List<EleTreeNode> treeDataList) {
        List<EleTreeNode> newTreeDataList = new ArrayList<EleTreeNode>();
        for (EleTreeNode treeNode : treeDataList) {
            if(treeNode.getPid() == null) {
                //获取父节点下的子节点
                treeNode.setChildren(getChildrenNode(treeNode.getId(),treeDataList));
                treeNode.setState("open");
                newTreeDataList.add(treeNode);
            }
        }
        return newTreeDataList;
    }

    /**
     * @Title: getChildrenNode
     * @Description 方法描述: 子节点
     * @param @param pid
     * @param @param treeDataList
     * @param @return
     * @return 返回类型：List<JsonTreeData>
     * @throws
     * @date 最后修改时间：2015年6月9日 下午6:39:50
     */
    private final static List<EleTreeNode> getChildrenNode(String pid , List<EleTreeNode> treeDataList) {
        List<EleTreeNode> newTreeDataList = new ArrayList<EleTreeNode>();
        for (EleTreeNode treeNode : treeDataList) {
            if(treeNode.getPid() == null)  continue;
            //这是一个子节点
            if(treeNode.getPid().equals(pid)){
                //递归获取子节点下的子节点
                treeNode.setChildren(getChildrenNode(treeNode.getId() , treeDataList));
                newTreeDataList.add(treeNode);
            }
        }
        return newTreeDataList;
    }

}
