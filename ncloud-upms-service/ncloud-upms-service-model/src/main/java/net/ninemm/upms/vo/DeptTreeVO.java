/*
 * Copyright (c) 2015-2018, Eric Huang 黄鑫 (ninemm@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package net.ninemm.upms.vo;

import net.ninemm.base.utils.layer.TreeEntity;

import java.util.List;

/**
 * 部门树节点实体类
 *
 * @author Eric.Huang
 * @date 2018-12-15 13:39
 **/

public class DeptTreeVO<T extends DeptTreeVO> implements TreeEntity {

    public String id;
    public String label;
    public String parentId;
    public List<T> children;

    public boolean disabled = false;
    public boolean isLeaf = true;
    public boolean isUser = false ;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getParentId() {
        return this.parentId;
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<T> getChildren() {
        return children;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }
}
