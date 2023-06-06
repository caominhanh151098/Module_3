<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Simple Calculator</title>
</head>
<body>
<c:if test="${message != null}">
  <h3>${message}</h3>
</c:if>
<h1>Simple Calculator</h1>
<form action="/calculator" method="post">
  <fieldset>
    <legend>Calculator</legend>
      <table>
      <tr>
        <td><label for="o1">First operand: </label></td>
        <td><input type="number" step="0.001" name="o1" id="o1"></td>
      </tr>
      <tr>
        <td><label for="op">First operand: </label></td>
        <td>
          <select name="op" id="op">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
          </select>
        </td>
      </tr>
      <tr>
        <td><label for="o2">First operand: </label></td>
        <td><input type="number" step="0.001" name="o2" id="o2"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Calculate"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>