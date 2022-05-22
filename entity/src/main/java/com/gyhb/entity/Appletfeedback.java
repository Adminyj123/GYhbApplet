package com.gyhb.entity;

import tk.mybatis.mapper.annotation.LogicDelete;

import java.util.Date;
import javax.persistence.*;
    @Table(name = "AppletFeedback")
    public class Appletfeedback {
        /**
         * Id
         */
        @Id
        @Column(name = "Id")
        private String id;

        /**
         * 用户ID
         */
        @Column(name = "UserId")
        private String userId;

        /**
         * 反馈的商品对应的ID
         */
        @Column(name = "ProductId")
        private String productId;

        /**
         * 意见类型（0-反馈建议 1-价格不对/优惠券异常 2-商品劣质/虚假/不发货 3-商品主图/营销图不符 4-纠错其他）
         */
        @Column(name = "Type")
        private String type;

        /**
         * 联系电话
         */
        @Column(name = "Phone")
        private String phone;

        /**
         * 反馈内容
         */
        @Column(name = "Info")
        private String info;

        /**
         * 图片信息
         */
        @Column(name = "PicUrl")
        private String picUrl;

        /**
         * 客服回复信息内容（只可以回复一次）
         */
        @Column(name = "ReplyContent")
        private String replyContent;

        /**
         * 回复客服
         */
        @Column(name = "ReplayUser")
        private String replayUser;

        /**
         * 用户设备
         */
        @Column(name = "Device")
        private String device;

        /**
         * 纠错的所有用户ID列表（不重复）
         */
        @Column(name = "CorrectionUser")
        private String correctionUser;

        /**
         * 反馈地区
         */
        @Column(name = "Address")
        private String address;

        /**
         * 状态（0-未读，1-已读，2-处理中，3-已处理）
         */
        @Column(name = "Status")
        private String status;

        /**
         * 创建时间
         */
        @Column(name = "CreatTime")
        private Date creatTime;

        /**
         * 更新时间
         */
        @Column(name = "UpdateTime")
        private Date updateTime;

        /**
         * 逻辑删除
         */
        @Column(name = "IsDeleted")
        @LogicDelete
        private String isDeleted;

        /**
         * 预留字段0
         */
        @Column(name = "AddInfo0")
        private String addInfo0;

        /**
         * 预留字段1
         */
        @Column(name = "AddInfo1")
        private String addInfo1;

        /**
         * 获取Id
         *
         * @return Id - Id
         */
        public String getId() {
            return id;
        }

        /**
         * 设置Id
         *
         * @param id Id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * 获取用户ID
         *
         * @return UserId - 用户ID
         */
        public String getUserId() {
            return userId;
        }

        /**
         * 设置用户ID
         *
         * @param userId 用户ID
         */
        public void setUserId(String userId) {
            this.userId = userId;
        }

        /**
         * 获取反馈的商品对应的ID
         *
         * @return ProductId - 反馈的商品对应的ID
         */
        public String getProductId() {
            return productId;
        }

        /**
         * 设置反馈的商品对应的ID
         *
         * @param productId 反馈的商品对应的ID
         */
        public void setProductId(String productId) {
            this.productId = productId;
        }

        /**
         * 获取意见类型（0-反馈建议 1-价格不对/优惠券异常 2-商品劣质/虚假/不发货 3-商品主图/营销图不符 4-纠错其他）
         *
         * @return Type - 意见类型（0-反馈建议 1-价格不对/优惠券异常 2-商品劣质/虚假/不发货 3-商品主图/营销图不符 4-纠错其他）
         */
        public String getType() {
            return type;
        }

        /**
         * 设置意见类型（0-反馈建议 1-价格不对/优惠券异常 2-商品劣质/虚假/不发货 3-商品主图/营销图不符 4-纠错其他）
         *
         * @param type 意见类型（0-反馈建议 1-价格不对/优惠券异常 2-商品劣质/虚假/不发货 3-商品主图/营销图不符 4-纠错其他）
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * 获取联系电话
         *
         * @return Phone - 联系电话
         */
        public String getPhone() {
            return phone;
        }

        /**
         * 设置联系电话
         *
         * @param phone 联系电话
         */
        public void setPhone(String phone) {
            this.phone = phone;
        }

        /**
         * 获取反馈内容
         *
         * @return Info - 反馈内容
         */
        public String getInfo() {
            return info;
        }

        /**
         * 设置反馈内容
         *
         * @param info 反馈内容
         */
        public void setInfo(String info) {
            this.info = info;
        }

        /**
         * 获取图片信息
         *
         * @return PicUrl - 图片信息
         */
        public String getPicUrl() {
            return picUrl;
        }

        /**
         * 设置图片信息
         *
         * @param picUrl 图片信息
         */
        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        /**
         * 获取客服回复信息内容（只可以回复一次）
         *
         * @return ReplyContent - 客服回复信息内容（只可以回复一次）
         */
        public String getReplyContent() {
            return replyContent;
        }

        /**
         * 设置客服回复信息内容（只可以回复一次）
         *
         * @param replyContent 客服回复信息内容（只可以回复一次）
         */
        public void setReplyContent(String replyContent) {
            this.replyContent = replyContent;
        }

        /**
         * 获取回复客服
         *
         * @return ReplayUser - 回复客服
         */
        public String getReplayUser() {
            return replayUser;
        }

        /**
         * 设置回复客服
         *
         * @param replayUser 回复客服
         */
        public void setReplayUser(String replayUser) {
            this.replayUser = replayUser;
        }

        /**
         * 获取用户设备
         *
         * @return Device - 用户设备
         */
        public String getDevice() {
            return device;
        }

        /**
         * 设置用户设备
         *
         * @param device 用户设备
         */
        public void setDevice(String device) {
            this.device = device;
        }

        /**
         * 获取纠错的所有用户ID列表（不重复）
         *
         * @return CorrectionUser - 纠错的所有用户ID列表（不重复）
         */
        public String getCorrectionUser() {
            return correctionUser;
        }

        /**
         * 设置纠错的所有用户ID列表（不重复）
         *
         * @param correctionUser 纠错的所有用户ID列表（不重复）
         */
        public void setCorrectionUser(String correctionUser) {
            this.correctionUser = correctionUser;
        }

        /**
         * 获取反馈地区
         *
         * @return Address - 反馈地区
         */
        public String getAddress() {
            return address;
        }

        /**
         * 设置反馈地区
         *
         * @param address 反馈地区
         */
        public void setAddress(String address) {
            this.address = address;
        }

        /**
         * 获取状态（0-未读，1-已读，2-处理中，3-已处理）
         *
         * @return Status - 状态（0-未读，1-已读，2-处理中，3-已处理）
         */
        public String getStatus() {
            return status;
        }

        /**
         * 设置状态（0-未读，1-已读，2-处理中，3-已处理）
         *
         * @param status 状态（0-未读，1-已读，2-处理中，3-已处理）
         */
        public void setStatus(String status) {
            this.status = status;
        }

        /**
         * 获取创建时间
         *
         * @return CreatTime - 创建时间
         */
        public Date getCreatTime() {
            return creatTime;
        }

        /**
         * 设置创建时间
         *
         * @param creatTime 创建时间
         */
        public void setCreatTime(Date creatTime) {
            this.creatTime = creatTime;
        }

        /**
         * 获取更新时间
         *
         * @return UpdateTime - 更新时间
         */
        public Date getUpdateTime() {
            return updateTime;
        }

        /**
         * 设置更新时间
         *
         * @param updateTime 更新时间
         */
        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        /**
         * 获取逻辑删除
         *
         * @return IsDeleted - 逻辑删除
         */
        public String getIsDeleted() {
            return isDeleted;
        }

        /**
         * 设置逻辑删除
         *
         * @param isDeleted 逻辑删除
         */
        public void setIsDeleted(String isDeleted) {
            this.isDeleted = isDeleted;
        }

        /**
         * 获取预留字段0
         *
         * @return AddInfo0 - 预留字段0
         */
        public String getAddInfo0() {
            return addInfo0;
        }

        /**
         * 设置预留字段0
         *
         * @param addInfo0 预留字段0
         */
        public void setAddInfo0(String addInfo0) {
            this.addInfo0 = addInfo0;
        }

        /**
         * 获取预留字段1
         *
         * @return AddInfo1 - 预留字段1
         */
        public String getAddInfo1() {
            return addInfo1;
        }

        /**
         * 设置预留字段1
         *
         * @param addInfo1 预留字段1
         */
        public void setAddInfo1(String addInfo1) {
            this.addInfo1 = addInfo1;
        }
    }