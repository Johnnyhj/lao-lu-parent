/**
 * version:1.0
 * name:ai.core.js
 * author:chen qiu ming
 * date:2015-3-26
 */

$.extend(String.prototype, {
    isPositiveInteger:function(){
        return (new RegExp(/^[1-9]\d*$/).test(this));
    },
    isInteger:function(){
        return (new RegExp(/^\d+$/).test(this));
    },
    isNumber: function(value, element) {
        return (new RegExp(/^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/).test(this));
    },
    trim:function(){
        return this.replace(/(^\s*)|(\s*$)|\r|\n/g, "");
    },
    startsWith:function (pattern){
        return this.indexOf(pattern) === 0;
    },
    endsWith:function(pattern) {
        var d = this.length - pattern.length;
        return d >= 0 && this.lastIndexOf(pattern) === d;
    },
    replaceSuffix:function(index){
        return this.replace(/\[[0-9]+\]/,'['+index+']').replace('#index#',index);
    },
    trans:function(){
        return this.replace(/&lt;/g, '<').replace(/&gt;/g,'>').replace(/&quot;/g, '"');
    },
    encodeTXT: function(){
        return (this).replaceAll('&', '&amp;').replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;");
    },
    replaceAll:function(os, ns){
        return this.replace(new RegExp(os,"gm"),ns);
    },
    replaceTm:function($data){
        if (!$data) return this;
        return this.replace(RegExp("({[A-Za-z_]+[A-Za-z0-9_]*})","g"), function($1){
            return $data[$1.replace(/[{}]+/g, "")];
        });
    },
    replaceTmById:function(_box){
        var $parent = _box || $(document);
        return this.replace(RegExp("({[A-Za-z_]+[A-Za-z0-9_]*})","g"), function($1){
            var $input = $parent.find("#"+$1.replace(/[{}]+/g, ""));
            return $input.val() ? $input.val() : $1;
        });
    },
    isFinishedTm:function(){
        return !(new RegExp("{[A-Za-z_]+[A-Za-z0-9_]*}").test(this));
    },
    skipChar:function(ch) {
        if (!this || this.length===0) {return '';}
        if (this.charAt(0)===ch) {return this.substring(1).skipChar(ch);}
        return this;
    },
    isValidPwd:function() {
        return (new RegExp(/^([_]|[a-zA-Z0-9]){6,32}$/).test(this));
    },
    isValidMail:function(){
        return(new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/).test(this.trim()));
    },
    isSpaces:function() {
        for(var i=0; i<this.length; i+=1) {
            var ch = this.charAt(i);
            if (ch!=' '&& ch!="\n" && ch!="\t" && ch!="\r") {return false;}
        }
        return true;
    },
    isPhone:function() {
        return (new RegExp(/(^([0-9]{3,4}[-])?\d{3,8}(-\d{1,6})?$)|(^\([0-9]{3,4}\)\d{3,8}(\(\d{1,6}\))?$)|(^\d{3,8}$)/).test(this));
    },
    isUrl:function(){
        return (new RegExp(/^[a-zA-z]+:\/\/([a-zA-Z0-9\-\.]+)([-\w .\/?%&=:]*)$/).test(this));
    },
    isExternalUrl:function(){
        return this.isUrl() && this.indexOf("://"+document.domain) == -1;
    }
});

$.fn.extend({
    /**
     * @param {Object} op: {type:GET/POST, url:ajax请求地址, data:ajax请求参数列表, callback:回调函数 }
     */
    ajaxUrl: function (op) {
        var $this = $(this);

        $this.trigger("pageClear");

        $.ajax({
            type: op.type || 'GET',
            url: op.url,
            data: op.data,
            cache: false,
            success: function (response) {
                var json = JSON.parse(response);
            },
            error: function(){

            },
            statusCode: {
                503: function (xhr, ajaxOptions, thrownError) {

                }
            }
        });
    },
    hoverClass: function(className, speed){
        var _className = className || "hover";
        return this.each(function(){
            var $this = $(this), mouseOutTimer;
            $this.hover(function(){
                if (mouseOutTimer) clearTimeout(mouseOutTimer);
                $this.addClass(_className);
            },function(){
                mouseOutTimer = setTimeout(function(){$this.removeClass(_className);}, speed||10);
            });
        });
    },
    initUI: function(){
        return this.each(function(){
            if($.isFunction(initUI)) initUI(this);
        });
    }
});

