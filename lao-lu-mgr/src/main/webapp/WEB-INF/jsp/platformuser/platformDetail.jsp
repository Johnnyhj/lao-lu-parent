<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>平台用户详情</title>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@include file="/taglib.jsp" %>

    <link rel="stylesheet" href="${asiaui}/css/edit.css">

</head>
<body>
<div class="con-box">
    <div class="container-fluid">
        <div class="col-md-12" style="margin-top: 5px;">
            <button type="button" class="btn btn-primary pull-right" onclick="history.go(-1)">返回</button>
        </div>

        <div class="row">
            <div class="col-md-12">
                <h3>平台用户详情</h3>
            </div>

            <div style="padding: 12px 8px;">
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingOne">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                   aria-expanded="true" aria-controls="collapseOne">
                                    详细信息
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"
                             aria-labelledby="headingOne">
                            <div class="panel-body">
                                <div id="customerDiv">

                                    <div class="col-md-12">
                                        <h5>用户支付宝ID</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.userId}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>用户类型</h5>
                                        <div class="con-area">
                                            <div class="col-md-8 ">

                                                <c:if test="${1 eq body.userTypeValue}">
                                                    <p class="lead">公司</p>
                                                </c:if>
                                                <c:if test="${2 eq body.userTypeValue}">
                                                    <p class="lead">个人</p>
                                                </c:if>

                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>用户类型</h5>
                                        <div class="con-area">
                                            <div class="col-md-8 ">

                                                <c:if test="${'Q' eq body.userStatus}">
                                                    <p class="lead">快速注册</p>
                                                </c:if>
                                                <c:if test="${'T' eq body.userStatus}">
                                                    <p class="lead">已认证</p>
                                                </c:if>
                                                <c:if test="${'B' eq body.userStatus}">
                                                    <p class="lead">被冻结</p>
                                                </c:if>
                                                <c:if test="${'W' eq body.userStatus}">
                                                    <p class="lead">已注册，未激活</p>
                                                </c:if>

                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>公司名称</h5>
                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.firmName}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>真实姓名</h5>
                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.realName}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>性别</h5>
                                        <div class="con-area">
                                            <div class="col-md-8 ">

                                                <c:if test="${'F' eq body.gender}">
                                                    <p class="lead">公司</p>
                                                </c:if>
                                                <c:if test="${'M' eq body.gender}">
                                                    <p class="lead">个人</p>
                                                </c:if>

                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>邮箱</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.email}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>证件号</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.certNo}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>证件类型</h5>

                                        <%--
                                            证件类型:
                                                0:身份证
                                                1:护照
                                                2:军官证
                                                3:士兵证
                                                4:回乡证
                                                5:临时身份证
                                                6:户口簿
                                                7:警官证
                                                8:台胞证
                                                9:营业执照
                                                10其它证件
                                        --%>
                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <c:if test="${0 eq body.certTypeValue}">
                                                    <p class="lead">身份证</p>
                                                </c:if>
                                                <c:if test="${1 eq body.certTypeValue}">
                                                    <p class="lead">护照</p>
                                                </c:if>
                                                <c:if test="${2 eq body.certTypeValue}">
                                                    <p class="lead">军官证</p>
                                                </c:if>
                                                <c:if test="${3 eq body.certTypeValue}">
                                                    <p class="lead">士兵证</p>
                                                </c:if>
                                                <c:if test="${4 eq body.certTypeValue}">
                                                    <p class="lead">回乡证</p>
                                                </c:if>
                                                <c:if test="${5 eq body.certTypeValue}">
                                                    <p class="lead">临时生分证</p>
                                                </c:if>
                                                <c:if test="${6 eq body.certTypeValue}">
                                                    <p class="lead">户口簿</p>
                                                </c:if>
                                                <c:if test="${7 eq body.certTypeValue}">
                                                    <p class="lead">警官证</p>
                                                </c:if>
                                                <c:if test="${8 eq body.certTypeValue}">
                                                    <p class="lead">台胞证</p>
                                                </c:if>
                                                <c:if test="${9 eq body.certTypeValue}">
                                                    <p class="lead">营业执照</p>
                                                </c:if>
                                                <c:if test="${10 eq body.certTypeValue}">
                                                    <p class="lead">其他证件</p>
                                                </c:if>

                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>区域编码</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.addressCode}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>支付宝用户ID</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.alipayUserId}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>电话号码</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.phone}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>手机号码</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.mobile}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>身份证正面照</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <img src="${body.idcardCorrectUrl}">
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>身份证反面照</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <img src="${body.idcardOppositeUrl}">
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>手持身份证照</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <img src="${body.idcardHandUrl}">
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>


                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>


    </div>
</div>

</body>
</html>