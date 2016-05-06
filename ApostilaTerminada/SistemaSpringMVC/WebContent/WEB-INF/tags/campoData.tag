<%@ attribute name="id" required="true" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

<input id="${id}" name="${id}" />

<script>
  $("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>