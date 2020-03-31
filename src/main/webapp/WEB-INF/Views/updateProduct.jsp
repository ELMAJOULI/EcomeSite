<%--
  Created by IntelliJ IDEA.
  User: ELMAJOULI
  Date: 3/29/2020
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>

<form action="update.do" method="post">
    <table class="table table-responsive">
        <tr scope="row">
            <th>Product Name :</th>
            <td>
                <input type="hidden" value="${p.id}"  name="id">
                <input type="text" value="${p.title}" name="title">
            </td>
        </tr>
        <tr scope="row">
            <th>Product Image :</th>
            <td><input type="file" value="./img/product1.jpg" name="image"></td>
        </tr>
        <tr scope="row">
            <th>Product Description : </th>
            <td><input type="text" value="${p.description}" name="description"></td>
        </tr>
        <tr scope="row">
            <th>Product Price</th>
            <td><input type="number" value="${p.price}" name="price"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" class="btn btn-warning" value="Update Item"></td>
        </tr>
    </table>
</form>
<%@include file="footer.jsp"%>
