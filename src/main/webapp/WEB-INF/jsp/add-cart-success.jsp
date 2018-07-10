<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" async="" src="/js/wl.js"></script>
<meta http-equiv="Cache-Control" content="max-age=300" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<link rel="stylesheet" type="text/css" href="/css/album.css">
<title>商品已成功加入购物车</title>
<!-- <script async="" src="/js/gtm.js"></script>
<script type="text/javascript">
	window.pageConfig = {
		compatible : true
	};
</script> -->
<meta name="Keywords" content="java,淘淘java" />
<meta name="description"
	content="在淘淘中找到了29910件java的类似商品，其中包含了“图书”，“电子书”，“教育音像”，“骑行运动”等类型的java的商品。" />
<link rel="stylesheet" type="text/css" href="/css/base.css" media="all" />
<link rel="stylesheet" type="text/css" href="/css/psearch20131008.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="/css/psearch.onebox.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="/css/pop_compare.css"
	media="all" />
<script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
<link rel="stylesheet" type="text/css" href="/css/share-rec.css">
</head>
<body>
	<script type="text/javascript" src="/js/base-2011.js" charset="utf-8"></script>
	<!-- header start -->
	<jsp:include page="commons/header.jsp" />
	<!-- header end -->
	<script type="text/javascript">
		var dataLayer = null;

		//********过渡页切新版推荐-start***************
		function getParam(paramName) {
			var paramValue = "";
			isFound = false;
			if (this.location.search.indexOf("?") == 0
					&& this.location.search.indexOf("=") > 1) {
				arrSource = unescape(this.location.search).substring(1,
						this.location.search.length).split("&");
				i = 0;
				while (i < arrSource.length && !isFound) {
					if (arrSource[i].indexOf("=") > 0) {
						if (arrSource[i].split("=")[0].toLowerCase() == paramName
								.toLowerCase()) {
							paramValue = arrSource[i].split("=")[1];
							isFound = true;
						}
					}
					i++;
				}
			}
			return paramValue;
		}
		try {
			var heads = document.getElementsByTagName("head");
			var link = document.createElement("link");
			link.setAttribute("rel", "stylesheet");
			link.setAttribute("type", "text/css");
			link
					.setAttribute("href",
							"//misc.360buyimg.com/user/cart/widget/??addtocart-201608/addtocart-201608.css");
			heads[0].appendChild(link);
		} catch (e) {
		}
		//********过渡页切新版推荐-end***************
	</script>
	<noscript>
		<iframe src="//www.googletagmanager.com/ns.html?id=GTM-T947SH"
			height="0" width="0" style="display: none; visibility: hidden"></iframe>
	</noscript>
	<script>
		(function(w, d, s, l, i) {
			w[l] = w[l] || [];
			w[l].push({
				'gtm.start' : new Date().getTime(),
				event : 'gtm.js'
			});
			var f = d.getElementsByTagName(s)[0], j = d.createElement(s), dl = l != 'dataLayer' ? '&l='
					+ l
					: '';
			j.async = true;
			j.src = '//www.googletagmanager.com/gtm.js?id=' + i + dl;
			f.parentNode.insertBefore(j, f);
		})(window, document, 'script', 'dataLayer', 'GTM-T947SH');
	</script>
	<!--shortcut start-->
	<jsp:include page="commons/shortcut.jsp" />
	<!--shortcut end-->
	<!--nav start-->

	<!--nav end-->
	<div class="main">
		<div class="success-wrap">
			<div class="w" id="result">
				<div class="m succeed-box">
					<div class="mc success-cont">
						<div class="success-lcol">
							<div class="success-top">
								<b class="succ-icon"></b>
								<h3 class="ftx-02">商品已成功加入购物车！</h3>
							</div>
							<div class="p-item">
								<div class="p-img">
									<a href="https://item.jd.com/26757981596.html" target="_blank"><img
										src="./商品已成功加入购物车_files/5ae170c3N5ae2335f.jpg"
										clstag="pageclick|keycount|201601152|11"></a>
								</div>
								<div class="p-info">
									<div class="p-name">
										<a href="https://item.jd.com/26757981596.html" target="_blank"
											clstag="pageclick|keycount|201601152|2"
											title="羽芯 RL-N1骨传导运动眼镜耳机蓝牙骨传感带蓝牙耳机的太阳眼镜 眼镜耳机 骨传导黑科技">羽芯
											RL-N1骨传导运动眼镜耳机蓝牙骨传感带蓝牙耳机的太阳眼镜 眼镜耳机 骨传导黑科技</a>
									</div>
									<div class="p-extra">
										<span class="txt"> 数量：1</span>
									</div>
								</div>
								<div class="clr"></div>
							</div>
						</div>
						<div class="success-btns success-btns-new">
							<div class="success-ad">
								<a
									href="https://cart.jd.com/addToCart.html?rcd=1&amp;pid=26757981596&amp;pc=1&amp;eb=1&amp;rid=1531186283971&amp;em=#none"></a>
							</div>
							<div class="clr"></div>
							<div>
								<a class="btn-tobback"
									href="http://localhost:8082/item/153093600899467" target="_blank"
									clstag="pageclick|keycount|201601152|3">查看商品详情</a><a
									class="btn-addtocart"
									href="http://localhost:8082/cart/cart.html"
									id="GotoShoppingCart" clstag="pageclick|keycount|201601152|4"><b></b>去购物车结算</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!--service start-->

	<!--service end-->
	<!-- footer start -->
	<jsp:include page="commons/footer.jsp" />
	<!-- footer end -->
	<script type="text/javascript" src="/js/jquery.hashchange.js"></script>
	<script type="text/javascript" src="/js/search_main.js"></script>
	<script type="text/javascript">
		<script type="text/javascript" src="/js/config.js">
	</script>
	<script type="text/javascript" src="/js/initCartNew.js"></script>
	<script type="text/javascript">
		seajs.use([ "jdf/1.0.0/unit/globalInit/5.0.0/globalInit.js",
				'jdf/1.0.0/ui/switchable/1.0.0/switchable' ], function(
				globalInit) {
			globalInit();
			$('#similar, #promotion').switchable({
				type : 'focus',
				navItem : 's-item',
				navSelectedClass : 'curr',
				contentClass : 's-panel-main',//主体 
				mainClass : 's-panel',
				prevClass : 's-prev',
				nextClass : 's-next',
				hasPage : true,
				autoPlay : false
			});
			$('.goods-list .item').hover(function() {
				$(this).addClass('hover');
			}, function() {
				$(this).removeClass('hover');
			})
			$('#similar, #promotion').hover(function() {
				$('.s-page', $(this)).show();
			}, function() {
				$('.s-page', $(this)).hide();
			})
		});
	</script>
	<script type="text/javascript">
		(function() {
			var ja = document.createElement('script');
			ja.type = 'text/javascript';
			ja.async = true;
			ja.src = '//wl.jd.com/wl.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ja, s);
		})();
	</script>

	<script src="/js/td.js"></script>
</body>
</html>