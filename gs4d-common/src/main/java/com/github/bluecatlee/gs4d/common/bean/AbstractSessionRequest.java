package com.github.bluecatlee.gs4d.common.bean;

import javax.validation.constraints.NotNull;

public class AbstractSessionRequest extends AbstractRequest {

    private static final long serialVersionUID = -8235476499697646973L;

    //    @ApiField(description = "客户编号")
    @NotNull(message = "客户编号不能为空!")
    private Long usrNumId;

    public AbstractSessionRequest() {
    }

    public Long getUsrNumId() {
        return this.usrNumId;
    }

    public void setUsrNumId(Long usrNumId) {
        this.usrNumId = usrNumId;
    }
}

