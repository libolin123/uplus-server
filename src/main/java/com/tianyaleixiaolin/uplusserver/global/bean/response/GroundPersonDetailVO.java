package com.tianyaleixiaolin.uplusserver.global.bean.response;

/**
 * 地勤人员
 *
 * @author Mr.li wrote on 2018/11/16.
 */
public class GroundPersonDetailVO {
    private Long id;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 男1女0
     */
    private Integer sex;
    private String province;
    private String city;
    private String country;
    /**
     * 地区负责人
     */
    private boolean areaOwner;
    /**
     * 医院id集合，逗号分隔
     */
    private String hospitalIds;
    /**
     * 证件号码
     */
    private String paper;
    /**
     * 电话号码
     */
    private String mobile;
    /**
     * 银行账户                                                                                                    
     */
    private String bankCardNum;
    /**
     * 银行名称
     */
    private String bank;
    /**
     * group=5key的集合，人员技能标签
     */
    private String skills;
    /**
     * 排班，周一上下午，周二上下午之类的。1，2是周一上下午，3，4周二上下午
     */
    private String workTimes;

    private String remark;
    /**
     * 微信openId
     */
    private String openid;
    /**
     * 微信昵称
     */
    private String wechatName;
    /////////***********1.1新增**********///////
    /**
     * 一二级科室
     */
    private String dept1;
    private String dept2;
    /**
     * 护士职称，group=4
     */
    private String level;
    /**
     * 收件地址
     */
    private String address;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 身份证照，逗号分隔
     */
    private String paperPics;
    /**
     * 护士证号
     */
    private String nurseNum;
    /**
     * 地区负责人id
     */
    private Long areaOwnerId;
    /**
     * 护士证照
     */
    private String nursePics;
    /**
     * 审核状态（-1待审核，0正常，-2被拒绝）
     */
    private Integer state;

    /**
     * 是否签约
     */
    private Boolean sign;
    private Boolean deleteFlag;

    @Override
    public String toString() {
        return "GroundPersonDetailVO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", areaOwner=" + areaOwner +
                ", hospitalIds='" + hospitalIds + '\'' +
                ", paper='" + paper + '\'' +
                ", mobile='" + mobile + '\'' +
                ", bankCardNum='" + bankCardNum + '\'' +
                ", bank='" + bank + '\'' +
                ", skills='" + skills + '\'' +
                ", workTimes='" + workTimes + '\'' +
                ", remark='" + remark + '\'' +
                ", openid='" + openid + '\'' +
                ", wechatName='" + wechatName + '\'' +
                ", dept1='" + dept1 + '\'' +
                ", dept2='" + dept2 + '\'' +
                ", level='" + level + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", paperPics='" + paperPics + '\'' +
                ", nurseNum='" + nurseNum + '\'' +
                ", areaOwnerId=" + areaOwnerId +
                ", nursePics='" + nursePics + '\'' +
                ", state=" + state +
                ", sign=" + sign +
                '}';
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSign() {
        return sign;
    }

    public void setSign(Boolean sign) {
        this.sign = sign;
    }

    public String getNurseNum() {
        return nurseNum;
    }

    public void setNurseNum(String nurseNum) {
        this.nurseNum = nurseNum;
    }

    public Long getAreaOwnerId() {
        return areaOwnerId;
    }

    public void setAreaOwnerId(Long areaOwnerId) {
        this.areaOwnerId = areaOwnerId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDept1() {
        return dept1;
    }

    public void setDept1(String dept1) {
        this.dept1 = dept1;
    }

    public String getDept2() {
        return dept2;
    }

    public void setDept2(String dept2) {
        this.dept2 = dept2;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaperPics() {
        return paperPics;
    }

    public void setPaperPics(String paperPics) {
        this.paperPics = paperPics;
    }

    public String getNursePics() {
        return nursePics;
    }

    public void setNursePics(String nursePics) {
        this.nursePics = nursePics;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public Integer getSex() {
        return sex;
    }

    public String getBankCardNum() {
        return bankCardNum;
    }

    public void setBankCardNum(String bankCardNum) {
        this.bankCardNum = bankCardNum;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isAreaOwner() {
        return areaOwner;
    }

    public void setAreaOwner(boolean areaOwner) {
        this.areaOwner = areaOwner;
    }

    public String getHospitalIds() {
        return hospitalIds;
    }

    public void setHospitalIds(String hospitalIds) {
        this.hospitalIds = hospitalIds;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(String workTimes) {
        this.workTimes = workTimes;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