(function($){
    var menu, shadow, hash;
    $.fn.extend({
        contextMenu: function(id, options){
            var op = $.extend({
                    shadow : true,
                    bindings:{},
                    ctrSub:null
                }, options
            );

            if (!menu) {
                menu = $('<div id="contextmenu"></div>').appendTo('body').hide();
            }
            if (!shadow) {
                shadow = $('<div id="contextmenuShadow"></div>').appendTo('body').hide();
            }

            hash = hash || [];
            hash.push({
                id : id,
                shadow: op.shadow,
                bindings: op.bindings || {},
                ctrSub: op.ctrSub
            });

            var index = hash.length - 1;
            $(this).bind('contextmenu', function(e) {
                display(index, this, e, op);
                return false;
            });
            return this;
        }
    });

    function display(index, trigger, e, options) {
        var cur = hash[index];

        var content = $('<ul id="navTabCM"><li rel="reload">刷新标签页</li><li rel="closeCurrent">关闭标签页</li><li rel="closeOther">关闭其它标签页</li><li rel="closeAll">关闭全部标签页</li></ul>');
        content.find('li').hoverClass();

        // Send the content to the menu
        menu.html(content);

        $.each(cur.bindings, function(id, func) {
            $("[rel='"+id+"']", menu).bind('click', function(e) {
                hide();
                func($(trigger), $("#"+cur.id));
            });
        });

        var posX = e.pageX;
        var posY = e.pageY;
        if ($(window).width() < posX + menu.width()) posX -= menu.width();
        if ($(window).height() < posY + menu.height()) posY -= menu.height();

        menu.css({'left':posX,'top':posY}).show();
        if (cur.shadow) shadow.css({width:menu.width(),height:menu.height(),left:posX+3,top:posY+3}).show();
        $(document).one('click', hide);

        if ($.isFunction(cur.ctrSub)) {cur.ctrSub($(trigger), $("#"+cur.id));}
    }

    function hide() {
        menu.hide();
        shadow.hide();
    }
})(jQuery);

