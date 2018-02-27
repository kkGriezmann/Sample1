
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.dto.GoodsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   String cart = (String)request.getAttribute("cart");
   if(cart != null){
%>    
   <script>
     alert('<%=cart %>');
   </script>
<%
   }//end if
%>    
    
<%
  GoodsDTO dto = (GoodsDTO)request.getAttribute("goodsRetrieve");

String gCode = dto.getgCode();
String gCategory = dto.getgCategory();
String gName = dto.getgName();
String gContent = dto.getgContent();
int gPrice = dto.getgPrice();
String gImage = dto.getgImage();
  NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.KOREA);
  String gPrice2 = nf.format(gPrice);
 %> 
<script>
  function reqCheck(a,f){
	  if(a == 'cart'){
		  f.action="CartAddServlet";
	  }else{
		  f.action="OrderAddServlet";
	  }
  }
</script>
<FORM name="goodRetrieveForm" method="GET" action="#">
	    <input type="hidden" name="gImage" value="<%= gImage%>"> <input
		type="hidden" name="gCode" value="<%= gCode%>"> <input
		type="hidden" name="gName" value="<%= gName%>"> <input
		type="hidden" name="gPrice" value="<%= gPrice %>">

	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
		</tr>
		<tr>
			<td>
				<table align="center" width="710" cellspacing="0" cellpadding="0"
					border="0" style='margin-left: 30px'>
					<tr>
						<td class="td_default"><font size="5"><b>- 상품 정보 -</b></font>
							&nbsp;</td>
					</tr>
					<tr>
						<td height="5"></td>
					</tr>
					<tr>
						<td height="1" colspan="8" bgcolor="CECECE"></td>
					</tr>
					<tr>
						<td height="10"></td>
					</tr>

					<tr>
						<td rowspan="7"><img src="images/items/<%=gImage %>.gif"
							border="0" align="center" width="300" /></td>
						<td class="td_title">제품코드</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>
						<%= gCode %>
						</td>
					</tr>
					<tr>
						<td class="td_title">상품명</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'><%= gName %></td>
					</tr>
					<tr>
						<td class="td_title">가격</td>

						<td class="td_red" colspan="2" style='padding-left: 30px'>
						<%= gPrice2 %>
						</td>
					</tr>
					<tr>
						<td class="td_title">배송비</td>
						<td colspan="2"><font color="#2e56a9" size="2"
							style='padding-left: 30px'><b> 무료배송</b> </font> <font size="2">(도서
								산간지역 별도 배송비 추가)</font></td>
					</tr>
					<tr>
						<td class="td_title" rowspan="2">상품옵션</td>
						<td colspan="2" style='padding-left: 30px'>
						<select class="select_change" size="1" 
						name="goodsSize" id="GOODS_SIZE">
								<option selected value="사이즈선택">사이즈선택</option>
								<option value="L">L</option>
								<option value="M">M</option>
								<option value="S">S</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2" style='padding-left: 30px'>
						<select class="select_change" size="1" 
						name="goodsColor"
							id="GOODS_COLOR">
								<option selected value="색상선택">색상선택</option>
								<option value="navy">navy</option>
								<option value="black">black</option>
								<option value="ivory">ivory</option>
								<option value="white">white</option>
								<option value="gray">gray</option>
						</select></td>
					</tr>

					<tr>
						<td class="td_title">주문수량</td>
						<td style="padding-left: 30px">
						<input type="text"
							name="goodsAmount" value="1" id="GOODS_AMOUNT"
							style="text-align: right; height: 18px"> 
							<script type="text/javascript">
							  function upDown(k){
								  var amount = document.querySelector("#GOODS_AMOUNT").value;
								  var amount2 = parseInt(amount);
								  if(k =='+'){
									  amount2++;
								  }else{
									  
									  amount2--;
									  if(amount2==0)amount2=1;
								  }
								  document.querySelector("#GOODS_AMOUNT").value=amount2;
							  }
							</script>
							<img src="images/items/up.PNG" id="up" onclick="upDown('+')"> 
							<img src="images/items/down.PNG" id="down" onclick="upDown('-')"></td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

	<br> <button onclick="reqCheck('order',goodRetrieveForm)">구매</button>
	&nbsp;&nbsp;
	<button onclick="reqCheck('cart',goodRetrieveForm)">장바구니</button>
</FORM>
