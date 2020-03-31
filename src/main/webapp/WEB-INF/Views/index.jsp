<%--
  Created by IntelliJ IDEA.
  User: ELMAJOULI
  Date: 3/28/2020
  Time: 1:57 AM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="head.jsp"%>

        <table class="table table-hover table-responsive">
            <thead>
                <tr scope="row">
                    <th>Product picture</th>
                    <th>Product name</th>
                    <th>Product description</th>
                    <th>Product price</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>

            <c:forEach items="${products}" var="p">
                <tr scope="row">
                    <td><img src="" alt=""></td>
                    <td>${p.title}</td>
                    <td>${p.description}</td>
                    <td>${p.price}</td>
                    <td><a href="remove.do?id=${p.id}" class="btn btn-success">Drop Product</a></td>
                    <td><a href="update.do?id=${p.id}" class="btn btn-success">Update</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

<%@include file="footer.jsp"%>