var navTab = {
    componentBox: null, // tab component. contain tabBox, prevBut, nextBut, panelBox
    _tabBox: null,
    _prevBut: null,
    _nextBut: null,
    _panelBox: null,
    _moreBut:null,
    _moreBox:null,
    _currentIndex: 0,

    _op: {id:"navTab", stTabBox:".navTab-tab", stPanelBox:".navTab-panel", mainTabId:"main", close$:"a.close", prevClass:"tabsLeft", nextClass:"tabsRight", stMore:".tabsMore", stMoreLi:"ul.tabsMoreList"},

    init: function(options){
        //if ($.History) $.History.init("#container");
        var $this = this;
        $.extend(this._op, options);

        this.componentBox = $("#"+this._op.id);
        this._tabBox = this.componentBox.find(this._op.stTabBox);
        this._panelBox = this.componentBox.find(this._op.stPanelBox);
        this._prevBut = this.componentBox.find("."+this._op.prevClass);
        this._nextBut = this.componentBox.find("."+this._op.nextClass);
        this._moreBut = this.componentBox.find(this._op.stMore);
        this._moreBox = this.componentBox.find(this._op.stMoreLi);

        this._prevBut.click(function(event) {$this._scrollPrev()});
        this._nextBut.click(function(event) {$this._scrollNext()});
        this._moreBut.click(function(){
            $this._moreBox.show();
            return false;
        });
        $(document).click(function(){$this._moreBox.hide()});

        this._contextmenu(this._tabBox);
        this._contextmenu(this._getTabs());

        this._init();
        this._ctrlScrollBut();
    },
    _init: function(){
        var $this = this;
        this._getTabs().each(function(iTabIndex){
            $(this).unbind("click").click(function(event){
                $this._switchTab(iTabIndex);
            });
            $(this).find(navTab._op.close$).unbind("click").click(function(){
                $this._closeTab(iTabIndex);
            });
        });
        this._getMoreLi().each(function(iTabIndex){
            $(this).find(">a").unbind("click").click(function(event){
                $this._switchTab(iTabIndex);
            });
        });

        this._switchTab(this._currentIndex);
    },
    _contextmenu:function($obj){ // navTab右键菜单
        var $this = this;
        $obj.contextMenu('navTabCM', {
            bindings:{
                reload:function(t,m){
                    $this._reload(t, true);
                },
                closeCurrent:function(t,m){
                    var tabId = t.attr("tabid");
                    if (tabId) $this.closeTab(tabId);
                    else $this.closeCurrentTab();
                },
                closeOther:function(t,m){
                    var index = $this._indexTabId(t.attr("tabid"));
                    $this._closeOtherTab(index > 0 ? index : $this._currentIndex);
                },
                closeAll:function(t,m){
                    $this.closeAllTab();
                }
            },
            ctrSub:function(t,m){
                var mReload = m.find("[rel='reload']");
                var mCur = m.find("[rel='closeCurrent']");
                var mOther = m.find("[rel='closeOther']");
                var mAll = m.find("[rel='closeAll']");
                var $tabLi = $this._getTabs();
                if ($tabLi.size() < 2) {
                    mCur.addClass("disabled");
                    mOther.addClass("disabled");
                    mAll.addClass("disabled");
                }
                if ($this._currentIndex == 0 || t.attr("tabid") == $this._op.mainTabId) {
                    mCur.addClass("disabled");
                    mReload.addClass("disabled");
                } else if ($tabLi.size() == 2) {
                    mOther.addClass("disabled");
                }
            }
        });
    },

    _getTabs: function(){
        return this._tabBox.find("> li");
    },
    _getPanels: function(){
        return this._panelBox.find("> div");
    },
    _getMoreLi: function(){
        return this._moreBox.find("> li");
    },
    _getTab: function(tabid){
        var index = this._indexTabId(tabid);
        if (index >= 0) return this._getTabs().eq(index);
    },
    getPanel: function(tabid){
        var index = this._indexTabId(tabid);
        if (index >= 0) return this._getPanels().eq(index);
    },
    _getTabsW: function(iStart, iEnd){
        return this._tabsW(this._getTabs().slice(iStart, iEnd));
    },
    _tabsW:function($tabs){
        var iW = 0;
        $tabs.each(function(){
            iW += $(this).outerWidth(true);
        });
        return iW;
    },
    _indexTabId: function(tabid){
        if (!tabid) return -1;
        var iOpenIndex = -1;
        this._getTabs().each(function(index){
            if ($(this).attr("tabid") == tabid){iOpenIndex = index; }
        });
        return iOpenIndex;
    },
    _getLeft: function(){
        return this._tabBox.position().left;
    },
    _getScrollBarW: function(){
        return this.componentBox.width()-98;
    },

    _visibleStart: function(){
        var iLeft = this._getLeft(), iW = 0;
        var $tabs = this._getTabs();
        for (var i=0; i<$tabs.size(); i++){
            if (iW + iLeft >= 0) return i;
            iW += $tabs.eq(i).outerWidth(true);
        }
        return 0;
    },
    _visibleEnd: function(){
        var iLeft = this._getLeft(), iW = 0;
        var $tabs = this._getTabs();
        for (var i=0; i<$tabs.size(); i++){
            iW += $tabs.eq(i).outerWidth(true);
            if (iW + iLeft > this._getScrollBarW()) return i;
        }
        return $tabs.size();
    },
    _scrollPrev: function(){
        var iStart = this._visibleStart();
        if (iStart > 0){
            this._scrollTab(-this._getTabsW(0, iStart-1));
        }
    },
    _scrollNext: function(){
        var iEnd = this._visibleEnd();
        if (iEnd < this._getTabs().size()){
            this._scrollTab(-this._getTabsW(0, iEnd+1) + this._getScrollBarW());
        }
    },
    _scrollTab: function(iLeft, isNext){
        var $this = this;
        this._tabBox.animate({ left: iLeft+'px' }, 200, function(){$this._ctrlScrollBut();});
    },
    _scrollCurrent: function(){ // auto scroll current tab
        var iW = this._tabsW(this._getTabs());
        if (iW <= this._getScrollBarW()){
            this._scrollTab(0);
        } else if (this._getLeft() < this._getScrollBarW() - iW){
            this._scrollTab(this._getScrollBarW()-iW);
        } else if (this._currentIndex < this._visibleStart()) {
            this._scrollTab(-this._getTabsW(0, this._currentIndex));
        } else if (this._currentIndex >= this._visibleEnd()) {
            this._scrollTab(this._getScrollBarW() - this._getTabs().eq(this._currentIndex).outerWidth(true) - this._getTabsW(0, this._currentIndex));
        }
    },
    _ctrlScrollBut: function(){
        var iW = this._tabsW(this._getTabs());
        if (this._getScrollBarW() > iW){
            this._prevBut.hide();
            this._nextBut.hide();
            this._tabBox.parent().removeClass("tabsPageHeaderMargin");
        } else {
            this._prevBut.show().removeClass("tabsLeftDisabled");
            this._nextBut.show().removeClass("tabsRightDisabled");
            this._tabBox.parent().addClass("tabsPageHeaderMargin");
            if (this._getLeft() >= 0){
                this._prevBut.addClass("tabsLeftDisabled");
            } else if (this._getLeft() <= this._getScrollBarW() - iW) {
                this._nextBut.addClass("tabsRightDisabled");
            }
        }
    },

    _switchTab: function(iTabIndex){
        var $tab = this._getTabs().removeClass("selected").eq(iTabIndex).addClass("selected");
        this._getPanels().hide().eq(iTabIndex).show();

        this._getMoreLi().removeClass("selected").eq(iTabIndex).addClass("selected");
        this._currentIndex = iTabIndex;

        this._scrollCurrent();
        this._reload($tab);
    },

    _closeTab: function(index, openTabid){

        this._getTabs().eq(index).remove();
        this._getPanels().eq(index).trigger("pageClear").remove();
        this._getMoreLi().eq(index).remove();
        if (this._currentIndex >= index) this._currentIndex--;

        if (openTabid) {
            var openIndex = this._indexTabId(openTabid);
            if (openIndex > 0) this._currentIndex = openIndex;
        }

        this._init();
        this._scrollCurrent();
        this._reload(this._getTabs().eq(this._currentIndex));
    },
    closeTab: function(tabid){
        var index = this._indexTabId(tabid);
        if (index > 0) { this._closeTab(index); }
    },
    closeCurrentTab: function(openTabid){ //openTabid 可以为空，默认关闭当前tab后，打开最后一个tab
        if (this._currentIndex > 0) {this._closeTab(this._currentIndex, openTabid);}
    },
    closeAllTab: function(){
        this._getTabs().filter(":gt(0)").remove();
        this._getPanels().filter(":gt(0)").trigger("pageClear").remove();
        this._getMoreLi().filter(":gt(0)").remove();
        this._currentIndex = 0;
        this._init();
        this._scrollCurrent();
    },
    _closeOtherTab: function(index){
        index = index || this._currentIndex;
        if (index > 0) {
            var str$ = ":eq("+index+")";
            this._getTabs().not(str$).filter(":gt(0)").remove();
            this._getPanels().not(str$).filter(":gt(0)").trigger("pageClear").remove();
            this._getMoreLi().not(str$).filter(":gt(0)").remove();
            this._currentIndex = 1;
            this._init();
            this._scrollCurrent();
        } else {
            this.closeAllTab();
        }
    },

    _loadUrlCallback: function($panel){
        $panel.find("[layoutH]").layoutH();
        $panel.find(":button.close").click(function(){
            navTab.closeCurrentTab();
        });
    },
    _reload: function($tab, flag){
        flag = flag || $tab.data("reloadFlag");
        var url = $tab.attr("url");
        if (flag && url) {
            $tab.data("reloadFlag", null);
            var $panel = this.getPanel($tab.attr("tabid"));

            if ($tab.hasClass("external")){
                navTab.openExternal(url, $panel);
                console.log(33333333);
            }else {
                //获取pagerForm参数
                var $pagerForm = $("#pagerForm", $panel);
                var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {};

                $panel.loadUrl(url, args, function(){navTab._loadUrlCallback($panel);});
            }
        }
    },
    reloadFlag: function(tabid){
        var $tab = this._getTab(tabid);
        if ($tab){
            if (this._indexTabId(tabid) == this._currentIndex) this._reload($tab, true);
            else $tab.data("reloadFlag", 1);
        }
    },
    reload: function(url, options){
        var op = $.extend({data:{}, navTabId:"", callback:null}, options);
        var $tab = op.navTabId ? this._getTab(op.navTabId) : this._getTabs().eq(this._currentIndex);
        var $panel =  op.navTabId ? this.getPanel(op.navTabId) : this._getPanels().eq(this._currentIndex);

        if ($panel){
            if (!url) {
                url = $tab.attr("url");
            }
            if (url) {
                if ($tab.hasClass("external")) {
                    navTab.openExternal(url, $panel);
                    console.log(44444444444);
                } else {
                    if ($.isEmptyObject(op.data)) { //获取pagerForm参数
                        var $pagerForm = $("#pagerForm", $panel);
                        op.data = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
                    }

                    $panel.ajaxUrl({
                        type:"POST", url:url, data:op.data, callback:function(response){
                            navTab._loadUrlCallback($panel);
                            if ($.isFunction(op.callback)) op.callback(response);
                        }
                    });
                }
            }
        }
    },
    getCurrentPanel: function() {
        return this._getPanels().eq(this._currentIndex);
    },
    openExternal:function(url, $panel){
        var ih = navTab._panelBox.height() - 41; // 计算iframe高度
        $panel.html('<iframe src="'+url+'" frameborder="0" width="100%" height="100%"></iframe>');// 生成iframe
    },
    /**
     *
     * @param {Object} tabid
     * @param {Object} url
     * @param {Object} params: title, data, fresh
     */
    openTab: function(tabid, url, options){ //if found tabid replace tab, else create a new tab.
        var op = $.extend({title:"New Tab", type:"GET", data:{}, fresh:true, external:false}, options);

        var iOpenIndex = this._indexTabId(tabid);

        if (iOpenIndex >= 0){
            var $tab = this._getTabs().eq(iOpenIndex);
            var span$ = $tab.attr("tabid") == this._op.mainTabId ? "> span > span" : "> span";
            $tab.find(">a").attr("title", op.title).find(span$).html(op.title);
            var $panel = this._getPanels().eq(iOpenIndex);
			console.log($panel);
            if(op.fresh || $tab.attr("url") != url) {
                $tab.attr("url", url);
                if (op.external || url.isExternalUrl()) {
                    $tab.addClass("external");
                    navTab.openExternal(url, $panel);
                    console.log(1111111);
                } else {
                    $tab.removeClass("external");
                    $panel.ajaxUrl({
                        type:op.type, url:url, data:op.data, callback:function(){
                            navTab._loadUrlCallback($panel);
                        }
                    });
                }
            }
            this._currentIndex = iOpenIndex;
        } else {
            var tabFrag = '<li tabid="#tabid#"><a href="javascript:" title="#title#" class="#tabid#"><span>#title#</span></a><a href="javascript:;" class="close"><i class="fa fa-times-circle"></i></a></li>';
            this._tabBox.append(tabFrag.replaceAll("#tabid#", tabid).replaceAll("#title#", op.title));
            this._panelBox.append('<div class="page unitBox"></div>');
            this._moreBox.append('<li><a href="javascript:" title="#title#">#title#</a></li>'.replaceAll("#title#", op.title));

            var $tabs = this._getTabs();
            var $tab = $tabs.filter(":last");
            var $panel = this._getPanels().filter(":last");

            if (op.external || url.isExternalUrl()) {
                $tab.addClass("external");
                navTab.openExternal(url, $panel);
                console.log(2222222222);
            } else {
                $tab.removeClass("external");
                $panel.ajaxUrl({
                    type:op.type, url:url, data:op.data, callback:function(){
                        navTab._loadUrlCallback($panel);
                    }
                });
            }

            /*if ($.History) {
             setTimeout(function(){
             $.History.addHistory(tabid, function(tabid){
             var i = navTab._indexTabId(tabid);
             if (i >= 0) navTab._switchTab(i);
             }, tabid);
             }, 10);
             }*/

            this._currentIndex = $tabs.size() - 1;
            this._contextmenu($tabs.filter(":last").hoverClass("hover"));
        }

        this._init();
        this._scrollCurrent();

        this._getTabs().eq(this._currentIndex).attr("url", url);
    }
};

