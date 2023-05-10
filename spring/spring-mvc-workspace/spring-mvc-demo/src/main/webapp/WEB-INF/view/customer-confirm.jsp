<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Customer Confirmation</title>
</head>

<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free passes is: ${customer.freePasses}


<br><br>

Postal Code is: ${customer.postalCode}
<br><br>

Course code: ${customer.courseCode}
</body>

</html>


