

$(document).ready( function () {
	
	$('#kharchaTable').DataTable({
		  "paging": true,
	      "lengthChange": false,
	      "searching": false,
	      "ordering": false,
	      "bInfo" : false,
	      "info": true,
	      "pagingType": "numbers",
	      "pageLength": 4,
	      "autoWidth": false
	      
	});
	
	//datatable
	var table = $('#example1').DataTable({
		    
    	 "language": {
    		 		search: '<i class="fa fa-search" type="search"></i>',
    		 		searchPlaceholder: "Search"
    			 },
    	
    	 "columnDefs": [ {
             "targets": 'no-sort',
             "orderable": false,
       } ]
     });
    
	//total for quantity and rate
     $('#rate, #quantity').on('input',function(){
    	    var rate = parseFloat($('#rate').val()) || 0;
    	    var quantity = parseFloat($('#quantity').val()) || 0;

    	    $('#total').val(rate * quantity);    
     });
     
   //remaining for delivered and quantity
     $('#delivered, #quantity').on('input',function(){
    	    var delivered = parseFloat($('#delivered').val()) || 0;
    	    var quantity = parseFloat($('#quantity').val()) || 0;

    	    $('#remaining').val(quantity - delivered);    
     });
     
   //remaining for amount and total amount
     $('#amount, #total_amount').on('input',function(){
 	    var amount = parseFloat($('#amount').val()) || 0;
 	    var total = parseFloat($('#total_amount').val()) || 0;

 	    $('#remaining').val(total - amount);    
     });
     
     
     // default value for datepicker
     function dateToYMD(date) {
    	    var d = date.getDate();
    	    var m = date.getMonth() + 1; 
    	    var y = date.getFullYear();
    	    return (m<=9 ? '0' + m : m)+ '/' + (d <= 9 ? '0' + d : d)+'/' + y ;
    	}
     
     $('#date').datepicker({
    	 uiLibrary: 'bootstrap4', 
    	 iconsLibrary: 'fontawesome'
    	 
 	});
     
     if ($('#date').val() == '')
     { 
    	 $('#date').val(dateToYMD(new Date()));
     }
     
     // datatable print button append in navbar div
     var buttons = new $.fn.dataTable.Buttons(table, {
    	 dom: {
    		    button: {
    		      className: 'btn btn-primary fa fa-print'
    		    }
    		  },
    	 buttons: [{
	    	 extend: 'print',
	    	 autoPrint: false,
             exportOptions: {
            	 columns: ':not(:last-child)'
             },
             
	     }],
    }).container().appendTo($('#btnPrint'));
     
  // kharcha table
     
   
      
    
});

