/**
 * 菜单表单
 */
var vmData = {
	data : {
		parentId : parentId,
		parentName : parentName,
		icon : ""
	}
};
var layer = null;
layui.use(['element', 'form', 'layer'], function() {
	var element = layui.element;
	var form = layui.form;
	layer = layui.layer;
	form.on('submit(*)', function(data){
		layer.load();
		commonUtils.postAjax(_ctx + "menu/save", vmData.data, function(data) {
			layer.closeAll('loading');
			if (data.success) {
				vmData.data.menuId = data.data;
				layer.success(data.msg);
			} else {
				layer.error(data.msg);
			}
		});
	});
})

var vm = new Vue({
	el : "#vue-container",
	data : vmData,
	methods : {
		searchIcon : function() {
			layer.open({
				type : 2,
				title : '选择图标',
				content : _ctx + "/menu/chooseIconPage",
				area : ['90%', '90%']
			});
		}
	},
	created : function() {
		// 加载基础数据
		if (action == "view" || action == "edit") {
			commonUtils.getAjax(_ctx + "menu/data/" + menuId, function(data) {
				vmData.data = data;
			});
		}
	},
	mounted : function() {
		
	}
});