function loadTable() {
  const xhttp = new XMLHttpRequest();
  xhttp.open("GET", "http://localhost:8080/indi/books");
  xhttp.send();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
      var trHTML = ''; 
      const objects = JSON.parse(this.responseText);
      for (let object of objects) {
        trHTML += '<tr>'; 
        trHTML += '<td>'+object['bid']+'</td>';
        trHTML += '<td>'+object['bname']+'</td>';
        trHTML += '<td>'+object['pdate']+'</td>';
        trHTML += '<td>'+object['genre']+'</td>';
        trHTML += '<td>'+object['rating']+'</td>';
		trHTML += '<td>'+object['authName']+'</td>';
		trHTML += '<td>'+object['bdate']+'</td>';
		trHTML += '<td>'+object['bplace']+'</td>';
		trHTML += '<td>'+object['emailId']+'</td>';
		
        trHTML += "</tr>";
      }
      document.getElementById("mytable").innerHTML = trHTML;
    }
  };
}

loadTable();