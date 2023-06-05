<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Product Discount Calculator</title>
</head>
<body>
<form action="/display-discount" method="post">
  <table>
    <tr>
      <td><label>Product Description: </label></td>
      <td><input type="text" name="description"></td>
    </tr>
    <tr>
      <td><label>List Price: </label></td>
      <td><input type="number" step="0.01" name="price"></td>
    </tr>
    <tr>
      <td><label>Discount Percent(%): </label></td>
      <td><input type="number" step="0.01" name="discount"><br></td>
    </tr>
  </table>
  <input type="submit" value="Calculate Discount">
</form>
</body>
</html>