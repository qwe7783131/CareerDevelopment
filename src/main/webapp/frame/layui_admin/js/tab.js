/** kit_admin-v1.0.6 MIT License By http://kit/zhengjinfan.cn e-mail:zheng_jinfan@126.com */ ;
layui.define(["jquery", "element", "nprogress", "utils", "loader"], function(t) {
	var e = layui.jquery,
		i = layui.element,
		a = layui.utils,
		l = e(document),
		n = e(window),
		r = {
			page: "page",
			iframe: "iframe"
		},
		c = function() {
			this.config = {
				elem: void 0,
				mainUrl: document.getElementById('base').href + "/main.do",
				renderType: "iframe"
			}, this.v = "1.0.3"
		};
	(c.fn = c.prototype).set = function(t) {
		var i = this;
		return e.extend(!0, i.config, t), i
	}, c.fn.render = function() {
		var t = this,
			e = t.config;
		return void 0 === e.elem ? (layui.hint().error("Tab error:请配置选择卡容器."), t) : (o._config = e, o.createTabDom(), t)
	}, c.fn.tabAdd = function(t) {
		o.tabAdd(t)
	}, c.fn.close = function(t) {
		o.tabDelete(t)
	}, c.fn.getId = function() {
		return o.getCurrLayId()
	};
	var o = {
		_config: {},
		_filter: "kitTab",
		_title: void 0,
		_content: void 0,
		_parentElem: void 0,
		tabDomExists: function() {
			var t = this;
			return l.find("div.kit-tab").length > 0 && (t._title = e(".kit-tab ul.layui-tab-title"), t._content = e(".kit-tab div.layui-tab-content"), !0)
		},
		createTabDom: function() {
			var t = this,
				i = t._config;
			if(t._parentElem = i.elem, !t.tabDomExists()) {
				var a = ['<div class="layui-tab layui-tab-card kit-tab" lay-filter="' + t._filter + '">', '<ul class="layui-tab-title">', '<li class="layui-this" lay-id="-1" data-url="' + i.mainUrl + '"><i class="layui-icon">&#xe68e;</i> 控制面板</li>', "</ul>", '<div class="kit-tab-tool">操作&nbsp;<i class="fa fa-caret-down"></i></div>', '<div class="kit-tab-tool-body layui-anim layui-anim-upbit">', "<ul>", '<li class="kit-item" data-target="refresh">刷新当前选项卡</li>', '<li class="kit-line"></li>', '<li class="kit-item" data-target="closeCurrent">关闭当前选项卡</li>', '<li class="kit-item" data-target="closeOther">关闭其他选项卡</li>', '<li class="kit-line"></li>', '<li class="kit-item" data-target="closeAll">关闭所有选项卡</li>', "</ul>", "</div>", '<div class="layui-tab-content">', '<div class="layui-tab-item layui-show" lay-item-id="-1">{{content}}</div>', "</div>", "</div>"].join("");
				switch(i.renderType) {
					case r.page:
						a = a.replace("{{content}}", t.getBodyContent(i.mainUrl + "?v=" + (new Date).getTime()));
						break;
					case r.iframe:
						a = a.replace("{{content}}", '<iframe src="' + i.mainUrl + '"></iframe>')
				}
				e(i.elem).html(a), t._title = e(".kit-tab ul.layui-tab-title"), t._content = e(".kit-tab div.layui-tab-content");
				var l = e(".kit-tab-tool"),
					n = e(".kit-tab-tool-body");
				l.on("click", function() {
					n.toggle()
				}), n.find("li.kit-item").each(function() {
					var a = e(this),
						n = a.data("target");
					a.off("click").on("click", function() {
						var a = t._title.children("li[class=layui-this]").attr("lay-id");
						switch(n) {
							case "refresh":
								switch(i.renderType) {
									case r.page:
										var c = t.load(),
											o = t._title.children("li[lay-id=" + a + "]").data("url");
										t._content.children("div[lay-item-id=" + a + "]").html(t.getBodyContent(o + "?v=" + (new Date).getTime(), function() {
											t.closeLoad(c)
										}));
										break;
									case r.iframe:
										var s = t._content.children("div[lay-item-id=" + a + "]").children("iframe");
										s.attr("src", s.attr("src"))
								}
								break;
							case "closeCurrent":
								-1 != a && t.tabDelete(a);
								break;
							case "closeOther":
								t._title.children("li[lay-id]").each(function() {
									var i = e(this).attr("lay-id");
									i != a && -1 != i && t.tabDelete(i)
								});
								break;
							case "closeAll":
								t._title.children("li[lay-id]").each(function() {
									var i = e(this).attr("lay-id"); - 1 != i && t.tabDelete(i)
								})
						}
						l.click()
					})
				}), t.winResize()
			}
		},
		load: function() {
			return layer.load(0, {
				shade: [.3, "#333"]
			})
		},
		closeLoad: function(t) {
			setTimeout(function() {
				t && layer.close(t)
			}, 500)
		},
		getBodyContent: function(t, e) {
			return a.getBodyContent(a.loadHtml(t, e))
		},
		winResize: function() {
			var t = this,
				i = t._config;
			n.on("resize", function() {
				var a = e(t._parentElem).height();
				switch(i.renderType) {
					case r.page:
						e(".kit-tab .layui-tab-content").height(a - 45);
						break;
					case r.iframe:
						e(".kit-tab .layui-tab-content iframe").height(a - 45)
				}
			}).resize()
		},
		tabExists: function(t) {
			return this._title.find("li[lay-id=" + t + "]").length > 0
		},
		tabDelete: function(t) {
			i.tabDelete(this._filter, t)
		},
		tabChange: function(t) {
			i.tabChange(this._filter, t)
		},
		getTab: function(t) {
			return this._title.find("li[lay-id=" + t + "]")
		},
		tabAdd: function(t) {
			var e = this,
				a = e._config,
				l = (t = t || {
					id: (new Date).getTime(),
					title: "新标签页",
					icon: "fa-file",
					url: "404.html"
				}).title,
				n = t.icon,
				c = t.url,
				o = t.id;
			if(e.tabExists(o)) e.tabChange(o);
			else {
				NProgress.start();
				var s = e.load(),
					d = ['<li class="layui-this" lay-id="' + o + '" data-url="' + c + '">']; - 1 !== n.indexOf("fa-") ? d.push('<i class="fa ' + n + '" aria-hidden="true"></i>') : d.push('<i class="layui-icon">' + n + "</i>"), d.push("&nbsp;" + l), d.push('<i class="layui-icon layui-unselect layui-tab-close">&#x1006;</i>'), d.push("</li>");
				var u = '<div class="layui-tab-item layui-show" lay-item-id="' + o + '">{{content}}</div>';
				switch(a.renderType) {
					case r.page:
						u = u.replace("{{content}}", e.getBodyContent(c + "?v=" + (new Date).getTime(), function() {
							setTimeout(function() {
								NProgress.done(), e.closeLoad(s)
							}, 500)
						}));
						break;
					case r.iframe:
						u = u.replace("{{content}}", '<iframe src="' + c + '"></iframe>')
				}
				e._title.append(d.join("")), e._content.append(u), a.renderType === r.iframe && e._content.find("div[lay-item-id=" + o + "]").find("iframe").on("load", function() {
					NProgress.done(), e.closeLoad(s)
				}), e.getTab(o).find("i.layui-tab-close").off("click").on("click", function() {
					a.closeBefore ? a.closeBefore(t) && e.tabDelete(o) : e.tabDelete(o)
				}), e.tabChange(o), e.winResize(), a.onSwitch && i.on("tab(" + e._filter + ")", function(t) {
					a.onSwitch({
						index: t.index,
						elem: t.elem,
						layId: e._title.children("li").eq(t.index).attr("lay-id")
					})
				})
			}
		},
		getCurrLayId: function() {
			return this._title.find("li.layui-this").attr("lay-id")
		}
	};
	t("tab", new c)
});