var AI = window.AI || {};

// 全局变量

AI.getWinWidth = function(){
    return $(window).width();
};

AI.getWinHeight = function(){
    return $(window).height();
};

AI.getMainHeight = function(){
    return AI.getWinHeight() - 86;
};

// 框架初始化

AI.init = function(){
    // 计算右侧主体部分高度
    $(".tabsPageContent").css({
        "height":AI.getMainHeight() + "px"
    });
    $(window).resize(function(){
        $(".tabsPageContent").css({
            "height":AI.getMainHeight() + "px"
        })
    });
    AI.initNavTab();
    $("a[target=navTab]").each(function(){
        $(this).click(function(event){
            var $this = $(this);
            var title = $this.attr("title") || $this.text();
            var tabid = $this.attr("rel") || "_blank";
            var fresh = eval($this.attr("fresh") || "true");
            var external = eval($this.attr("external") || "false");
            var url = unescape($this.attr("href")).replaceTmById($(event.target).parents(".unitBox:first"));
            console.log(tabid + "," + url + "," + title + "," +fresh + "," + external);
            AI.openNavTab({
                tabid:tabid,
                url:url,
                property:{
                    title:title,
                    fresh:fresh,
                    external:external
                }
            });
            console.log("=======================");
            event.preventDefault();
            event.stopPropagation();
        });
    });
};

AI.initNavTab = function(){
    navTab.init();
};

AI.openNavTab = function(options){
    navTab.openTab(options.tabid,options.url,options.property);
};

AI.resize = function(){
    AI.windowX = $(window).width();
    AI.windowY = $(window).height();
    AI.topY = AI.windowY - 45;
};

AI.init();