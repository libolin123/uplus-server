package com.tianyaleixiaolin.uplusserver.global.bean.response;

import com.tianyaleixiaolin.uplusserver.core.company.company.PtCompany;
import com.tianyaleixiaolin.uplusserver.core.company.company.PtCompanyTemp;

/**
 * 查看修改详情时返回的detail
 * @author Mr.li wrote on 2018/11/15.
 */
public class CompanyModifyDetailVO {
    private PtCompany orignal;
    /**
     * 修改过的
     */
    private PtCompanyTemp modified;
    /**
     * 修改人
     */
    private String operatorName;

    @Override
    public String toString() {
        return "CompanyModifyDetailVO{" +
                "orignal=" + orignal +
                ", modified=" + modified +
                ", operatorName='" + operatorName + '\'' +
                '}';
    }

    public PtCompany getOrignal() {
        return orignal;
    }

    public void setOrignal(PtCompany orignal) {
        this.orignal = orignal;
    }

    public PtCompanyTemp getModified() {
        return modified;
    }

    public void setModified(PtCompanyTemp modified) {
        this.modified = modified;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
