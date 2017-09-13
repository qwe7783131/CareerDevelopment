/** kit_admin-v1.0.6 MIT License By http://kit/zhengjinfan.cn e-mail:zheng_jinfan@126.com */ ;
layui.define(["layer"], function(n) {
	var t = layui.jquery;
	layui.layer;
	n("utils", {
		getBodyContent: function(n) {
			var t = /<body[^>]*>([\s\S]*)<\/body>/.exec(n);
			return t && 2 === t.length ? t[1] : n
		},
		loadHtml: function(n, e) {
			var r;
			return t.ajax({
				url: n,
				async: !1,
				dataType: "html",
				error: function() {
					layui.hint().error("utils.loadHtml:发生错误了.")
				},
				success: function(n) {
					r = n, "function" == typeof e && e()
				}
			}), r
		}
	})
});