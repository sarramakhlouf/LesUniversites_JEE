<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
    content="text/html; charset=windows-1256">
<title>Modification des Universites</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp"%>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">Modification des Universites</div>
            <div class="card-body">
                <form action="update.do" method="post">
                    <div class="form-group">
                        <label class="control-label">ID Universite :</label> 
                        <input readonly type="text" name="id" class="form-control" value="${universite.idUni}" /> 
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nom Universite :</label> 
                        <input type="text" name="nom" class="form-control" value="${universite.nomUni}" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Adresse :</label> 
                        <input type="text" name="adresse" class="form-control" value="${universite.adresseUni}" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Email :</label> 
                        <input type="text" name="email" class="form-control" value="${universite.email}" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nombre d' Etudiants :</label> 
                        <input type="text" name="nbEtudiants" class="form-control" value="${universite.nbEtudiants}" />
                    </div>
                    <div>
                        <button type="submit" class="btn btn-primary">Modifier</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
