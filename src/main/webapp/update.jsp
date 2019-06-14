<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table {
            margin: 50px auto 0 auto;
            border-collapse: collapse;
            text-align: center;
            vertical-align: center;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            width: 100px;
            height: 30px;
        }
        .cell {
            display: inline-block;
            margin-right: 50px;
        }
        .row {
            margin: 0 auto;
            width: 800px;
        }
        .row + .row {
            margin-top: 30px;
        }
        .row:nth-of-type(1) {
            margin-top: 100px;
        }
        .row:nth-of-type(5) {
            margin-bottom: 100px;
        }
        label {
            display: inline-block;
            width: 50px;
            font-weight: bold;
            margin-right: 10px;
        }

        input {
            height: 25px;
            width: 250px;
        }
        button {
            width: 150px;
            height: 40px;
            background-color: rgba(22, 155, 213, 1);
            border-radius: 10px;
            border: 0;
            margin-left: 60px;
        }
    </style>
</head>
<body>
<div id="top">
    <form action="servlet/UpdateServlet" method="get">
        <div class="row">
            <div class="cell">
                <label for="empNo">empNo</label><input type="text" name="empNo" id="empNo" value=${param.empNo}<%--"<%=request.getParameter("empNo")%>"--%>>
            </div>
            <div class="cell">
                <label for="eName">eName</label><input type="text" name="eName" id="eName" value=${param.eName}<%--"<%=request.getParameter("eName")%>"--%>>
            </div>
        </div>
        <div class="row">
            <div class="cell">
                <label for="job">job</label><input type="text" name="job" id="job" value=${param.job}<%--"<%=request.getParameter("job")%>"--%>>
            </div>
            <div class="cell">
                <label for="mgr">mgr</label><input type="text" name="mgr" id="mgr" value=${param.mgr}<%--"<%=request.getParameter("mgr")%>"--%>>
            </div>
        </div>
        <div class="row">
            <div class="cell">
                <label for="hireDate">hire</label><input type="text" name="hireDate" id="hireDate" value=${param.hireDate}<%--"<%=request.getParameter("hireDate")%>"--%>>
            </div>
            <div class="cell">
                <label for="sal">salary</label><input type="text" name="sal" id="sal" value=${param.sal}<%--"<%=request.getParameter("sal")%>"--%>>
            </div>
        </div>
        <div class="row">
            <div class="cell">
                <label for="com">comm</label><input type="text" name="com" id="com" value=${param.com}<%--"<%=request.getParameter("com")%>"--%>>
            </div>
            <div class="cell">
                <label for="deptNo">deptNo</label><input type="text" name="deptNo" id="deptNo" value=${param.deptNo}<%--"<%=request.getParameter("deptNo")%>"--%>>
            </div>
        </div>

        <div class="row">
            <button type="submit">确定</button>
        </div>
    </form>
</div>


</body>
</html>