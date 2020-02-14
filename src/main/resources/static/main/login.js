/**
 * 登录
 */
layui.use(['form', 'layer'], function () {
    if (window != top)
        top.location.href = location.href;
    var layer = layui.layer; // 获取layer模块
    var form = layui.form;
    var vmData = {
        data: {
            loginName: "admin",
            loginPassword: "admin.123"
        },
        error: {
        	loginFail: (type === "kickout" ? "您的账号已在另一地点登录，您已被强制下线！" : "")
        }
    }

    var vm = new Vue({
        el: '#login-form',
        data: vmData,
        methods: {},
        mounted: function () {

        }
    });
    form.on('submit(*)', function (data) {
        // 登录表单提交操作
        layer.loadingWithText("登陆中...");
        commonUtils.postAjax(_ctx + "main/login", vmData.data, function (data) {
            layer.closeAll("loading");
            if (!data.success) {
                layer.error(data.msg);
            } else {
                top.location.href = _ctx;
            }
        });
    });
});