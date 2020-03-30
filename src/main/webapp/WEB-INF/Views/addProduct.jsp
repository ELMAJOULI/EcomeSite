<%--
  Created by IntelliJ IDEA.
  User: ELMAJOULI
  Date: 3/29/2020
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>

<form action="addProduct.do" method="post">
    <table class="table table-responsive">
        <tr scope="row">
            <th>Product Name :</th>
            <td><input type="text" value="title" name="title"></td>
        </tr>
        <tr scope="row">
            <th>Product Image :</th>
            <td><input type="image" value="image" name="image"></td>
        </tr>
        <tr scope="row">
            <th>Product Description : </th>
            <td><input type="text" value="description" name="description"></td>
        </tr>
        <tr scope="row">
            <th>Product Price</th>
            <td><input type="number" value="price" name="price"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" class="btn btn-success" value="Add Product"></td>
        </tr>
    </table>
</form>
<%@include file="footer.jsp"%>
