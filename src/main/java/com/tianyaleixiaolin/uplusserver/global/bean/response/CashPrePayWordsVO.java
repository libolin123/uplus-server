package com.tianyaleixiaolin.uplusserver.global.bean.response;

/**
 * @author Mr.li wrote on 2018/12/24.
 */
public class CashPrePayWordsVO {
    private String remark;
    private String filePaths;
    private String carryInfoList;

    @Override
    public String toString() {
        return "CashPrePayWordsVO{" +
                "remark='" + remark + '\'' +
                ", filePaths='" + filePaths + '\'' +
                ", carryInfoList='" + carryInfoList + '\'' +
                '}';
    }

    public String getCarryInfoList() {
        return carryInfoList;
    }

    public void setCarryInfoList(String carryInfoList) {
        this.carryInfoList = carryInfoList;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(String filePaths) {
        this.filePaths = filePaths;
    }
}
