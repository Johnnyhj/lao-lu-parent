var ailk;
if(!ailk) ailk = {};
if(!ailk.form) ailk.form = {};
ailk.isIE = !!window.ActiveXObject;
(function(_win){
	var _config;
	var _this;
	var match; // 文件类型是否匹配
	function UploadFormPanel(config){
		// 上传输入框数组
		this.fileBtns = [];
		// 删除按钮数组
		this.delBtns = [];
		// 上传控件
		this.uploadComponents = [];
		
		// ID,如果用户没有指定ID，则随机生成一个ID
		this.id = config.id || '';
		// 上传类型: single,单个文件上传; multiple,多个文件上传
		this.uploadType = config.uploadType || 'single';
		// 上传文件的类型: 可上传的文件的后缀，以逗号分隔的字符串, 如：doc,txt
		this.fileType = config.fileType || '';
		// url链接, 即form表单中action的值
		this.url = config.url || '';
		// 上传的文件名，后台根据此文件名参数获取文件
		this.fileName = config.fileName || '';
		// form表单的提交方式
		this.submitMethod = config.submitMethod || 'POST';
		// 一次最多可以上传的文件个数，仅当uploadType=multiple时有效
		this.maxCount = config.maxCount || 10;
		// 表单ID
		this.formId = config.formId || "uploadForm_" + new Date().getTime() + "_" + (Math.floor(Math.random() * 1000));
		// 返回成功的回调函数
		this.success = config.success || function(){};
		// 是否需要上传按钮
		this.uploadButton = config.uploadButton || false;
		
		// UploadFormPanel对象
		_this = this;
		// 保存用户初始配置
		_config = config;
		
		initComponent();
	}
	
	// 初始化控件
	function initComponent(){
		// form表单
		initForm();
		// 上传控件
		initFileComponent();
		// 上传按钮
		if(_this.uploadButton){
			initUploadBtn();
		}
		
		if(_this.uploadType == 'multiple'){
			// 新增按钮
			initAddBtn();
		}
		
		var uploadForm = _this.uploadForm;
		if(_this.uploadType == 'multiple'){
			// 添加新增按钮
			uploadForm.appendChild(_this.addBtn);
		}
		if(_this.uploadButton){
			// 添加上传按钮
			uploadForm.appendChild(_this.uploadBtn);
		}
		
		uploadForm.appendChild(_this.uploadComponents[0]);
		
		_this.uploadFormPanel = uploadForm;
	}
	
	// 初始化form表单
	function initForm(){
		var uploadForm;

			uploadForm = document.createElement("form");
			uploadForm.method = _this.submitMethod;
			uploadForm.enctype = "multipart/form-data";
			uploadForm.id = _this.formId;
			uploadForm.action = _this.url;

		
		_this.uploadForm = uploadForm;
	}
	
	// 初始化上传控件，包括一个上传输入框, 如果是上传多个文件的话，还包括一个删除按钮
	function initFileComponent(){
		var nLen = _this.fileBtns.length;
		var uploadDiv;

			uploadDiv = document.createElement("div");
			uploadDiv.id = _this.formId + "_uploadDiv_" + nLen;

		
		initFileBtn();
		initDelBtn();
		
		// 添加一个上传输入框
		uploadDiv.appendChild(_this.fileBtns[_this.fileBtns.length - 1]);
		
		if(_this.uploadType == 'multiple'){
			// 添加一个删除按钮
			uploadDiv.appendChild(_this.delBtns[_this.delBtns.length - 1]);
		}
		
		_this.uploadComponents[nLen] = uploadDiv;
	}
	
	// 初始化上传输入框, 添加一个上传输入框
	function initFileBtn(){
		// 上传输入框的最大索引
		var index = _this.fileBtns.length;
		
		var fileBtn;

			fileBtn = document.createElement("input");
			fileBtn.id = _this.formId + "_fileBtn_" + index;
			fileBtn.type = "file";
			fileBtn.name = _this.fileName;
			fileBtn.contentEditable = false;

		
		// 上传文件之后鼠标离开输入框的事件
		fileBtn.onblur = function(){
			var v = fileBtn.value || '';
			var suffix = v.substring(v.lastIndexOf(".") + 1);
			if(!_this.fileType){
				match = true;
			}else if(_this.fileType.toLowerCase().indexOf(suffix.toLowerCase()) < 0){
				// 查看上传文件类型是否合法
				match = false;
			}else{
				match = true;
			}
		};
		
		_this.fileBtns[_this.fileBtns.length] = fileBtn;
	}
	
	// 初始化删除按钮
	function initDelBtn(){
		// 上传输入框的最大索引
		var index = _this.delBtns.length;
		var delBtn;

			delBtn = document.createElement('input');
			delBtn.id = _this.formId + "_delBtn_" + index;
			delBtn.type = "button";
			delBtn.style.width = "65px";
			delBtn.value = "删除";
			delBtn.style.marginLeft = "20px";

		
		delBtn.onclick = function(){
			delBtnClick(index);
		};
		
		_this.delBtns[index] = delBtn;
	}
	
	// 初始化上传按钮
	function initUploadBtn(){
		var uploadBtn;
		
		if($.browser.msie && parseInt($.browser.version,10) < 10){
			uploadBtn = document.createElement("<input type='button' style='width: 65px; margin-right: 20px;' value='上传'/>");
		}else{
			uploadBtn = document.createElement("input");
			uploadBtn.type = "button";
			uploadBtn.style.width = "65px";
			uploadBtn.style.marginRight = "20px";
			uploadBtn.value = "上传";
		}
		
		uploadBtn.onclick = uploadBtnClick;
		
		_this.uploadBtn = uploadBtn;
	}
	
	// 初始化"新增"按钮
	function initAddBtn(){
		var addBtn;
		
		if($.browser.msie && parseInt($.browser.version,10) < 10){
			addBtn = document.createElement("<input type='button' style='width: 65px; margin-right: 20px;' value='新增'/>");
		}else{
			addBtn = document.createElement('input');
			addBtn.type = "button";
			addBtn.style.width = "65px";
			addBtn.value = "新增";
			addBtn.style.marginRight = "20px";
		}
		
		addBtn.onclick = addBtnClick;
		
		_this.addBtn = addBtn;		
	}
	
	// 点击"上传"
	function uploadBtnClick(){
		if(!validate()){
			return;
		}	
		_this.submit();
	}
	
	// 检查合法性
	function validate(){
		var _exists = false;
		// 只要有一个上传输入框有值就可以进行上传
		for(var i = 0; i < _this.fileBtns.length; i++){
			if(_this.fileBtns[i].value){
				$(_this.fileBtns[i]).trigger("blur");
				_exists = true;
				break;
			}
		}
		
		if(match == 'undefined' || !_exists){
			alert("请选择文件之后再点击上传");
			return false;
		}
		
		if(!match){
			alert("上传的文件类型不匹配，只能为\'" + _this.fileType + "\'类型的文件");
			return false;
		}
		
		return true;
	}
	
	// 点击删除
	function delBtnClick(index){
		if($('#' + _this.formId + '_uploadDiv_' + index)){
			$('#' + _this.formId + '_uploadDiv_' + index).remove();
		}
	}
	
	// 点击"新增"
	function addBtnClick(){
		// 当前页面中上传控件的个数
		var count = $('div[id^=' + _this.formId + '_uploadDiv]').size();
		
		if(count >= _this.maxCount){
			alert("每次最多只能上传" + _this.maxCount + "个文件");
			return;
		}
		
		initFileComponent();
		
		// 添加一个上传控件
		_this.uploadFormPanel.appendChild(_this.uploadComponents[_this.uploadComponents.length - 1]);
	}
	
	// 提交表单
	UploadFormPanel.prototype.submit = function(){
		if(this.url == '' || this.fileName == ''){
			return;
		}
		
		var form = $(this.uploadFormPanel);
		var options  = {
			url : _this.url,  
			type : 'post',  
			success : function(data){
				_this.success(data);
			}  
		};  
		form.ajaxSubmit(options); 
		
		// this.uploadFormPanel.submit();
	};
	
	// 映射
	UploadFormPanel.prototype.renderTo = function(id){
		if(!id) return;
		var el = document.getElementById(id);
		if(!el) return;
		
		el.appendChild(this.uploadFormPanel);
	};
	
	// 检查合法性
	UploadFormPanel.prototype.validate = function(){
		return validate();
	};
	
	var ns = ailk.form;
	ns.UploadFormPanel = UploadFormPanel;
})(window);